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
import zhou.com.xmkj.bean.AddAddressBean;
import zhou.com.xmkj.ui.contract.AddAddressContract;
import zhou.com.xmkj.ui.presenter.AddAddressPresenter;
import zhou.com.xmkj.utils.PhoneUtil;
import zhou.com.xmkj.utils.ToastUtils;

public class AddAddressActivity extends BaseActivity implements AddAddressContract.View {

    private static final String TAG = "AddAddressActivity";
    @BindView(R.id.etMan) EditText etMan;
    @BindView(R.id.etPhone) EditText etPhone;
    @BindView(R.id.etAddress) EditText etAddress;
    @BindView(R.id.tvHead) TextView tvHead;
    private AddAddressPresenter mPresenter = new AddAddressPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_add_address;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("添加收货地址");
        mPresenter.attachView(this);
    }

    @OnClick({R.id.btAdd, R.id.ivBack})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.btAdd:
                if (TextUtils.isEmpty(etMan.getText().toString())) {
                    ToastUtils.showLongToast("收货人不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    ToastUtils.showLongToast("联系电话不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etAddress.getText().toString())) {
                    ToastUtils.showLongToast("详细地址不能为空");
                    return;
                }
                if (!PhoneUtil.isPhoneNumber(etPhone.getText().toString())){
                    ToastUtils.showLongToast("请输入正确手机号码");
                    return;
                }
                dialog.show();
                mPresenter.addUserAddress();
                break;
        }
    }

    @Override
    public void addUserAddressSuccess(AddAddressBean addAddressBean) {
        Log.d(TAG, "addUserAddressSuccess: " + addAddressBean.toString());
        ToastUtils.showLongToast(addAddressBean.getMsg());
        if (addAddressBean.getCode()==200){
            finish();
        }
    }

    @Override
    public String setUsername() {
        return etMan.getText().toString();
    }

    @Override
    public String setMobile() {
        return etPhone.getText().toString();
    }

    @Override
    public String setAddress() {
        return etAddress.getText().toString();
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
