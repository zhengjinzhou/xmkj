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
import zhou.com.xmkj.ui.activity.personmessage.TipActivity;
import zhou.com.xmkj.ui.activity.setting.SettingActivity;
import zhou.com.xmkj.ui.contract.SettingContract;
import zhou.com.xmkj.ui.contract.SettingPasswordContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class SettingPresenter extends RxPresenter<SettingContract.View> implements SettingContract.Presenter<SettingContract.View> {

    SettingActivity tipActivity;
    XmkjApi xmkjApi;

    public SettingPresenter(SettingActivity tipActivity){
        this.tipActivity = tipActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void Logout() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.logout(loginBean.getData().getId(),loginBean.getData().getToken())
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
                        mView.LogoutSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
