package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.contract.FansContract;

/**
 * Created by zhou on 2018/5/30.
 */

public class FansPresenter extends RxPresenter<FansContract.View> implements FansContract.Presenter<FansContract.View> {

    FansActivity fansActivity;
    XmkjApi xmkjApi;

    public FansPresenter(FansActivity fansActivity){
        this.fansActivity = fansActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getFansList() {
        Subscription subscribe = xmkjApi.getFansList(getId(), getToken(), getPage(), getPageSize(), getType())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FansListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(FansListBean fansListBean) {
                        mView.getFansListSuccess(fansListBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public int getId() {
        return mView.setId();
    }

    @Override
    public String getToken() {
        return mView.setToken();
    }

    @Override
    public int getPage() {
        return mView.setPage();
    }

    @Override
    public int getType() {
        return mView.setType();
    }

    @Override
    public int getPageSize() {
        return mView.PageSize();
    }
}
