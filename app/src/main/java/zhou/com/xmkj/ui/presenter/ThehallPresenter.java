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
import zhou.com.xmkj.bean.ShareSalesBean;
import zhou.com.xmkj.ui.activity.current.ThehallActivity;
import zhou.com.xmkj.ui.activity.personmessage.TipActivity;
import zhou.com.xmkj.ui.contract.ThehallContract;
import zhou.com.xmkj.ui.contract.TipContract;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class ThehallPresenter extends RxPresenter<ThehallContract.View> implements ThehallContract.Presenter<ThehallContract.View> {

    ThehallActivity tipActivity;
    XmkjApi xmkjApi;

    public ThehallPresenter(ThehallActivity tipActivity){
        this.tipActivity = tipActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getShareIndex() {
        LoginBean loginBean = App.getInstance().getLoginBean();
        Subscription subscribe = xmkjApi.getShareIndex(loginBean.getData().getId(),loginBean.getData().getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShareSalesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(ShareSalesBean shareSalesBean) {
                        mView.getShareIndexSuccess(shareSalesBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
