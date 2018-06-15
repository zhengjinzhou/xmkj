package zhou.com.xmkj.ui.activity.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

public class SetLanguageActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.ivChina1) ImageView ivChina1;
    @BindView(R.id.ivChina2) ImageView ivChina2;
    @BindView(R.id.ivEnglish) ImageView ivEnglish;

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

    @OnClick({R.id.rlChina1,R.id.rlChina2,R.id.rlEnglish,R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.rlChina1:
                setTab(0);
                break;
            case R.id.rlChina2:
                setTab(1);
                break;
            case R.id.rlEnglish:
                setTab(2);
                break;
            case R.id.ivBack:
                finish();
                break;
        }
    }

    /**
     * 选择与隐藏
     * @param pos
     */
    private void setTab(int pos) {
        switch (pos){
            case 0:
                ivChina2.setVisibility(View.GONE);
                ivEnglish.setVisibility(View.GONE);
                ivChina1.setVisibility(View.VISIBLE);
                break;
            case 1:
                ivChina1.setVisibility(View.GONE);
                ivEnglish.setVisibility(View.GONE);
                ivChina2.setVisibility(View.VISIBLE);
                break;
            case 2:
                ivChina1.setVisibility(View.GONE);
                ivChina2.setVisibility(View.GONE);
                ivEnglish.setVisibility(View.VISIBLE);
                break;
        }
    }
}
