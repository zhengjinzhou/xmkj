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
import zhou.com.xmkj.bean.TradingBean;
import zhou.com.xmkj.bean.VrchInfoBean;
import zhou.com.xmkj.ui.activity.current.TradingActivity;
import zhou.com.xmkj.ui.activity.vrch.VRCHActivity;
import zhou.com.xmkj.ui.contract.TradingContract;
import zhou.com.xmkj.ui.contract.WalletContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class TradingPresenter extends RxPresenter<TradingContract.View> implements TradingContract.Presenter<TradingContract.View> {

    TradingActivity vrchActivity;
    XmkjApi xmkjApi;

    public TradingPresenter(TradingActivity vrchActivity) {
        this.vrchActivity = vrchActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getExchangeDetail() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.getExchangeDetail(data.getId(), data.getToken(),getPage(),getPageSize())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TradingBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TradingBean tradingBean) {
                        mView.getExchangeDetailSuccess(tradingBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public int getPage() {
        return mView.setPage();
    }

    @Override
    public int getPageSize() {
        return mView.setPageSize();
    }
}
