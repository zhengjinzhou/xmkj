package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.register);
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
