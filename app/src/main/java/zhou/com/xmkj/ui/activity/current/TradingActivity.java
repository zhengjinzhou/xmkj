package zhou.com.xmkj.ui.activity.current;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

/**
 * 转换交易
 */
public class TradingActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_trading;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("转换交易");
    }

    @OnClick({R.id.ivBack, R.id.rlSun, R.id.rlRegister})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlSun:
                startToActivity(SunActivity.class);
                break;
            case R.id.rlRegister:
                startToActivity(CurrentRegisterActivity.class);
                break;
        }
    }


}
