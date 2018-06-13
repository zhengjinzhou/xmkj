package zhou.com.xmkj.ui.activity.current;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import zhou.com.xmkj.ui.contract.SunContract;
import zhou.com.xmkj.ui.presenter.SunPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 转成注册链界面
 */
public class CurrentRegisterActivity extends BaseActivity implements SunContract.View{

    private static String TAG = "CurrentRegisterActivity-转成注册链";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etJinE) EditText etJinE;
    private SunPresenter mPresenter = new SunPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_current_register;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        tvHead.setText("转成注册链");
    }

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                if (TextUtils.isEmpty(etJinE.getText().toString())){
                    ToastUtils.showLongToast("输入金额不能为空");
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("转成");
                builder.setMessage("是否确认转成注册链");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        dialog.show();
                        mPresenter.userExchange();
                    }
                });
                builder.create().show();
                break;
        }
    }

    @Override
    public void userExchangeSuccess(BaseBean baseBean) {
        Log.d(TAG, "userExchangeSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            finish();
        }
    }

    @Override
    public int setType() {
        return 2;
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
}
