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
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.MyMessageActivity;
import zhou.com.xmkj.ui.activity.UserInfoActivity;
import zhou.com.xmkj.ui.contract.UserContract;
import zhou.com.xmkj.ui.contract.UserInfoContract;
import zhou.com.xmkj.ui.fragment.MyFragment;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public class UserPresenter extends RxPresenter<UserContract.View> implements UserContract.Presenter<UserContract.View> {

    UserInfoActivity userInfoActivity;
    XmkjApi xmkjApi;

    public UserPresenter(UserInfoActivity userInfoActivity){
        this.userInfoActivity = userInfoActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public String getAvater() {
        return mView.setAvater();
    }

    @Override
    public String getGender() {
        return mView.setGender();
    }

    @Override
    public void editUserSuccess() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscription = xmkjApi.editUserInfo(loginBean.getData().getId()+"",loginBean.getData().getToken(),getAvater(),"",getGender(),"","","","")
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
                    public void onNext(BaseBean userInfoBean) {
                        mView.editUserSuccess(userInfoBean);
                    }
                });
        addSubscrebe(subscription);
    }
}
