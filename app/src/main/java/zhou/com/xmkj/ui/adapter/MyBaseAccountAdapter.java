package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.MyBaseAccountBean;
import zhou.com.xmkj.bean.MyBaseMessageBean;

/**
 * Created by zhou
 * on 2018/6/1.
 */

public class MyBaseAccountAdapter extends BaseCommonAdapter<MyBaseAccountBean> {


    public MyBaseAccountAdapter(Context mContext, int mLayoutId, List<MyBaseAccountBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, MyBaseAccountBean myBaseMessageBean, int position) {
        holder.setOnClickListener(R.id.layout, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.getView(R.id.iv).setVisibility(View.GONE);
        holder.setText(R.id.tv_name,myBaseMessageBean.getName());
        holder.setText(R.id.tvContent,myBaseMessageBean.getContent());
        ImageView iv_icon = holder.getView(R.id.iv_icon);
        Glide.with(mContext).load(myBaseMessageBean.getIcon()).into(iv_icon);
    }
}
