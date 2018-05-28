package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.contract.UserInfoContract;
import zhou.com.xmkj.ui.fragment.MyFragment;
import zhou.com.xmkj.utils.MD5;

/**
 * Created by zhou on 2018/5/28.
 */

public class UserInfoPresenter extends RxPresenter<UserInfoContract.View> implements UserInfoContract.Presenter<UserInfoContract.View> {

    MyFragment myFragment;
    XmkjApi xmkjApi;

    public UserInfoPresenter(MyFragment myFragment){
        this.myFragment = myFragment;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }


    @Override
    public void getUserInfo() {
        Subscription subscription = xmkjApi.getUserInfo(getId(), getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserInfoBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        mView.getUserInfoSuccess(userInfoBean);
                    }
                });
        addSubscrebe(subscription);
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
