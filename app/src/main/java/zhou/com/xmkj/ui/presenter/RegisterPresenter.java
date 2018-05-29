package zhou.com.xmkj.ui.presenter;

import android.text.TextUtils;
import android.util.Log;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.activity.RegisterActivity;
import zhou.com.xmkj.ui.contract.LoginContract;
import zhou.com.xmkj.ui.contract.RegisterContract;
import zhou.com.xmkj.utils.MD5;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou on 2018/5/29.
 */

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter<RegisterContract.View> {

    RegisterActivity registerActivity;
    XmkjApi xmkjApi;

    public RegisterPresenter(RegisterActivity registerActivity){
        this.registerActivity = registerActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }


    @Override
    public void getCodeNum() {
        if (TextUtils.isEmpty(getMobile())){
            ToastUtils.showLongToast("手机号码不能为空");
            return;
        }
        Subscription subscribe = xmkjApi.getCodeNum(getMobile())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        mView.getCodeNumSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public void Register() {

        Subscription subscribe = xmkjApi.register(getMobile(), getCode(), MD5.md5(getPassword()), getPusername())
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
                       mView.RegisterSuccess(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public boolean getCheckBox() {
        return mView.setCheckBox();
    }

    @Override
    public String getMobile() {
        return mView.setMobile();
    }

    @Override
    public String getCode() {
        return mView.setCode();
    }

    @Override
    public String getPassword() {
        return mView.setPassword();
    }

    @Override
    public String getPusername() {
        return mView.getPusername();
    }
}
