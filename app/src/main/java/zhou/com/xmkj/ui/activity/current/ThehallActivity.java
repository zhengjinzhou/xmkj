package zhou.com.xmkj.ui.activity.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.bean.ShareSalesBean;
import zhou.com.xmkj.bean.WalletBean;
import zhou.com.xmkj.ui.adapter.SpeedAdapter;
import zhou.com.xmkj.ui.adapter.ThehallAdapter;
import zhou.com.xmkj.ui.contract.ThehallContract;
import zhou.com.xmkj.ui.contract.WalletContract;
import zhou.com.xmkj.ui.presenter.ThehallPresenter;
import zhou.com.xmkj.ui.presenter.WalletPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 交易大厅界面
 *
 */
public class ThehallActivity extends BaseActivity implements ThehallContract.View,WalletContract.View{

    private static final String TAG = "ThehallActivity-交易大厅界面";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.tv) TextView tv;
    @BindView(R.id.tvNum)TextView tvNum;
    private ThehallAdapter adapter;
    private ThehallPresenter mPresenter = new ThehallPresenter(this);
    private WalletPresenter walletPresenter = new WalletPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_thehall;
    }

    @Override
    public void initData() {
        ArrayList<ShareSalesBean.DataBean.ListBean> data = new ArrayList<>();
        adapter = new ThehallAdapter(mContext,R.layout.recycler_thehall,data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void configView() {
        tvHead.setText("交易大厅");

        walletPresenter.attachView(this);

        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getShareIndex();

        walletPresenter.getUserWallet();
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }

    @Override
    public void getShareIndexSuccess(ShareSalesBean shareSalesBean) {
        Log.d(TAG, "getShareIndexSuccess: "+shareSalesBean.toString());
        if (shareSalesBean.getCode()==200){
            if (shareSalesBean.getData().getList().size()==0){
                ToastUtils.showLongToast("挂卖记录为空");
                return;
            }
            adapter.add(shareSalesBean.getData().getList());
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
        if (walletPresenter!=null){
            walletPresenter.detachView();
        }
    }

    @Override
    public int setType() {
        //类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
        return 3;
    }

    @Override
    public void getUserWalletSuccess(WalletBean walletBean) {
        Log.d(TAG, "getUserWalletSuccess: "+walletBean.toString());
        if (walletBean.getCode()==200){
            tv.setText(walletBean.getData().getName());
            tvNum.setText(walletBean.getData().getMoney());
        }
    }


}
