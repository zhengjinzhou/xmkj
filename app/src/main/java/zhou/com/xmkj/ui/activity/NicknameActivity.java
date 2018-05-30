package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;

public class NicknameActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.etNickName) EditText etNickName;

    @Override
    public int getLayout() {
        return R.layout.activity_nickname;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {

    }

    @OnClick({R.id.ivBack,R.id.btSubmit}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btSubmit:
                break;
        }
    }
}
