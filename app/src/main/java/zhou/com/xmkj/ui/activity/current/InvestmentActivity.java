package zhou.com.xmkj.ui.activity.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import zhou.com.xmkj.ui.contract.InvestmentContract;
import zhou.com.xmkj.ui.presenter.InvestmentPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 流通投资界面-1
 */
public class InvestmentActivity extends BaseActivity implements InvestmentContract.View{

    private static String TAG = "InvestmentActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etUsername) EditText etUsername;
    @BindView(R.id.tvContent) TextView tvContent;
    private String txPos;
    private InvestmentPresenter mPresenter = new InvestmentPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_investment;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        tvHead.setText("完善信息");
    }

    @OnClick({R.id.ivBack, R.id.rlSelect,R.id.btNext})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlSelect:
                final List<String> mData = new ArrayList<>();
                mData.add("A区");
                mData.add("B区");
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        txPos = mData.get(options1);
                        tvContent.setText(txPos);
                    }
                }).build();
                pickerView.setPicker(mData);
                pickerView.show();
                break;
            case R.id.btNext:
                if (TextUtils.isEmpty(txPos)){
                    ToastUtils.showLongToast("市场位置不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etUsername.getText().toString())){
                    ToastUtils.showLongToast("接点人不能为空");
                    return;
                }
                dialog.show();
                mPresenter.updateUserVip();
                break;
        }
    }

    @Override
    public String setRname() {
        return etUsername.getText().toString();
    }

    @Override
    public int setPos() {
        int pos = 1;
        if (txPos.equals("B区")){
            pos = 2;
        }
        return pos;
    }

    @Override
    public void updateUserVipSuccess(BaseBean baseBean) {
        Log.d(TAG, "updateUserVipSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            startToActivity(Investment2Activity.class);
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
