package zhou.com.xmkj.ui.activity.setting;


import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

public class SetZhiActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;

    public static Intent newIntent(Context context, String mobile) {
        Intent intent = new Intent(context, SetZhiActivity.class);
        intent.putExtra("MOBILE",mobile);
        return intent;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_set_zhi;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("");
    }
}
