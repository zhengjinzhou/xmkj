package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.common.OnRvItemClickListener;
import zhou.com.xmkj.ui.activity.AddressActivity;
import zhou.com.xmkj.ui.contract.DelAddressContract;
import zhou.com.xmkj.ui.presenter.AddressPresenter;
import zhou.com.xmkj.ui.presenter.DelAddressPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class AddressAdapter extends BaseCommonAdapter<AddressBean.DataBean.ListBean>{

    private OnRvItemClickListener listener;

    public AddressAdapter(Context mContext, int mLayoutId, List<AddressBean.DataBean.ListBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(final ViewHolder holder, final AddressBean.DataBean.ListBean dataBean, final int position) {
        holder.setText(R.id.tvName,dataBean.getUsername());
        holder.setText(R.id.tvPhone,dataBean.getMobile());
        holder.setText(R.id.tvMsg,dataBean.getAddress());
        holder.setOnClickListener(R.id.tvWrite, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLongToast("待续");
            }
        });

        holder.setOnClickListener(R.id.tvDelete, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d("-", "onClick: "+dataBean.toString());
                listener.onItemClick(holder.getItemView(),position,dataBean);
            }
        });
    }

    public void setOnItemClickListener(OnRvItemClickListener listener){
        this.listener = listener;
    }
}
