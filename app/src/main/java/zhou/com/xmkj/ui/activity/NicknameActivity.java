package zhou.com.xmkj.ui.activity;

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
import zhou.com.xmkj.ui.contract.NicknameContract;
import zhou.com.xmkj.ui.presenter.NicknamePresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 昵称设置
 */
public class NicknameActivity extends BaseActivity implements NicknameContract.View{

    private static final String TAG = "NicknameActivity-";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etNickName) EditText etNickName;
    private NicknamePresenter mPresenter = new NicknamePresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_nickname;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("昵称设置");
        mPresenter.attachView(this);
    }

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                if (TextUtils.isEmpty(etNickName.getText().toString())){
                    ToastUtils.showLongToast("空昵称无效");
                    return;
                }
                dialog.show();
                mPresenter.editUserInfo();
                break;
        }
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
    public String setNickname() {
        return etNickName.getText().toString();
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
