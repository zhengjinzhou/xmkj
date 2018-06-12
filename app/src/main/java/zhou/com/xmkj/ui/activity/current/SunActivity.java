package zhou.com.xmkj.ui.activity.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.utils.ToastUtils;

public class SunActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etTip) EditText etTip;

    @Override
    public int getLayout() {
        return R.layout.activity_sun;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("转成交易子链");
    }

    @OnClick({R.id.ivBack, R.id.btSubmit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:

                break;
        }
    }
}
