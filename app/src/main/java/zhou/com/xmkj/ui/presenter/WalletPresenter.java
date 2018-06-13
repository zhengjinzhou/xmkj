package zhou.com.xmkj.ui.presenter;

import android.content.Context;

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
import zhou.com.xmkj.bean.WalletBean;
import zhou.com.xmkj.ui.activity.vrch.VRCHActivity;
import zhou.com.xmkj.ui.contract.VRCHContract;
import zhou.com.xmkj.ui.contract.WalletContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class WalletPresenter extends RxPresenter<WalletContract.View> implements WalletContract.Presenter<WalletContract.View> {

    Context mContext;
    XmkjApi xmkjApi;

    public WalletPresenter(Context mContext) {
        this.mContext = mContext;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public int getType() {
        return mView.setType();
    }

    @Override
    public void getUserWallet() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.getUserWallet(data.getId(), data.getToken(),getType())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WalletBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(WalletBean walletBean) {
                        mView.getUserWalletSuccess(walletBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
