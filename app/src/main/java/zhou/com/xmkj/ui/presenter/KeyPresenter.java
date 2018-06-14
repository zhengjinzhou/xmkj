package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.activity.vrch.KeyActivity;
import zhou.com.xmkj.ui.contract.KeyContract;
import zhou.com.xmkj.ui.contract.LoginContract;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class KeyPresenter extends RxPresenter<KeyContract.View> implements KeyContract.Presenter<KeyContract.View> {

    KeyActivity keyActivity;
    XmkjApi xmkjApi;

    public KeyPresenter(KeyActivity keyActivity){
        this.keyActivity = keyActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void editKey() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.editKey(loginBean.getData().getId(),loginBean.getData().getToken(),
                getAccessKey(),getSecretKey())
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
                        mView.editKeySuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getAccessKey() {
        return mView.setAccessKey();
    }

    @Override
    public String getSecretKey() {
        return mView.setSecretKey();
    }
}
