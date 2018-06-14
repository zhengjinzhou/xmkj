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
import zhou.com.xmkj.bean.InvestBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.activity.current.TransferActivity;
import zhou.com.xmkj.ui.contract.TransferContract;
import zhou.com.xmkj.ui.contract.UserInfoContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class TransferPresenter extends RxPresenter<TransferContract.View> implements TransferContract.Presenter<TransferContract.View> {

    TransferActivity vrchActivity;
    XmkjApi xmkjApi;

    public TransferPresenter(TransferActivity vrchActivity) {
        this.vrchActivity = vrchActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }


    @Override
    public void getInvestIndex() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.getInvestIndex(loginBean.getData().getId(),loginBean.getData().getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<InvestBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(InvestBean baseBean) {
                        mView.getInvestIndexSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    /**
     * 流通转账
     * 转账类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
     */
    @Override
    public void userTransfer() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.userTransfer(loginBean.getData().getId(),loginBean.getData().getToken(),getType(),getUserName(),getMoney())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("--------------", "onError: "+e.getMessage());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        mView.userTransferSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public int getType() {
        return mView.setType();
    }

    @Override
    public String getUserName() {
        return mView.setUserName();
    }


    @Override
    public String getMoney() {
        return mView.setMoney();
    }
}
