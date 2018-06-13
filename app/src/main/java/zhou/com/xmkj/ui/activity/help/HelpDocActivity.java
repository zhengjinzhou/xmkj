package zhou.com.xmkj.ui.activity.help;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

public class HelpDocActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.activity_help_doc;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.help_doc);
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
