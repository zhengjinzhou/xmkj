package zhou.com.xmkj.ui.activity.setting;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.BuildConfig;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.ui.activity.ForgetActivity;
import zhou.com.xmkj.ui.activity.RegisterActivity;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 关于我们
 */
public class SettingAboutActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvContent) TextView tvContent;

    @Override
    public int getLayout() {
        return R.layout.activity_setting_about;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.about_me);
        tvContent.setText("v"+BuildConfig.VERSION_NAME);
    }

    @OnClick({R.id.ivBack,R.id.rlVersion,R.id.rlScore})
    void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlVersion://版本说明

                break;
            case R.id.rlScore://去评分

                break;
        }
    }
}
