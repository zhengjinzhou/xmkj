package zhou.com.xmkj.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.util.List;

import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.MyBaseBean;

/**
 * Created by zhou
 * on 2018/6/1.
 * MyFragment的adapter
 * MyMessageActivity的adapter
 */

public class MyBaseAdapter extends BaseCommonAdapter<MyBaseBean> {

    public MyBaseAdapter(Context mContext, int mLayoutId, List<MyBaseBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, final MyBaseBean myBaseBean, int position) {
        holder.setText(R.id.tv_name,myBaseBean.getName());
        holder.setImageResource(R.id.iv_icon,myBaseBean.getIcon());
        holder.setOnClickListener(R.id.layout, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext,myBaseBean.getaClass()));
            }
        });
    }
}
