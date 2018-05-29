package zhou.com.xmkj.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zhou.com.xmkj.base.Constant;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.MyFansBean;
import zhou.com.xmkj.bean.UserInfoBean;

/**
 * Created by zhou on 2018/5/25.
 */

public class XmkjApi {
    public static XmkjApi xmkjApi;
    private XmkjApiService service;
    public XmkjApi(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(XmkjApiService.class);
    }

    public static XmkjApi getInstance(OkHttpClient okHttpClient) {
        if (xmkjApi == null) {
            xmkjApi = new XmkjApi(okHttpClient);
        }
        return xmkjApi;
    }

    public Observable<LoginBean> login(String username,String password){
        return service.login(username,password);
    }

    public Observable<UserInfoBean> getUserInfo(String id,String token){
        return service.getUserInfo(id,token);
    }

    public Observable<MyFansBean> getIndex(String id,String token){
        return service.getIndex(id,token);
    }

    public Observable<BaseBean> getCodeNum(String mobile){
        return service.getCodeNum(mobile);
    }

    public Observable<BaseBean> register(String mobile,String code,String password,String pusername){
        return service.register(mobile,code,password,pusername);
    }
}
