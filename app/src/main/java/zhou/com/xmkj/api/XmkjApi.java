package zhou.com.xmkj.api;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zhou.com.xmkj.base.Constant;
import zhou.com.xmkj.bean.AddAddressBean;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.IndexBean;
import zhou.com.xmkj.bean.IntradeBean;
import zhou.com.xmkj.bean.InvestBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.MyFansBean;
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

public class XmkjApi {
    public static XmkjApi xmkjApi;
    private XmkjApiService service;

    public XmkjApi(OkHttpClient okHttpClient) {
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

    public Observable<LoginBean> login(String username, String password) {
        return service.login(username, password);
    }

    public Observable<UserInfoBean> getUserInfo(String id, String token) {
        return service.getUserInfo(id, token);
    }

    /**
     * 粉丝主界面
     *
     * @param id
     * @param token
     * @return
     */
    public Observable<MyFansBean> getIndex(String id, String token) {
        return service.getIndex(id, token);
    }

    public Observable<BaseBean> getCodeNum(String mobile) {
        return service.getCodeNum(mobile);
    }

    public Observable<BaseBean> register(String mobile, String code, String password, String pusername) {
        return service.register(mobile, code, password, pusername);
    }

    public Observable<FansListBean> getFansList(int id, String token, int page, int pagesize, int type) {
        return service.getFansList(id, token, page, pagesize, type);
    }

    public Observable<IntradeBean> getIntrade(int id, String token) {
        return service.getIntrade(id, token);
    }

    public Observable<BaseBean>
    getuserCertificate(String id, String token, String realname, String idcard, String idcard_front, String idcard_back) {
        return service.getuserCertificate(id, token, realname, idcard, idcard_front, idcard_back);
    }

    public Observable<BaseBean>
    getCheckVerifyCode(String mobile, String code, String type) {
        return service.checkVerifyCode(mobile, code, type);
    }

    public Observable<BaseBean> setNewPassword(String mobile, String password, String aspassword) {
        return service.setNewPassword(mobile, password, aspassword);
    }

    /**
     * 主界面
     *
     * @return
     */
    public Observable<IndexBean> getIndex() {
        return service.getIndex();
    }

    public Observable<BaseBean> editUserInfo(String id, String token, String avatar, String nickname,
                                             String gender, String signature, String email, String password, String paypwd) {
        return service.editUserInfo(id, token, avatar, nickname, gender, signature, email, password, paypwd);
    }

    public Observable<AddressBean> getAddressList(int id, String token, int page, int pagesize) {
        return service.getAddressList(id, token, page, pagesize);
    }

    public Observable<BaseBean> logout(int id, String token) {
        return service.Logout(id, token);
    }

    public Observable<VrchInfoBean> getVrchInfo(int id, String token) {
        return service.getVrchInfo(id, token);
    }

    public Observable<BaseBean> vrchInto(int id, String token, String amount) {
        return service.vrchInto(id, token, amount);
    }

    public Observable<BaseBean> vrchOut(int id, String token, String amount) {
        return service.vrchOut(id, token, amount);
    }

    public Observable<RewardDetailBean> getRewardDetail(int id, String token, int page, int pagesize) {
        return service.getRewardDetail(id, token, page, pagesize);
    }

    public Observable<WalletMoreBean> getRewardMore(int id, String token, int page, int pagesize, int type) {
        return service.getRewardMore(id, token, page, pagesize, type);
    }

    public Observable<ShareSalesBean> getShareIndex(int id, String token) {
        return service.getShareIndex(id, token);
    }

    public Observable<WalletBean> getUserWallet(int id, String token, int type) {
        return service.getUserWallet(id, token, type);
    }

    public Observable<TradingBean> getExchangeDetail(int id, String token, int page, int pagesize) {
        return service.getExchangeDetail(id, token, page, pagesize);
    }

    public Observable<BaseBean> userExchange(int id, String token, int type, String money) {
        return service.userExchange(id, token, type, money);
    }

    public Observable<BaseBean> updateUserVip(int id, String token, String rname, int pos) {
        return service.updateUserVip(id, token, rname, pos);
    }

    public Observable<BaseBean> userTransfer(int id, String token, int type, String username, String money) {
        return service.userTransfer(id, token, type, username, money);
    }

    public Observable<InvestBean> getInvestIndex(int id, String token) {
        return service.getInvestIndex(id, token);
    }

    public Observable<AddAddressBean> addUserAddress(int id, String token, String username, String mobile, String address) {
        return service.addUserAddress(id, token, username, mobile, address);
    }

    public Observable<BaseBean> editKey(int id, String token, String access_key, String secret_key) {
        return service.editKey(id, token, access_key, secret_key);
    }
}
