package zhou.com.xmkj.ui.activity.setting;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.UserInfoBean;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvContent) TextView tvContent;
    @BindView(R.id.tvEmailContent) TextView tvEmailContent;


    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("设置");
        UserInfoBean userInfoBean = App.getInstance().getUserInfoBean();
        if (userInfoBean!=null){
            tvContent.setText(userInfoBean.getData().getMobile());
            tvEmailContent.setText(userInfoBean.getData().getEmail());
        }
    }

    @OnClick({R.id.ivBack,R.id.rlPassword,R.id.rlZhifu,R.id.rlAbout,R.id.btExit})
    void onClick(View view){
        switch (view.getId()){
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
                break;
        }
    }
}
