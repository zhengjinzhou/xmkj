package zhou.com.xmkj.base;

import android.app.Application;
import android.content.Context;

import com.qiniu.android.common.FixedZone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.UserInfoBean;

/**
 * Created by zhou on 2018/5/25.
 */

public class App extends Application {

    private static App app;
    private static Context mContext;
    protected LoginBean loginBean;
    protected UserInfoBean userInfoBean;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mContext = this;
        ZXingLibrary.initDisplayOpinion(this);
        qiniu();
    }

    private void qiniu() {
        Configuration config = new Configuration.Builder()
                .chunkSize(512 * 1024)        // 分片上传时，每片的大小。 默认256K
                .putThreshhold(1024 * 1024)   // 启用分片上传阀值。默认512K
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
                .recorder(null)           // recorder分片上传时，已上传片记录器。默认null
                .recorder(null, null)   // keyGen 分片上传时，生成标识符，用于片记录器区分是那个文件的上传记录
                .zone(FixedZone.zone0)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();
        // 重用uploadManager。一般地，只需要创建一个uploadManager对象
        UploadManager uploadManager = new UploadManager(config);
    }

    public static App getInstance(){
        return app;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public static Context getAppContext() {
        return mContext;
    }

    public UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public void setUserInfoBean(UserInfoBean userInfoBean) {
        this.userInfoBean = userInfoBean;
    }
}
