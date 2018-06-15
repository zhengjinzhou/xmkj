package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.ui.contract.RegisterContract;
import zhou.com.xmkj.ui.presenter.RegisterPresenter;
import zhou.com.xmkj.utils.CountDownTimerUtils;
import zhou.com.xmkj.utils.PhoneUtil;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity implements RegisterContract.View{

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etMan) EditText etMan;
    @BindView(R.id.etMobile) EditText etMobile;
    @BindView(R.id.eEmail) EditText eEmail;
    @BindView(R.id.etPsd) EditText etPsd;
    @BindView(R.id.checkbox) CheckBox checkbox;
    @BindView(R.id.tvCode) TextView tvCode;
    boolean isCheck = false;

    private RegisterPresenter mPrester = new RegisterPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {
        if (App.getInstance().getLoginBean()!=null){
            etMan.setText(App.getInstance().getUserInfoBean().getData().getUsername());
        }
    }

    @Override
    public void configView() {
        tvHead.setText(R.string.register);
        mPrester.attachView(this);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheck = b;
            }
        });
    }

    @OnClick({R.id.ivBack,R.id.btRegister,R.id.tvCode,R.id.tvAgreement})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAgreement:
                startToActivity(AgreementActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.btRegister:
                if (TextUtils.isEmpty(etMobile.getText().toString().trim())){
                    ToastUtils.showLongToast("手机号码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(eEmail.getText().toString().trim())){
                    ToastUtils.showLongToast("二维码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etPsd.getText().toString().trim())){
                    ToastUtils.showLongToast("密码不能为空");
                    return;
                }

                if (!isCheck){
                    ToastUtils.showLongToast("请勾选用户协议");
                    return;
                }
                dialog.show();
                mPrester.Register();
                break;
            case R.id.tvCode:
                if (!PhoneUtil.isPhoneNumber(etMobile.getText().toString().trim())){
                    ToastUtils.showLongToast("请输入正确手机号码");
                    return;
                }
                CountDownTimerUtils timerUtils = new CountDownTimerUtils(tvCode, 60000, 1000);
                timerUtils.start();
                mPrester.getCodeNum();
                break;
        }
    }

    @Override
    public void RegisterSuccess(BaseBean baseBean) {
        dialog.dismiss();
        if (baseBean.getCode()==200){
            ToastUtils.showLongToast(baseBean.getMsg());
            startToActivity(LoginActivity.class);
        }else {
            ToastUtils.showLongToast(baseBean.getMsg());
        }
    }

    @Override
    public void getCodeNumSuccess(BaseBean baseBean) {
        if (baseBean.getCode()==200){
            ToastUtils.showLongToast(baseBean.getMsg());
        }
    }

    @Override
    public String setMobile() {
        return etMobile.getText().toString().trim();
    }

    @Override
    public String setCode() {
        return eEmail.getText().toString().trim();
    }

    @Override
    public String setPassword() {
        return etPsd.getText().toString().trim();
    }

    @Override
    public String getPusername() {
        return etMan.getText().toString().trim();
    }

    @Override
    public boolean setCheckBox() {
        return isCheck;
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

}
