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
import zhou.com.xmkj.ui.contract.VrchInContract;
import zhou.com.xmkj.ui.presenter.VrchInPresenter;
import zhou.com.xmkj.ui.presenter.VrchOutPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * vrch转入
 */
public class VrchInActivity extends BaseActivity implements VrchInContract.View{

    private static final String TAG = "VrchInActivity-vrch转入";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etJinE) EditText etJinE;
    private VrchInPresenter mPresenter = new VrchInPresenter(this);
    @Override
    public int getLayout() {
        return R.layout.activity_vrch_in;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.vrch_in);
        mPresenter.attachView(this);
    }

    @OnClick({R.id.ivBack,R.id.btIn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.btIn:
                if (TextUtils.isEmpty(etJinE.getText().toString())){
                    ToastUtils.showLongToast("金额不能为空");
                    return;
                }
                dialog.show();
                mPresenter.vrchIn();
                break;
        }
    }

    @Override
    public void vrchInSuccess(BaseBean baseBean) {
        Log.d(TAG, "vrchOutSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            finish();
        }
    }

    @Override
    public String setamount() {
        return etJinE.getText().toString().trim();
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
