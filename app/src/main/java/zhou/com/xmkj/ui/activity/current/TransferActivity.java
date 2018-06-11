package zhou.com.xmkj.ui.activity.current;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

/**
 * 流通转账界面
 *
 */
public class TransferActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_transfer;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("会员转账");
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
