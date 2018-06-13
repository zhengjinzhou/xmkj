package zhou.com.xmkj.ui.activity.setting;

import android.content.Context;
import android.content.Intent;
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
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.contract.SetPsdContract;
import zhou.com.xmkj.ui.presenter.CurrentPresneter;
import zhou.com.xmkj.ui.presenter.SetPsdPresenter;
import zhou.com.xmkj.utils.ToastUtils;

//密码设置界面-第二个界面
//密码规范还没写好，。稍后待续

public class SetPsdActivity extends BaseActivity implements SetPsdContract.View {

    private static String TAG = "SetPsdActivity-密码设置界面-第二个界面";
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etApassword)
    EditText etApassword;
    private SetPsdPresenter mPresenter = new SetPsdPresenter(this);
    @BindView(R.id.tvHead)
    TextView tvHead;

    public static Intent newIntent(Context context, String mobile) {
        Intent intent = new Intent(context, SetPsdActivity.class);
        intent.putExtra("MOBILE", mobile);
        return intent;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_set_psd;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("设置支付密码");
        mPresenter.attachView(this);
    }

    @OnClick({R.id.btSubmit, R.id.ivBack})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;

            case R.id.btSubmit://下一步
                if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
                    ToastUtils.showLongToast("密码不能为空");
                    return;
                }
                if (etPassword.getText().toString().length() < 6) {
                    ToastUtils.showLongToast("密码不能少于6位");
                    return;
                }
                if (TextUtils.isEmpty(etApassword.getText().toString().trim())) {
                    ToastUtils.showLongToast("确认密码不能为空");
                    return;
                }
                if (!etPassword.getText().toString().trim().equals(etApassword.getText().toString().trim())) {
                    ToastUtils.showLongToast("两次密码不一致");
                    return;
                }
                dialog.show();
                mPresenter.setNewPassword();
                break;
        }
    }

    @Override
    public String setPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public String Aspassword() {
        return etApassword.getText().toString().trim();
    }

    @Override
    public String setMobile() {
        return getIntent().getStringExtra("MOBILE");
    }

    @Override
    public void setNewPasswordSuccess(BaseBean baseBean) {
        Log.d(TAG, "setNewPasswordSuccess: " + baseBean.toString());

        if (baseBean.getCode() == 200) {
            ToastUtils.showLongToast("修改成功，请重新登录");
            startToActivity(LoginActivity.class);
            finish();
        } else {
            ToastUtils.showLongToast(baseBean.getMsg());
        }
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
