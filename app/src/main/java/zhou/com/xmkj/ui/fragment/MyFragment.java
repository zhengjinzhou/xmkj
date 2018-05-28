package zhou.com.xmkj.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.MainMuenSpacingItemDecoration;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.bean.MyBaseBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.CodeActivity;
import zhou.com.xmkj.ui.activity.HelpActivity;
import zhou.com.xmkj.ui.activity.MyNewsActivity;
import zhou.com.xmkj.ui.activity.RealNameAuthenticationActivity;
import zhou.com.xmkj.ui.activity.RegisterActivity;
import zhou.com.xmkj.ui.contract.UserInfoContract;
import zhou.com.xmkj.ui.presenter.UserInfoPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou on 2018/5/28.
 * 我的
 */

public class MyFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,UserInfoContract.View{

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.ivBack) ImageView ivBack;
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.refreshableView) SwipeRefreshLayout refreshableView;
    public static String TAG = "MyFragment-我的";
    private UserInfoPresenter mPresenter = new UserInfoPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void attachView() {
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initData() {
        List<MyBaseBean> data = new ArrayList<>();
        data.add(new MyBaseBean(MyNewsActivity.class,getString(R.string.my_news),R.drawable.icon_11));
        data.add(new MyBaseBean(RealNameAuthenticationActivity.class,getString(R.string.txt_real_name_authentication),R.drawable.icon_47));
        data.add(new MyBaseBean(CodeActivity.class,getString(R.string.txt_my_code),R.drawable.icon_10));
        data.add(new MyBaseBean(RegisterActivity.class,getString(R.string.txt_register),R.drawable.icon_9));
        data.add(new MyBaseBean(HelpActivity.class,getString(R.string.txt_help_center),R.drawable.icon_7));
        BaseCommonAdapter adapter = new BaseCommonAdapter<MyBaseBean>(getContext(), R.layout.recycle_my, data) {
            @Override
            public void convert(ViewHolder holder, final MyBaseBean baseBean, int position) {
                holder.setText(R.id.tv_name,baseBean.getName());
                holder.setImageResource(R.id.iv_icon,baseBean.getIcon());
                holder.setOnClickListener(R.id.layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startToActivity(baseBean.getaClass());
                    }
                });
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void configViews() {
        ivBack.setVisibility(View.GONE);
        tvHead.setText(R.string.txt_my_fragment);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        refreshableView.setRefreshing(true);
        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSuccess(UserInfoBean userInfoBean) {
        Log.d(TAG, "getUserInfoSuccess: "+userInfoBean.toString());
    }

    @Override
    public String setId() {
        return App.getInstance().getLoginBean().getData().getId()+"";
    }

    @Override
    public String setToken() {
        return App.getInstance().getLoginBean().getData().getToken();
    }

    @Override
    public void showError() {
        ToastUtils.showLongToast("系统出错");
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
