package zhou.com.xmkj.base;

import android.app.Application;
import android.content.Context;

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
