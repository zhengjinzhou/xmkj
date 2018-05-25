package zhou.com.xmkj.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import zhou.com.xmkj.bean.LoginBean;

/**
 * Created by zhou on 2018/5/25.
 */

public interface XmkjApiService {

    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("login/login")
    Observable<LoginBean>
    login(@Field("username")String username,@Field("password") String password);
}
