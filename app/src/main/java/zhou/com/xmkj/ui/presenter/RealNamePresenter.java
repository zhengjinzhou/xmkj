package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.IntradeBean;
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
        return mView.setId();
    }

    @Override
    public String getToken() {
        return mView.setToken();
    }

    @Override
    public String getRealname() {
        return mView.setRealname();
    }

    @Override
    public String getIdCard() {
        return mView.setIdCard();
    }

    @Override
    public String getIdcardFront() {
        return mView.setIdcardFront();
    }

    @Override
    public String getIdcardBack() {
        return mView.setIdcardBack();
    }

    @Override
    public void userCertificate() {
        Subscription subscribe = xmkjApi.getuserCertificate(getId(), getToken(),getRealname(),getIdCard(),getIdcardFront(),getIdcardBack())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        mView.userCertificateSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
