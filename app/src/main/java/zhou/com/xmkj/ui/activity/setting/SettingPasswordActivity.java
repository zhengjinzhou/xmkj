package zhou.com.xmkj.ui.activity.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.xmkj.R;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.ui.contract.SettingPasswordContract;
import zhou.com.xmkj.ui.presenter.LoginPresenter;
import zhou.com.xmkj.ui.presenter.SettingPasswordPresenter;
import zhou.com.xmkj.utils.CountDownTimerUtils;
import zhou.com.xmkj.utils.PhoneUtil;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 密码设置界面-第一个界面
 *
 */
public class SettingPasswordActivity extends BaseActivity implements SettingPasswordContract.View{

    private static String TAG = "SettingPasswordActivity-密码设置界面-第一个界面";
    @BindView(R.id.etMobile) EditText etMobile;
    @BindView(R.id.etCode) EditText etCode;
    @BindView(R.id.tvCode) TextView tvCode;
    private SettingPasswordPresenter mPresenter = new SettingPasswordPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_setting_password;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
    }


    @OnClick({R.id.tvCode,R.id.btNext,R.id.ivBack})
    void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.tvCode://获取验证码
                if (!PhoneUtil.isPhoneNumber(etMobile.getText().toString().trim())){
                    ToastUtils.showLongToast("请输入正确手机号码");
                    return;
                }
                CountDownTimerUtils timerUtils = new CountDownTimerUtils(tvCode, 60000, 1000);
                timerUtils.start();
                mPresenter.getCodeNum();
                break;
            case R.id.btNext://下一步
                if (TextUtils.isEmpty(etCode.getText().toString().trim())){
                    ToastUtils.showLongToast("验证码不能为空");
                    return;
                }
                dialog.show();
                mPresenter.checkVerifyCode();
                break;
        }
    }

    @Override
    public void getCodeNumSuccess(BaseBean baseBean) {
        ToastUtils.showLongToast(baseBean.getMsg());
        Log.d(TAG, "getCodeNumSuccess: "+baseBean.toString());
    }

    @Override
    public void checkVerifyCodeSueecss(BaseBean baseBean) {
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            //startToActivity(SetPsdActivity.class);
            startActivity(SetPsdActivity.newIntent(this,etMobile.getText().toString().trim()));
            finish();
        }
        Log.d(TAG, "checkVerifyCodeSueecss: "+baseBean.toString());
    }

    @Override
    public String setMobile() {
        return etMobile.getText().toString().trim();
    }

    @Override
    public String setCode() {
        return etCode.getText().toString().trim();
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
