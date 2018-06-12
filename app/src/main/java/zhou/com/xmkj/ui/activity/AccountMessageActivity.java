package zhou.com.xmkj.ui.activity;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

/**
 * Created by zhou on 2018/5/28.
 * 账户信息
 */

public class AccountMessageActivity extends BaseActivity{

    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_account_message;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("设置账户信息");
    }
    @OnClick({R.id.ivBack})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
        }
    }

}
