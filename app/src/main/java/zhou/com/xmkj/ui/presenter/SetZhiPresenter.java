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
import zhou.com.xmkj.ui.activity.setting.SetZhiActivity;
import zhou.com.xmkj.ui.contract.SetZhiContract;
import zhou.com.xmkj.ui.contract.TipContract;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class SetZhiPresenter extends RxPresenter<SetZhiContract.View> implements SetZhiContract.Presenter<SetZhiContract.View> {

    SetZhiActivity tipActivity;
    XmkjApi xmkjApi;

    public SetZhiPresenter(SetZhiActivity tipActivity){
        this.tipActivity = tipActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public String getPaypwd() {
        return mView.setPaypwd();
    }

    @Override
    public void editUserInfo() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.editUserInfo(loginBean.getData().getId()+"",loginBean.getData().getToken(),
                "","","","","","",getPaypwd())
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
                        mView.editUserInfoSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
