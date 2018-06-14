package zhou.com.xmkj.ui.activity.current;

import android.content.Context;
import android.content.Intent;
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
import zhou.com.xmkj.bean.WalletMoreBean;
import zhou.com.xmkj.ui.activity.setting.SetZhiActivity;
import zhou.com.xmkj.ui.adapter.WalletMoreAdapter;
import zhou.com.xmkj.ui.contract.WalletMoreContract;
import zhou.com.xmkj.ui.presenter.WalletMorePresenter;
import zhou.com.xmkj.utils.ToastUtils;

public class Vrch_SunActivity extends BaseActivity implements WalletMoreContract.View{

    private static final String TAG = "Vrch_SunActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private WalletMorePresenter mPresenter = new WalletMorePresenter(this);
    private WalletMoreAdapter adapter;

    public static Intent newIntent(Context context, String name, int type) {
        Intent intent = new Intent(context, Vrch_SunActivity.class);
        intent.putExtra("TYPE", type);
        intent.putExtra("NAME", name);
        return intent;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_vrch__sun;
    }

    @Override
    public void initData() {
        ArrayList<WalletMoreBean.DataBean.ListBean> listBeans = new ArrayList<>();
        adapter = new WalletMoreAdapter(this,R.layout.recycler_speed,listBeans);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void configView() {
        tvHead.setText(getIntent().getStringExtra("NAME"));
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getWalletMoreDetail();

    }

    @OnClick({R.id.ivBack})
    void onClick(View view) {
        switch (view.getId()) {
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
        return 10;
    }

    @Override
    public int setType() {
        Log.d(TAG, "setType: "+getIntent().getIntExtra("TYPE", 0));
        return getIntent().getIntExtra("TYPE", 0);
    }

    @Override
    public void getWalletMoreSuccess(WalletMoreBean moreBean) {
        Log.d(TAG, "getWalletDetailSuccess: "+moreBean.toString());
        if (moreBean.getCode()==200){
            List<WalletMoreBean.DataBean.ListBean> list = moreBean.getData().getList();
            if (list.size()==0){
                ToastUtils.showLongToast("数据为空");
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
}