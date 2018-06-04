package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.ui.activity.RealNameAuthenticationActivity;
import zhou.com.xmkj.ui.activity.RegisterActivity;
import zhou.com.xmkj.ui.contract.RealNameContract;
import zhou.com.xmkj.ui.contract.RegisterContract;

/**
 * Created by zhou
 * on 2018/6/4.
 */

public class RealNamePresenter extends RxPresenter<RealNameContract.View> implements RealNameContract.Presenter<RealNameContract.View> {

    RealNameAuthenticationActivity registerActivity;
    XmkjApi xmkjApi;

    public RealNamePresenter(RealNameAuthenticationActivity registerActivity){
        this.registerActivity = registerActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public String getRealname() {
        return null;
    }

    @Override
    public String getIdCard() {
        return null;
    }

    @Override
    public String getIdcardFront() {
        return null;
    }

    @Override
    public String getIdcardBack() {
        return null;
    }

    @Override
    public void userCertificate() {

    }
}
