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
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.ui.contract.SpeedContract;
import zhou.com.xmkj.ui.contract.SunContract;

/**
 * Created by zhou
 * on 2018/6/13.
 * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
 */

public class SunPresenter extends RxPresenter<SunContract.View> implements SunContract.Presenter<SunContract.View> {

    Context mContext;
    XmkjApi xmkjApi;

    public SunPresenter(Context mContext) {
        this.mContext = mContext;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void userExchange() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.userExchange(loginBean.getData().getId(),loginBean.getData().getToken(),
                getType(),getMoney())
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
                        mView.userExchangeSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public int getType() {
        return mView.setType();
    }

    @Override
    public String getMoney() {
        return mView.setMoney();
    }
}
