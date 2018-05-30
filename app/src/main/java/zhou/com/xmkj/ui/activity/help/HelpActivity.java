package zhou.com.xmkj.ui.activity.help;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.MyBaseBean;
import zhou.com.xmkj.ui.activity.CodeActivity;
import zhou.com.xmkj.ui.activity.MyNewsActivity;
import zhou.com.xmkj.ui.activity.RealNameAuthenticationActivity;

/**
 * 帮助中心
 */
public class HelpActivity extends BaseActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.tvHead) TextView tvHead;


    @Override
    public int getLayout() {
        return R.layout.activity_help;
    }

    @Override
    public void initData() {
        List<MyBaseBean> data = new ArrayList<>();
        data.add(new MyBaseBean(HelpDocActivity.class,getString(R.string.help_doc),R.drawable.icon_32));
        data.add(new MyBaseBean(WorkOrderActivity.class,getString(R.string.work_order),R.drawable.icon_33));
        data.add(new MyBaseBean(OnlineServiceActivity.class,getString(R.string.online_service),R.drawable.icon_34));

        BaseCommonAdapter adapter = new BaseCommonAdapter<MyBaseBean>(this, R.layout.recycle_my, data) {
            @Override
            public void convert(ViewHolder holder, final MyBaseBean baseBean, int position) {
                holder.setText(R.id.tv_name,baseBean.getName());
                holder.setImageResource(R.id.iv_icon,baseBean.getIcon());
                holder.setOnClickListener(R.id.layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startToActivity(baseBean.getaClass());
                    }
                });
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.help_center);
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
