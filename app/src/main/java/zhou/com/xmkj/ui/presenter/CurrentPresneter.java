package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.IntradeBean;
import zhou.com.xmkj.ui.activity.CurrentActivity;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.contract.CurrentContract;
import zhou.com.xmkj.ui.contract.FansContract;

/**
 * Created by zhou
 * on 2018/5/31.
 */

public class CurrentPresneter extends RxPresenter<CurrentContract.View> implements CurrentContract.Presenter<CurrentContract.View> {

    CurrentActivity currentActivity;
    XmkjApi xmkjApi;

    public CurrentPresneter(CurrentActivity currentActivity){
        this.currentActivity = currentActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getIntrade() {
        Subscription subscribe = xmkjApi.getIntrade(getId(), getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<IntradeBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(IntradeBean intradeBean) {
                        mView.getIntradeSuccess(intradeBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public int getId() {
        return mView.setId();
    }

    @Override
    public String getToken() {
        return mView.setToken();
    }
}
