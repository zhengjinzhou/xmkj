package zhou.com.xmkj.ui.activity;
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
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.common.OnRvItemClickListener;
import zhou.com.xmkj.ui.adapter.AddressAdapter;
import zhou.com.xmkj.ui.contract.AddressContract;
import zhou.com.xmkj.ui.presenter.AddressPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 收货地址
 *
 */
public class AddressActivity extends BaseActivity implements AddressContract.View,OnRvItemClickListener<AddressBean.DataBean.ListBean> {

    private static final String TAG = "AddressActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    private AddressPresenter mPresenter = new AddressPresenter(this);
    private AddressAdapter adapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.activity_address;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {

        tvHead.setText("收货地址");

        ArrayList<AddressBean.DataBean.ListBean> dataBeans = new ArrayList<>();
        adapter = new AddressAdapter(this,R.layout.recycler_address,dataBeans);
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getAddressList();
    }

    @Override
    public void getAddressListSuccess(AddressBean addressBean) {
        Log.d(TAG, "getAddressListSuccess: "+addressBean.toString());
        if (addressBean.getCode()==200){
            List<AddressBean.DataBean.ListBean> list = addressBean.getData().getList();
            if (list.size()==0){
                ToastUtils.showLongToast("收货地址为空");
            }
            adapter.clear();
            adapter.add(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void delUserAddressSuccess(BaseBean baseBean) {
        Log.d(TAG, "delUserAddressSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
        if (baseBean.getCode()==200){
            mPresenter.getAddressList();
        }
    }

    @OnClick({R.id.ivBack,R.id.btAdd}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.btAdd:
                startToActivity(AddAddressActivity.class);
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


    @Override
    public void onItemClick(View view, int position, AddressBean.DataBean.ListBean data) {
        dialog.show();
        mPresenter.delUserAddress(data.getId());
    }
}
