package zhou.com.xmkj.ui.adapter;

import android.content.Context;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.AddressBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class AddressAdapter extends BaseCommonAdapter<AddressBean.DataBean.ListBean> {

    public AddressAdapter(Context mContext, int mLayoutId, List<AddressBean.DataBean.ListBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, AddressBean.DataBean.ListBean dataBean, int position) {
        holder.setText(R.id.tvName,dataBean.getUsername());
        holder.setText(R.id.tvPhone,dataBean.getMobile());
        holder.setText(R.id.tvMsg,dataBean.getAddress());
    }
}
