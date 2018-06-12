package zhou.com.xmkj.ui.activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.ui.adapter.AddressAdapter;
import zhou.com.xmkj.ui.contract.AddressContract;
import zhou.com.xmkj.ui.presenter.AddressPresenter;

/**
 * 收货地址
 *
 */
public class AddressActivity extends BaseActivity implements AddressContract.View{

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

        ArrayList<AddressBean.DataBean.ListBean> dataBeans = new ArrayList<>();
        adapter = new AddressAdapter(this,R.layout.recycler_address,dataBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getAddressList();
    }

    @Override
    public void getAddressListSuccess(AddressBean addressBean) {
        Log.d(TAG, "getAddressListSuccess: "+addressBean.toString());
        if (addressBean.getCode()==200){
            List<AddressBean.DataBean.ListBean> list = addressBean.getData().getList();

            adapter.add(list);
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
