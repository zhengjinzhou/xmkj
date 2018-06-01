package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.MyBaseMessageBean;

/**
 * Created by zhou
 * on 2018/6/1.
 */

public class MyBaseMessageAdapter extends BaseCommonAdapter<MyBaseMessageBean> {

    public MyBaseMessageAdapter(Context mContext, int mLayoutId, List<MyBaseMessageBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, MyBaseMessageBean myBaseMessageBean, int position) {
        holder.getView(R.id.iv).setVisibility(View.GONE);
        holder.setImageResource(R.id.iv_icon,myBaseMessageBean.getIcon());
        holder.setText(R.id.tv_name,myBaseMessageBean.getName());
        holder.setText(R.id.tvContent,myBaseMessageBean.getContent());
    }
}
