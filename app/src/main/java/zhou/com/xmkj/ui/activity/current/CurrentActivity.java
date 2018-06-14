package zhou.com.xmkj.ui.activity.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.FansListBean;
import zhou.com.xmkj.bean.IntradeBean;
import zhou.com.xmkj.ui.activity.SpeedActivity;
import zhou.com.xmkj.ui.contract.CurrentContract;
import zhou.com.xmkj.ui.presenter.CurrentPresneter;
import zhou.com.xmkj.utils.ToastUtils;

public class CurrentActivity extends BaseActivity implements CurrentContract.View {

    private static final String TAG = "CurrentActivity-流通交易";
    private CurrentPresneter mPresenter = new CurrentPresneter(this);
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvMoney) TextView tvMoney;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private BaseCommonAdapter<IntradeBean.DataBean.WalletBean> mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_current;
    }

    @Override
    public void initData() {
        List<IntradeBean.DataBean.WalletBean> dataBeans = new ArrayList<>();
        mAdapter = new BaseCommonAdapter<IntradeBean.DataBean.WalletBean>(mContext, R.layout.recycler_intrade, dataBeans) {
            @Override
            public void convert(ViewHolder holder, final IntradeBean.DataBean.WalletBean dataBean, int position) {
                holder.setText(R.id.tvName,dataBean.getName());
                holder.setText(R.id.tvNum,dataBean.getMoney());
                holder.setOnClickListener(R.id.rlHead, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(Vrch_SunActivity.newIntent(CurrentActivity.this,dataBean.getName(),dataBean.getType()));
                    }
                });
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void configView() {
        tvHead.setText(R.string.current);
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getIntrade();
    }

    @Override
    public void getIntradeSuccess(IntradeBean intradeBean) {
        if (intradeBean.getCode()==200){
            Log.d(TAG, "getIntradeSuccess: " + intradeBean.toString());
            tvMoney.setText("￥"+intradeBean.getData().getDtmoney());
            List<IntradeBean.DataBean.WalletBean> data = intradeBean.getData().getWallet();
            Log.d(TAG, "getIntradeSuccess: " + data.toString());

            mAdapter.add(data);
            mAdapter.notifyDataSetChanged();
        }
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
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @OnClick({R.id.ivBack,R.id.rlMoney,R.id.rlDynamic,R.id.rlMy,R.id.rlMessage,R.id.rlLife}) void onClick(View view){
        switch (view.getId()){
            case R.id.rlMessage://流通转账
                startToActivity(TransferActivity.class);
                break;
            case R.id.rlLife://流通投资
                startToActivity(InvestmentActivity.class);
                break;
            case R.id.rlDynamic://转换交易
                startToActivity(TradingActivity.class);
                break;
            case R.id.rlMy://交易大厅
                startToActivity(ThehallActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlMoney:
                startToActivity(SpeedActivity.class);
                break;
        }
    }
}
