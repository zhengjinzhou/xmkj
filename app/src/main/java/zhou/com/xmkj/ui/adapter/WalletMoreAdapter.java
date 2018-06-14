package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.WalletMoreBean;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class WalletMoreAdapter extends BaseCommonAdapter<WalletMoreBean.DataBean.ListBean> {

    public WalletMoreAdapter(Context mContext, int mLayoutId, List<WalletMoreBean.DataBean.ListBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, WalletMoreBean.DataBean.ListBean listBean, int position) {
        if (listBean.getType() == 1) {
            holder.setText(R.id.tvMoney, "+" + listBean.getMoney());
        } else {
            holder.setText(R.id.tvMoney, "-" + listBean.getMoney());
            TextView tvMoney = holder.getView(R.id.tvMoney);
            tvMoney.setTextColor(Color.parseColor("#28fb29"));
        }
        holder.setText(R.id.tvType, listBean.getFrom_type());
        holder.setText(R.id.tvNote, listBean.getNote());
        holder.setText(R.id.tvTime, listBean.getCreatetime());
    }
}
