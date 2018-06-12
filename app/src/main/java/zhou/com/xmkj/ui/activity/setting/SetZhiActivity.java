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
import zhou.com.xmkj.ui.contract.SetZhiContract;
import zhou.com.xmkj.ui.presenter.SetZhiPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 设置支付密码
 */
public class SetZhiActivity extends BaseActivity implements SetZhiContract.View{

    private static final String TAG = "SetZhiActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etPassword) EditText etPassword;
    @BindView(R.id.etApassword) EditText etApassword;

    private SetZhiPresenter mPresenter = new SetZhiPresenter(this);

    public static Intent newIntent(Context context, String mobile) {
        Intent intent = new Intent(context, SetZhiActivity.class);
        intent.putExtra("MOBILE",mobile);
        return intent;
    }

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                if(TextUtils.isEmpty(etPassword.getText().toString().trim())){
                    ToastUtils.showLongToast("支付密码不能为空");
                    return;
                }
                if (!etPassword.getText().toString().trim().equals(etApassword.getText().toString().trim())){
                    ToastUtils.showLongToast("两次密码不一致");
                    return;
                }
                dialog.show();
                mPresenter.editUserInfo();
                break;
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_set_zhi;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        tvHead.setText("");
    }

    @Override
    public String setPaypwd() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void editUserInfoSuccess(BaseBean baseBean) {
        Log.d(TAG, "editUserInfoSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            finish();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
