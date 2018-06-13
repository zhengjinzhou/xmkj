package zhou.com.xmkj.ui.activity.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 流通投资界面2
 */
public class Investment2Activity extends BaseActivity {
    private static String TAG = "Investment2Activity";
    @BindView(R.id.tvHead)
    TextView tvHead;

    @Override
    public int getLayout() {
        return R.layout.activity_investment2;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText("流通投资");
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
