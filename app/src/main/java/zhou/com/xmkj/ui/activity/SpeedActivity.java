package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.ui.adapter.MyBaseAdapter;
import zhou.com.xmkj.ui.adapter.SpeedAdapter;
import zhou.com.xmkj.ui.contract.SpeedContract;
import zhou.com.xmkj.ui.presenter.SpeedPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 待加速界面
 */
public class SpeedActivity extends BaseActivity implements SpeedContract.View{

    private static final String TAG = "SpeedActivity-待加速界面";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private SpeedPresenter mPresenter = new SpeedPresenter(this);
    private SpeedAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_speed;
    }

    @Override
    public void initData() {
        ArrayList<RewardDetailBean.DataBean.ListBean> data = new ArrayList<>();
        adapter = new SpeedAdapter(mContext,R.layout.recycler_speed,data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void configView() {
        tvHead.setText("待加速");
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getRewardDetail();
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }

    @Override
    public int setPage() {
        return 1;
    }

    @Override
    public int setPageSize() {
        return 15;
    }

    @Override
    public void getRewardDetailSuccess(RewardDetailBean rewardDetailBean) {
        Log.d(TAG, "getRewardDetailSuccess: "+rewardDetailBean.toString());
        if (rewardDetailBean.getCode()==200){
            List<RewardDetailBean.DataBean.ListBean> list = rewardDetailBean.getData().getList();
            if (list.size()==0){
                ToastUtils.showLongToast("待加速数据为空");
                return;
            }
            adapter.add(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
