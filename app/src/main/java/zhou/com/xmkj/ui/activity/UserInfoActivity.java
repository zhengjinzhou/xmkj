package zhou.com.xmkj.ui.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.MyBaseBean;

/**
 * Created by zhou on 2018/5/28.
 * 个人信息
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.tvNickname) TextView tvNickname;
    @BindView(R.id.CircleImageView) CircleImageView circleImageView;
    @BindView(R.id.tvAccount) TextView tvAccount;
    @BindView(R.id.tvGender) TextView tvGender;

    @Override
    public int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initData() {
        List<MyBaseBean> data = new ArrayList<>();
        data.add(new MyBaseBean(AccountMessageActivity.class,"账户信息",0));
        data.add(new MyBaseBean(GoodsActivity.class,"收货地址",0));
        data.add(new MyBaseBean(LabelActivity.class,"个性标签",0));

        BaseCommonAdapter adapter = new BaseCommonAdapter<MyBaseBean>(this, R.layout.recycle_my, data) {
            @Override
            public void convert(ViewHolder holder, final MyBaseBean baseBean, int position) {
                holder.setText(R.id.tv_name,baseBean.getName());

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
        tvHead.setText(R.string.my_userinfo);
        Glide.with(this).load(App.getInstance().getUserInfoBean().getData().getAvatar()).into(circleImageView);
        tvNickname.setText(App.getInstance().getUserInfoBean().getData().getNickname());
        tvAccount.setText(App.getInstance().getUserInfoBean().getData().getUsername());
        tvGender.setText(App.getInstance().getUserInfoBean().getData().getGender());
    }

    @OnClick({R.id.ivBack,R.id.rlMyIcon})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlMyIcon:

                break;
        }
    }
}
