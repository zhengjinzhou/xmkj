package zhou.com.xmkj.ui.presenter;

import android.util.Log;

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
import zhou.com.xmkj.bean.TradingBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.activity.current.InvestmentActivity;
import zhou.com.xmkj.ui.contract.InvestmentContract;
import zhou.com.xmkj.ui.contract.LoginContract;
import zhou.com.xmkj.utils.MD5;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class InvestmentPresenter extends RxPresenter<InvestmentContract.View> implements InvestmentContract.Presenter<InvestmentContract.View> {

    InvestmentActivity investmentActivity;
    XmkjApi xmkjApi;

    public InvestmentPresenter(InvestmentActivity investmentActivity){
        this.investmentActivity = investmentActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void updateUserVip() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.updateUserVip(data.getId(), data.getToken(),getRname(),getPos())
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
                    public void onNext(BaseBean tradingBean) {
                        mView.updateUserVipSuccess(tradingBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getRname() {
        return mView.setRname();
    }

    @Override
    public int getPos() {
        return mView.setPos();
    }
}
