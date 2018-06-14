package zhou.com.xmkj.ui.fragment.fans;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.FansActivity;
import zhou.com.xmkj.ui.contract.FansContract;
import zhou.com.xmkj.ui.presenter.FansPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou on 2018/5/30.
 * 分享
 */

public class FansShareFragment extends BaseFragment implements FansContract.View{

    private FansPresenter mPresenter = new FansPresenter((FansActivity) mContext);
    private static String TAG = "FansShareFragment-分享粉丝";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BaseCommonAdapter<FansListBean.DataBean> mAdapter;

    @Override
    public int getLayout() {
        return R.layout.recycle;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {
        mPresenter.getFansList();
        List<FansListBean.DataBean> dataBeans = new ArrayList<>();
        mAdapter = new BaseCommonAdapter<FansListBean.DataBean>(mContext, R.layout.recycler_fans, dataBeans) {
            @Override
            public void convert(ViewHolder holder, FansListBean.DataBean dataBean, int position) {
                if (dataBean.getList().size()==0){
                    ToastUtils.showLongToast("粉丝数量为空！");
                    holder.getView(R.id.rlFans).setVisibility(View.GONE);
                    return;
                }
                ImageView ivAvater = holder.getView(R.id.ivAvater);
                Glide.with(mContext).load(dataBean.getList().get(position).getAvatar()).into(ivAvater);
                holder.setText(R.id.tvUserName,dataBean.getList().get(position).getUsername());
                holder.setText(R.id.tvNickName,dataBean.getList().get(position).getNickname());
                holder.setText(R.id.tvTime,dataBean.getList().get(position).getCreatetime());
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void getFansListSuccess(FansListBean fansListBean) {
        Log.d(TAG, "getFansListSuccess: "+fansListBean.toString());
        FansListBean.DataBean data = fansListBean.getData();
        mAdapter.clear();
        mAdapter.add(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int setId() {
        return App.getInstance().getLoginBean().getData().getId();
    }

    @Override
    public String setToken() {
        return App.getInstance().getLoginBean().getData().getToken();
    }

    @Override
    public int setPage() {
        return 1;
    }

    @Override
    public int setType() {
        return 2;
    }

    @Override
    public int PageSize() {
        return 10;
    }

    @Override
    public void showError() {
    }

    @Override
    public void complete() {
    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null)
            mPresenter.detachView();
        super.onDestroy();
    }
}
