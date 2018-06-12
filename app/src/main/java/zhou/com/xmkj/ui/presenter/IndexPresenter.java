package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.IndexBean;
import zhou.com.xmkj.ui.activity.current.CurrentActivity;
import zhou.com.xmkj.ui.contract.FansContract;
import zhou.com.xmkj.ui.contract.IndexContract;
import zhou.com.xmkj.ui.fragment.IndexFragment;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class IndexPresenter extends RxPresenter<IndexContract.View> implements IndexContract.Presenter<IndexContract.View>  {

    IndexFragment indexFragment;
    XmkjApi xmkjApi;

    public IndexPresenter(IndexFragment indexFragment){
        this.indexFragment = indexFragment;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getIndex() {
        Subscription subscribe = xmkjApi.getIndex().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<IndexBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getIndexSuccess(indexBean);
                    }
                });
        addSubscrebe(subscribe);
    }
}
