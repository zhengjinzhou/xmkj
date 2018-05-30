package zhou.com.xmkj.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.MyFansBean;
import zhou.com.xmkj.bean.UserInfoBean;

/**
 * Created by zhou on 2018/5/25.
 */

public interface XmkjApiService {

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("login/login")
    Observable<LoginBean>
    login(@Field("username") String username, @Field("password") String password);


    /**
     * 获取用户信息-在我的界面这里请求
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("user/getUserInfo")
    Observable<UserInfoBean>
    getUserInfo(@Field("id") String id, @Field("token") String token);

    /**
     * 粉丝首页
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("fans/index")
    Observable<MyFansBean>
    getIndex(@Field("id") String id, @Field("token") String token);

    /**
     * 获取验证码
     *
     * @param mobile
     * @return
     */
    @FormUrlEncoded
    @POST("common/sendcode")
    Observable<BaseBean>
    getCodeNum(@Field("mobile") String mobile);

    /**
     * 注册
     *
     * @param mobile
     * @param code
     * @param password
     * @param pusername
     * @return
     */
    @FormUrlEncoded
    @POST("login/register")
    Observable<BaseBean>
    register(@Field("mobile") String mobile,
             @Field("code") String code,
             @Field("password") String password,
             @Field("pusername") String pusername);

    /**
     * 获取粉丝列表
     * @param id
     * @param token
     * @param page
     * @param pagesize
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("fans/getFansList")
    Observable<FansListBean>
    getFansList(@Field("id")int id,
                @Field("token")String token,
                @Field("page")int page,
                @Field("pagesize")int pagesize,
                @Field("type") int type);
}
