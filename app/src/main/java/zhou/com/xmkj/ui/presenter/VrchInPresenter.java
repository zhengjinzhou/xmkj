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
import zhou.com.xmkj.ui.activity.setting.SettingZhifuActivity;
import zhou.com.xmkj.ui.activity.vrch.VrchInActivity;
import zhou.com.xmkj.ui.contract.VRCHContract;
import zhou.com.xmkj.ui.contract.VrchInContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class VrchInPresenter extends RxPresenter<VrchInContract.View> implements VrchInContract.Presenter<VrchInContract.View> {

    VrchInActivity vrchInActivity;
    XmkjApi xmkjApi;

    public VrchInPresenter(VrchInActivity vrchInActivity){
        this.vrchInActivity = vrchInActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void vrchIn() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.vrchOut(data.getId(), data.getToken(),getamount())
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
                        mView.vrchInSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getamount() {
        return mView.setamount();
    }
}
