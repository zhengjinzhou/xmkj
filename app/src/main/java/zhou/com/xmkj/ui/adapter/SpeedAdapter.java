package zhou.com.xmkj.ui.adapter;

import android.content.Context;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.RewardDetailBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class SpeedAdapter extends BaseCommonAdapter<RewardDetailBean.DataBean.ListBean> {

    public SpeedAdapter(Context mContext, int mLayoutId, List<RewardDetailBean.DataBean.ListBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, RewardDetailBean.DataBean.ListBean listBean, int position) {
        holder.setText(R.id.tvType,listBean.getRewardtype());
        holder.setText(R.id.tvMoney,"+"+listBean.getMoney());
        holder.setText(R.id.tvNote,listBean.getNote());
        holder.setText(R.id.tvTime,listBean.getCreatetime());
    }
}
