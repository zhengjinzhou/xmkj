package zhou.com.xmkj.ui.activity.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.LoginActivity;
import zhou.com.xmkj.ui.activity.MainActivity;
import zhou.com.xmkj.ui.contract.SettingContract;
import zhou.com.xmkj.ui.presenter.SettingPresenter;
import zhou.com.xmkj.utils.AppManager;
import zhou.com.xmkj.utils.ToastUtils;

public class SettingActivity extends BaseActivity implements SettingContract.View{

    private static final String TAG = "SettingActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvContent) TextView tvContent;
    @BindView(R.id.tvEmailContent) TextView tvEmailContent;
    private SettingPresenter mPresenter = new SettingPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        AppManager.getAppManager().addActivity(this);
        mPresenter.attachView(this);
        tvHead.setText("设置");
        UserInfoBean userInfoBean = App.getInstance().getUserInfoBean();
        if (userInfoBean!=null){
            tvContent.setText(userInfoBean.getData().getMobile());
            tvEmailContent.setText(userInfoBean.getData().getEmail());
        }
    }

    @OnClick({R.id.ivBack,R.id.rlPassword,R.id.rlZhifu,R.id.rlAbout,R.id.btExit,R.id.rlLanguage})
    void onClick(View view){
        switch (view.getId()){
            case R.id.rlLanguage:
                startToActivity(SetLanguageActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlPassword://密码设置
                startToActivity(SettingPasswordActivity.class);
                break;
            case R.id.rlZhifu://支付设置
                startToActivity(SettingZhifuActivity.class);
                break;
            case R.id.rlAbout://关我我们
                startToActivity(SettingAboutActivity.class);
                break;
            case R.id.btExit://安全退出
                showDialog();
                break;
        }
    }

    /**
     * 退出确定弹出框
     *
     */
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("退出");
        builder.setMessage("您是否要退出应用？");
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                mPresenter.Logout();
            }
        });
        builder.create().show();
    }

    @Override
    public void LogoutSuccess(BaseBean baseBean) {
        Log.d(TAG, "LogoutSuccess: "+baseBean.toString());
        if (baseBean.getCode()==200){
            ToastUtils.showLongToast(baseBean.getMsg());
            AppManager.getAppManager().finishAllActivity();
        }else {
            ToastUtils.showLongToast(baseBean.getMsg());
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
