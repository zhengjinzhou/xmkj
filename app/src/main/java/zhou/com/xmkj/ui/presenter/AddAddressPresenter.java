package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.AddAddressBean;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.activity.AddAddressActivity;
import zhou.com.xmkj.ui.activity.AddressActivity;
import zhou.com.xmkj.ui.contract.AddAddressContract;
import zhou.com.xmkj.ui.contract.AddressContract;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class AddAddressPresenter extends RxPresenter<AddAddressContract.View> implements AddAddressContract.Presenter<AddAddressContract.View> {

    AddAddressActivity addAddressActivity;
    XmkjApi xmkjApi;

    public AddAddressPresenter(AddAddressActivity addAddressActivity){
        this.addAddressActivity = addAddressActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void addUserAddress() {
        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        Subscription subscribe = xmkjApi.addUserAddress(data.getId(), data.getToken(), getUsername(), getMobile(),getAddress())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddAddressBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(AddAddressBean addressBean) {
                        mView.addUserAddressSuccess(addressBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getUsername() {
        return mView.setUsername();
    }

    @Override
    public String getMobile() {
        return mView.setMobile();
    }

    @Override
    public String getAddress() {
        return mView.setAddress();
    }
}
