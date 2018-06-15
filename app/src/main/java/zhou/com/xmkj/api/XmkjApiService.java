package zhou.com.xmkj.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import zhou.com.xmkj.bean.AddAddressBean;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.IndexBean;
import zhou.com.xmkj.bean.IntradeBean;
import zhou.com.xmkj.bean.InvestBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.MyFansBean;
import zhou.com.xmkj.bean.QiNiuBean;
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.bean.ShareSalesBean;
import zhou.com.xmkj.bean.TradingBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.bean.VrchInfoBean;
import zhou.com.xmkj.bean.WalletBean;
import zhou.com.xmkj.bean.WalletMoreBean;

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


    @GET("common/uploadToken")
    Call<QiNiuBean> uploadToken();

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
     * 验证验证码
     *
     * @param mobile
     * @param code
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("common/checkVerifyCode")
    Observable<BaseBean>
    checkVerifyCode(@Field("mobile") String mobile,
                    @Field("code") String code,
                    @Field("type") String type);

    /**
     * 修改密码-找回密码
     *
     * @param mobile
     * @param password
     * @param aspassword
     * @return
     */
    @FormUrlEncoded
    @POST("login/setNewPassword")
    Observable<BaseBean> setNewPassword(
            @Field("mobile") String mobile,
            @Field("password") String password,
            @Field("aspassword") String aspassword);

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
     *
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
    getFansList(@Field("id") int id,
                @Field("token") String token,
                @Field("page") int page,
                @Field("pagesize") int pagesize,
                @Field("type") int type);

    /**
     * 获取流通交易数据
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/index")
    Observable<IntradeBean>
    getIntrade(@Field("id") int id,
               @Field("token") String token);

    /**
     * 身份认证
     *
     * @param id
     * @param token
     * @param page
     * @param idcard
     * @param idcard_front
     * @param idcard_back
     * @return
     */
    @FormUrlEncoded
    @POST("user/userCertificate")
    Observable<BaseBean>
    getuserCertificate(@Field("id") String id,
                       @Field("token") String token,
                       @Field("realname") String page,
                       @Field("idcard") String idcard,
                       @Field("idcard_front") String idcard_front,
                       @Field("idcard_back") String idcard_back);

    /**
     * 主界面
     *
     * @return
     */
    @GET("home/index")
    Observable<IndexBean>
    getIndex();

    /**
     * 多参数上传
     * 不定数参数
     * 修改个人信息
     * @return
     */
    @FormUrlEncoded
    @POST("user/editUserInfo")
    Observable<BaseBean>
    editUserInfo(@Field("id") String id,
                 @Field("token") String token,
                 @Field("avatar") String avatar,
                 @Field("nickname") String nickname,
                 @Field("gender") String gender,
                 @Field("signature") String signature,
                 @Field("email") String email,
                 @Field("password") String password,
                 @Field("paypwd") String paypwd);

    /**
     * 获取收货地址
     *
     * @param id
     * @param token
     * @param page
     * @param pagesize
     * @return
     */
    @FormUrlEncoded
    @POST("user/getAddressList")
    Observable<AddressBean>
    getAddressList(@Field("id") int id,
                   @Field("token") String token,
                   @Field("page") int page,
                   @Field("pagesize") int pagesize);


    /**
     * 强制退出
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("login/logout")
    Observable<BaseBean>
    Logout(@Field("id") int id, @Field("token") String token);

    /**
     * vrch交易信息
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("outtrade/getVrchInfo")
    Observable<VrchInfoBean>
    getVrchInfo(@Field("id") int id, @Field("token") String token);

    /**
     * vrch转入
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("outtrade/vrchInto")
    Observable<BaseBean> vrchInto(@Field("id") int id, @Field("token") String token, @Field("amount") String amount);

    /**
     * vrch转出
     *
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("outtrade/vrchOut")
    Observable<BaseBean> vrchOut(@Field("id") int id, @Field("token") String token, @Field("amount") String amount);

    /**
     * 加速明细
     * @param id
     * @param token
     * @param page
     * @param pagesize
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/getRewardDetail")
    Observable<RewardDetailBean>
    getRewardDetail(@Field("id") int id, @Field("token") String token,@Field("page") int page, @Field("pagesize") int pagesize);

    /**
     * 钱包明细
     * 钱包类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
     * @param id
     * @param token
     * @param page
     * @param pagesize
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/getWalletDetail")
    Observable<WalletMoreBean>
    getRewardMore(@Field("id") int id, @Field("token") String token,@Field("page") int page, @Field("pagesize") int pagesize,@Field("type")int type);


    /**
     * 交易大厅首页
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/getShareIndex")
    Observable<ShareSalesBean>getShareIndex(@Field("id") int id, @Field("token") String token);

    /**
     * 获取用户钱包
     *
     * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
     * @param id
     * @param token
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("user/getUserWallet")
    Observable<WalletBean>
    getUserWallet(@Field("id") int id, @Field("token") String token,@Field("type") int type);

    /**
     * 转换交易明细
     *
     * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
     * @param id
     * @param token
     * @param page
     * @param pagesize
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/getExchangeDetail")
    Observable<TradingBean> getExchangeDetail(@Field("id") int id, @Field("token") String token,@Field("page") int page, @Field("pagesize") int pagesize);

    /**
     * 转换交易
     * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
     * @param id
     * @param token
     * @param type
     * @param money
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/userExchange")
    Observable<BaseBean>
    userExchange(@Field("id") int id, @Field("token") String token,@Field("type") int type, @Field("money") String money);

    /**
     * 升级VIP/完善信息
     * @param id
     * @param token
     * @param rname
     * @param pos
     * @return
     */
    @FormUrlEncoded
    @POST("user/updateUserVip")
    Observable<BaseBean>
    updateUserVip(@Field("id") int id, @Field("token") String token,@Field("rname") String rname, @Field("pos") int pos);

    /**
     *
     * @param id
     * @param token
     * @param type
     * @param username
     * @param money
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/userTransfer")
    Observable<BaseBean>
    userTransfer(@Field("id") int id, @Field("token") String token,@Field("type") int type, @Field("username") String username,@Field("money")String money);

    /**
     * 获取流通投资首页
     * @param id
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("intrade/transferIndex")
    Observable<InvestBean>
    getInvestIndex(@Field("id") int id, @Field("token") String token);

    /**
     * 添加收获地址
     * @param id
     * @param token
     * @param username
     * @param mobile
     * @param address
     * @return
     */
    @FormUrlEncoded
    @POST("user/addUserAddress")
    Observable<AddAddressBean>
    addUserAddress(@Field("id") int id,
                   @Field("token") String token,
                   @Field("username") String username,
                   @Field("mobile") String mobile,
                   @Field("address") String address);

    /**
     *
     * @param id
     * @param token
     * @param access_key
     * @param secret_key
     * @return
     */
    @FormUrlEncoded
    @POST("outtrade/editKey")
    Observable<BaseBean>
    editKey(@Field("id") int id,
            @Field("token") String token,
            @Field("access_key") String access_key,
            @Field("secret_key") String secret_key);

    /**
     * 删除收货地址
     *
     * @param id
     * @param token
     * @param pid
     * @return
     */
    @FormUrlEncoded
    @POST("user/delUserAddress")
    Observable<BaseBean>
    delUserAddress(@Field("id") int id,
            @Field("token") String token,
            @Field("pid") int pid);
}
