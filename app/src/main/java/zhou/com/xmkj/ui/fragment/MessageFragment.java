package zhou.com.xmkj.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseFragment;

/**
 * Created by zhou on 2018/5/28.
 * 消息
 */

public class MessageFragment extends BaseFragment{

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.ivRight2) ImageView ivRight2;
    @BindView(R.id.ivRight) ImageView ivRight;
    @BindView(R.id.ivBack) ImageView ivBack;

    @Override
    public int getLayout() {
        return R.layout.fragment_message;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {
        tvHead.setText(R.string.txt_message);
        ivRight2.setImageResource(R.drawable.header_3);
        ivRight.setImageResource(R.drawable.header_4);
        ivBack.setVisibility(View.GONE);
    }

    @OnClick({R.id.ivRight2,R.id.ivRight}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivRight:
                break;
            case R.id.ivRight2:
                break;
        }
    }
}
