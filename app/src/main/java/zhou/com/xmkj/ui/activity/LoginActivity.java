package zhou.com.xmkj.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.ui.contract.LoginContract;
import zhou.com.xmkj.ui.presenter.LoginPresenter;
import zhou.com.xmkj.utils.ToastUtils;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    private static final String TAG = "LoginActivity";
    @BindView(R.id.ivBack) ImageView ivBack;
    private LoginPresenter mPresenter = new LoginPresenter(this);
    @BindView(R.id.etUsername) EditText etUsername;
    @BindView(R.id.etPsd) EditText etPsd;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        ivBack.setVisibility(View.GONE);
        mPresenter.attachView(this);
    }

    @OnClick({R.id.btLogin,R.id.ivLook})
    void onClick(View view){
        switch (view.getId()){
            case R.id.btLogin:
                mPresenter.login();
                break;
            case R.id.ivLook:
                break;
        }
    }


    @Override
    public void loginSuccess(LoginBean loginBean) {

        Log.d(TAG, "loginSuccess: "+loginBean.toString());
    }

    @Override
    public String setUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String setPasswrod() {
        return etPsd.getText().toString();
    }

    @Override
    public void showError() {
        ToastUtils.showLongToast("系统出错！");
    }

    @Override
    public void complete() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
