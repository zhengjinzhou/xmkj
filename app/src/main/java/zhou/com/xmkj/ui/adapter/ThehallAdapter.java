package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.ShareSalesBean;
import zhou.com.xmkj.bean.TradingBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class ThehallAdapter  extends BaseCommonAdapter<ShareSalesBean.DataBean.ListBean>{

    public ThehallAdapter(Context mContext, int mLayoutId, List<ShareSalesBean.DataBean.ListBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, ShareSalesBean.DataBean.ListBean listBean, int position) {
        holder.setText(R.id.tvName,listBean.getUsername());
        holder.setText(R.id.tvContent,listBean.getNum());
        holder.setText(R.id.tvTime,listBean.getCreatetime());
        CircleImageView img = holder.getView(R.id.circle);
        Glide.with(mContext).load(listBean.getAvatar()).into(img);
    }
}
