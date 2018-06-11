package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.ui.activity.setting.SettingPasswordActivity;
import zhou.com.xmkj.ui.contract.SettingPasswordContract;

/**
 * Created by zhou
 * on 2018/6/11.
 */

public class SettingPasswordPresenter extends RxPresenter<SettingPasswordContract.View> implements SettingPasswordContract.Presenter<SettingPasswordContract.View>{

    SettingPasswordActivity settingPasswordActivity;
    XmkjApi xmkjApi;

    public SettingPasswordPresenter(SettingPasswordActivity settingPasswordActivity){
        this.settingPasswordActivity = settingPasswordActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void getCodeNum() {
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
    public void checkVerifyCode() {
        Subscription subscribe = xmkjApi.getCheckVerifyCode(getMobile(),getCode(),"1")
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
                        mView.checkVerifyCodeSueecss(baseBean);
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public String getMobile() {
        return mView.setMobile();
    }

    @Override
    public String getCode() {
        return mView.setCode();
    }
}
