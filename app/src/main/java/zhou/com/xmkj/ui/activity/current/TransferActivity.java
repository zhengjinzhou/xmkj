package zhou.com.xmkj.ui.activity.current;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.InvestBean;
import zhou.com.xmkj.ui.contract.TransferContract;
import zhou.com.xmkj.ui.presenter.TransferPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 流通转账界面
 * intrade/investIndex
 */
public class TransferActivity extends BaseActivity implements TransferContract.View {

    private static final String TAG = "TransferActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvMsg) TextView tvMsg;
    @BindView(R.id.etNumber) EditText etNumber;
    @BindView(R.id.etJinE) EditText etJinE;
    private String txData;
    @BindView(R.id.tvLeft) TextView tvLeft;
    @BindView(R.id.tvLeftMoney) TextView tvLeftMoney;
    @BindView(R.id.tvRight) TextView tvRight;
    @BindView(R.id.tvRightMoney) TextView tvRightMoney;

    private TransferPresenter mPresenter = new TransferPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_transfer;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        tvHead.setText("流通转账");
        dialog.show();
        mPresenter.getInvestIndex();
    }

    @OnClick({R.id.ivBack, R.id.rlType, R.id.btSubmit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSubmit:
                if (TextUtils.isEmpty(etNumber.getText().toString())){
                    ToastUtils.showLongToast("请输入会员编号");
                    return;
                }
                if (TextUtils.isEmpty(etJinE.getText().toString())){
                    ToastUtils.showLongToast("金额不能为空");
                    return;
                }
                if (TextUtils.isEmpty(txData)){
                    ToastUtils.showLongToast("转账不能为空");
                    return;
                }
                dialog.show();
                mPresenter.userTransfer();
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlType:
                final List<String> mData = new ArrayList<>();
                mData.add("流通子链");
                mData.add("注册链");
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        txData = mData.get(options1);
                        tvMsg.setText(txData);
                    }
                }).build();
                pickerView.setPicker(mData);
                pickerView.show();
                break;
        }
    }

    @Override
    public void getInvestIndexSuccess(InvestBean indexBean) {
        Log.d(TAG, "getInvestIndexSuccess: "+indexBean.toString());
        if (indexBean.getCode()==200){
            tvLeft.setText(indexBean.getData().getWalletName1());
            tvLeftMoney.setText(indexBean.getData().getWalletMoney1());
            tvRight.setText(indexBean.getData().getWalletName2());
            tvRightMoney.setText(indexBean.getData().getWalletMoney2());
        }
    }

    @Override
    public void userTransferSuccess(BaseBean baseBean) {
        Log.d(TAG, "userTransferSuccess: "+baseBean);
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            finish();
        }
    }

    @Override
    public int setType() {
        int pos = 2;
        if (txData.equals("注册链")){
            pos = 5;
        }
        return pos;
    }

    @Override
    public String setUserName() {
        return etNumber.getText().toString();
    }

    @Override
    public String setMoney() {
        return etJinE.getText().toString();
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
