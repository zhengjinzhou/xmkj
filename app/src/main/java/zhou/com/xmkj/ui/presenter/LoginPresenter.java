package zhou.com.xmkj.ui.presenter;

import android.text.TextUtils;
import android.util.Log;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.R;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.QiNiuBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.contract.LoginContract;
import zhou.com.xmkj.utils.MD5;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou on 2018/5/25.
 * 登录
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View>{

    LoginActivity loginActivity;
    XmkjApi xmkjApi;

    public LoginPresenter(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }
    @Override
    public void login() {
        Subscription subscription = xmkjApi.login(getUsername(), MD5.md5(getPassword()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("-----", "onError: "+e.getMessage());
                        mView.showError();
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mView.loginSuccess(loginBean);
                    }
                });
        addSubscrebe(subscription);
    }

    @Override
    public void uploadToken() {
        xmkjApi.uploadToken().enqueue(new Callback<QiNiuBean>() {
            @Override
            public void onResponse(Call<QiNiuBean> call, Response<QiNiuBean> response) {
                QiNiuBean qiNiuBean = response.body();
                mView.uploadTokenSuccess(qiNiuBean);
            }

            @Override
            public void onFailure(Call<QiNiuBean> call, Throwable t) {
                mView.showError();
            }
        });
    }

    @Override
    public String getUsername() {
        return mView.setUsername();
    }

    @Override
    public String getPassword() {
        return mView.setPasswrod();
    }
}
