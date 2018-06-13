package zhou.com.xmkj.ui.activity.current;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.ui.adapter.TradingAdapter;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.TradingBean;
import zhou.com.xmkj.bean.WalletBean;
import zhou.com.xmkj.ui.contract.TradingContract;
import zhou.com.xmkj.ui.contract.WalletContract;
import zhou.com.xmkj.ui.presenter.TradingPresenter;
import zhou.com.xmkj.ui.presenter.WalletPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 转换交易
 */
public class TradingActivity extends BaseActivity implements WalletContract.View,TradingContract.View{

    private static final String TAG = "TradingActivity-转换交易";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tv) TextView tv;
    @BindView(R.id.tvNum) TextView tvNum;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private WalletPresenter walletPresenter = new WalletPresenter(this);
    private TradingPresenter mPresenter = new TradingPresenter(this);
    private TradingAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_trading;
    }

    @Override
    public void initData() {
        ArrayList<TradingBean.DataBean.ListBean> data = new ArrayList<>();
        adapter = new TradingAdapter(mContext,R.layout.recycler_speed,data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void configView() {
        tvHead.setText("转换交易");
        mPresenter.attachView(this);
        walletPresenter.attachView(this);

        dialog.show();
        mPresenter.getExchangeDetail();
        walletPresenter.getUserWallet();
    }

    @OnClick({R.id.ivBack, R.id.rlSun, R.id.rlRegister})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlSun:
                startToActivity(SunActivity.class);
                break;
            case R.id.rlRegister:
                startToActivity(CurrentRegisterActivity.class);
                break;
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
    public int setType() {
        //类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
        return 2;
    }

    @Override
    public void getUserWalletSuccess(WalletBean walletBean) {
        Log.d(TAG, "getUserWalletSuccess: "+walletBean.toString());
        if (walletBean.getCode()==200){
            tv.setText(walletBean.getData().getName());
            tvNum.setText(walletBean.getData().getMoney());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (walletPresenter != null) {
            walletPresenter.detachView();
        }
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    @Override
    public void getExchangeDetailSuccess(TradingBean tradingBean) {
        Log.d(TAG, "getExchangeDetailSuccess: "+tradingBean.toString());
        if (tradingBean.getCode()==200){
            if (tradingBean.getData().getList().size()==0){
                ToastUtils.showLongToast("最近交易为空");
                return;
            }
            adapter.add(tradingBean.getData().getList());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public int setPage() {
        return 1;
    }

    @Override
    public int setPageSize() {
        return 10;
    }
}
