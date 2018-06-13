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
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.ui.activity.SpeedActivity;
import zhou.com.xmkj.ui.activity.personmessage.TipActivity;
import zhou.com.xmkj.ui.contract.SpeedContract;
import zhou.com.xmkj.ui.contract.TipContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class SpeedPresenter extends RxPresenter<SpeedContract.View> implements SpeedContract.Presenter<SpeedContract.View> {


    SpeedActivity speedActivity;
    XmkjApi xmkjApi;

    public SpeedPresenter(SpeedActivity speedActivity){
        this.speedActivity = speedActivity;
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
    public void getRewardDetail() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.getRewardDetail(loginBean.getData().getId(),loginBean.getData().getToken(),
                getPage(),getPageSize())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RewardDetailBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(RewardDetailBean rewardDetailBean) {
                        mView.getRewardDetailSuccess(rewardDetailBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
