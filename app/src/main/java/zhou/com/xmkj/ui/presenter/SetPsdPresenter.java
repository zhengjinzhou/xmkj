package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.activity.setting.SetPsdActivity;
import zhou.com.xmkj.ui.contract.FansContract;
import zhou.com.xmkj.ui.contract.SetPsdContract;

/**
 * Created by zhou
 * on 2018/6/11.
 */

public class SetPsdPresenter extends RxPresenter<SetPsdContract.View> implements SetPsdContract.Presenter<SetPsdContract.View> {

    SetPsdActivity setPsdActivity;
    XmkjApi xmkjApi;

    public SetPsdPresenter(SetPsdActivity setPsdActivity){
        this.setPsdActivity = setPsdActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public String getPassword() {
        return mView.setPassword();
    }

    @Override
    public String getAspassword() {
        return mView.Aspassword();
    }

    @Override
    public String getMobile() {
        return mView.setMobile();
    }

    @Override
    public void setNewPassword() {
        Subscription subscribe = xmkjApi.setNewPassword(getMobile(),getPassword(),getAspassword())
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
                        mView.setNewPasswordSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
