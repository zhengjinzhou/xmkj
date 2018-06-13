package zhou.com.xmkj.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseFragment;

/**
 * Created by zhou on 2018/5/28.
 * 动态
 */

public class DynamicFragment extends BaseFragment {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.ivBack) ImageView ivBack;

    @Override
    public int getLayout() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {
        tvHead.setText(R.string.txt_dynamic);
        ivBack.setVisibility(View.GONE);
    }
}
