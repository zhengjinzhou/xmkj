package zhou.com.xmkj.ui.adapter;

import android.content.Context;

import java.util.List;

import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.FansListBean;

/**
 * Created by zhou on 2018/5/31.
 */

public class FansAdapter extends BaseCommonAdapter<FansListBean.DataBean> {

    public FansAdapter(Context mContext, int mLayoutId, List<FansListBean.DataBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, FansListBean.DataBean bean, int position) {

    }
}
