package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.MyFansBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.activity.MyFansActivity;
import zhou.com.xmkj.ui.contract.LoginContract;
import zhou.com.xmkj.ui.contract.MyFansContract;

/**
 * Created by zhou on 2018/5/29.
 */

public class MyFansPresenter extends RxPresenter<MyFansContract.View> implements MyFansContract.Presenter<MyFansContract.View> {

    MyFansActivity myFansActivity;
    XmkjApi xmkjApi;

    public MyFansPresenter(MyFansActivity myFansActivity){
        this.myFansActivity = myFansActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getIndexFans() {
        Subscription subscribe = xmkjApi.getIndex(getId(), getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyFansBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MyFansBean myFansBean) {
                        mView.getIndexFansSuccess(myFansBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getId() {
        return mView.setId();
    }

    @Override
    public String getToken() {
        return mView.setToken();
    }
}
