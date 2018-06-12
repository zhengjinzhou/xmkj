package zhou.com.xmkj.ui.activity.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

public class SetLanguageActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_set_language;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("语言设置");
    }
}
