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
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.ui.contract.ZhifuContract;
import zhou.com.xmkj.ui.presenter.SettingPasswordPresenter;
import zhou.com.xmkj.ui.presenter.ZhiFuPresenter;
import zhou.com.xmkj.utils.CountDownTimerUtils;
import zhou.com.xmkj.utils.PhoneUtil;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 支付设置-第一个界面
 */
public class SettingZhifuActivity extends BaseActivity implements ZhifuContract.View{
    private static String TAG = "SettingPasswordActivity-密码设置界面-第一个界面";
    @BindView(R.id.etMobile) EditText etMobile;
    @BindView(R.id.etCode) EditText etCode;
    @BindView(R.id.tvCode) TextView tvCode;
    private ZhiFuPresenter mPresenter = new ZhiFuPresenter(this);
    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_setting_password;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("安全验证");
        mPresenter.attachView(this);
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
            startActivity(SetZhiActivity.newIntent(this,etMobile.getText().toString().trim()));
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
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
