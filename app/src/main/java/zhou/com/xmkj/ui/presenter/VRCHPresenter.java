package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.VrchInfoBean;
import zhou.com.xmkj.ui.activity.vrch.VRCHActivity;
import zhou.com.xmkj.ui.contract.VRCHContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class VRCHPresenter extends RxPresenter<VRCHContract.View> implements VRCHContract.Presenter<VRCHContract.View> {

    VRCHActivity vrchActivity;
    XmkjApi xmkjApi;

    public VRCHPresenter(VRCHActivity vrchActivity) {
        this.vrchActivity = vrchActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getVrchInfo() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.getVrchInfo(data.getId(), data.getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VrchInfoBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(VrchInfoBean vrchInfoBean) {
                        mView.getVrchInfoSuccess(vrchInfoBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
