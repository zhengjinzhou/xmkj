package zhou.com.xmkj.ui.fragment.fans;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.presenter.FansPresenter;

/**
 * Created by zhou on 2018/5/30.
 * 分享
 */

public class FansShareFragment extends BaseFragment{
    private FansPresenter mPresenter = new FansPresenter((FansActivity) mContext);

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.recycle;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {

    }
}
