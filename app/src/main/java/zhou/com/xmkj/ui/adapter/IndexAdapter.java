package zhou.com.xmkj.ui.adapter;

import android.content.Context;

import java.util.List;

import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.bean.MyBaseBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class IndexAdapter extends BaseCommonAdapter<MyBaseBean> {

    public IndexAdapter(Context mContext, int mLayoutId, List<MyBaseBean> mDatas) {
        super(mContext, mLayoutId, mDatas);
    }

    @Override
    public void convert(ViewHolder holder, MyBaseBean myBaseBean, int position) {

    }
}
