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
import zhou.com.xmkj.bean.WalletBean;
import zhou.com.xmkj.bean.WalletMoreBean;
import zhou.com.xmkj.ui.activity.current.Vrch_SunActivity;
import zhou.com.xmkj.ui.contract.WalletContract;
import zhou.com.xmkj.ui.contract.WalletMoreContract;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class WalletMorePresenter extends RxPresenter<WalletMoreContract.View> implements WalletMoreContract.Presenter<WalletMoreContract.View>  {

    Vrch_SunActivity vrch_sunActivity;
    XmkjApi xmkjApi;

    public WalletMorePresenter(Vrch_SunActivity vrch_sunActivity) {
        this.vrch_sunActivity = vrch_sunActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public int getPage() {
        return mView.setPage();
    }

    @Override
    public int getPageSize() {
        return mView.setPageSize();
    }

    @Override
    public int getType() {
        return mView.setType();
    }

    @Override
    public void getWalletMoreDetail() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.getRewardMore(data.getId(), data.getToken(),getPage(),getPageSize(),getType())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WalletMoreBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(WalletMoreBean walletBean) {
                        mView.getWalletMoreSuccess(walletBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
