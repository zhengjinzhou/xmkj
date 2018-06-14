package zhou.com.xmkj.ui.activity.vrch;

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
import zhou.com.xmkj.ui.activity.AddAddressActivity;
import zhou.com.xmkj.ui.contract.KeyContract;
import zhou.com.xmkj.ui.presenter.KeyPresenter;
import zhou.com.xmkj.utils.ToastUtils;

public class KeyActivity extends BaseActivity implements KeyContract.View{

    private static final String TAG = "KeyActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etaccess_key) EditText etaccess_key;
    @BindView(R.id.etsecret_key) EditText etsecret_key;
    private KeyPresenter mPresenter = new KeyPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_key;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("设置");
        mPresenter.attachView(this);
    }

    @Override
    public String setAccessKey() {
        return etaccess_key.getText().toString();
    }

    @Override
    public String setSecretKey() {
        return etsecret_key.getText().toString();
    }

    @Override
    public void editKeySuccess(BaseBean baseBean) {
        Log.d(TAG, "editKeySuccess: "+baseBean.toString());
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

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                if (TextUtils.isEmpty(etaccess_key.getText().toString())){
                    ToastUtils.showLongToast("etaccess_key的不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etsecret_key.getText().toString())){
                    ToastUtils.showLongToast("etsecret_key的不能为空");
                    return;
                }
                dialog.show();
                mPresenter.editKey();
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
