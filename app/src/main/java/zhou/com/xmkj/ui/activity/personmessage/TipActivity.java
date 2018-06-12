package zhou.com.xmkj.ui.activity.personmessage;

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
import zhou.com.xmkj.ui.contract.TipContract;
import zhou.com.xmkj.ui.presenter.TipPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 个性签名界面
 */
public class TipActivity extends BaseActivity implements TipContract.View {

    private static final String TAG = "TipActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etTip)EditText etTip;
    private TipPresenter mPresenter = new TipPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_tip;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.tip_setting);
        mPresenter.attachView(this);
    }

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                String string = etTip.getText().toString();
                if (TextUtils.isEmpty(string)){
                    ToastUtils.showLongToast("空签名无效！");
                    return;
                }
                dialog.show();
                mPresenter.editUserInfo();
                break;
        }
    }

    @Override
    public void editUserInfoSuccess(BaseBean baseBean) {
        dialog.dismiss();
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            finish();
        }
        Log.d(TAG, "editUserInfoSuccess: "+baseBean.toString());
    }

    @Override
    public String setTip() {
        return etTip.getText().toString();
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
