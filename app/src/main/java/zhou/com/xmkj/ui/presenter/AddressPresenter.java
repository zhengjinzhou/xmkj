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
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.activity.AddressActivity;
import zhou.com.xmkj.ui.activity.current.CurrentActivity;
import zhou.com.xmkj.ui.contract.AddressContract;
import zhou.com.xmkj.ui.contract.CurrentContract;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class AddressPresenter extends RxPresenter<AddressContract.View> implements AddressContract.Presenter<AddressContract.View> {

    AddressActivity currentActivity;
    XmkjApi xmkjApi;

    public AddressPresenter(AddressActivity currentActivity){
        this.currentActivity = currentActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getAddressList() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.getAddressList(data.getId(), data.getToken(), getPage(), getPageSize())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(AddressBean addressBean) {
                        mView.getAddressListSuccess(addressBean);
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

    @Override
    public void delUserAddress(int pid) {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.delUserAddress(data.getId(), data.getToken(),pid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        mView.delUserAddressSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }


}
