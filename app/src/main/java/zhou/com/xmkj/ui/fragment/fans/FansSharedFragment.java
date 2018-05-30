package zhou.com.xmkj.ui.fragment.fans;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.contract.FansContract;
import zhou.com.xmkj.ui.presenter.FansPresenter;

/**
 * Created by zhou on 2018/5/30.
 * 共享
 */

public class FansSharedFragment extends BaseFragment implements FansContract.View{

    private FansPresenter mPresenter = new FansPresenter((FansActivity) mContext);
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

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

    @Override
    public void getFansListSuccess(FansListBean fansListBean) {

    }

    @Override
    public int setId() {
        return 0;
    }

    @Override
    public String setToken() {
        return null;
    }

    @Override
    public int setPage() {
        return 0;
    }

    @Override
    public int setType() {
        return 0;
    }

    @Override
    public int PageSize() {
        return 0;
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
