package zhou.com.xmkj.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.bean.MyBaseBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.ui.activity.CodeActivity;
import zhou.com.xmkj.ui.activity.current.CurrentActivity;
import zhou.com.xmkj.ui.activity.MyMessageActivity;
import zhou.com.xmkj.ui.activity.setting.SettingActivity;
import zhou.com.xmkj.ui.activity.help.HelpActivity;
import zhou.com.xmkj.ui.activity.MyFansActivity;
import zhou.com.xmkj.ui.activity.RealNameAuthenticationActivity;
import zhou.com.xmkj.ui.activity.RegisterActivity;
import zhou.com.xmkj.ui.activity.UserInfoActivity;
import zhou.com.xmkj.ui.adapter.MyBaseAdapter;
import zhou.com.xmkj.ui.contract.UserInfoContract;
import zhou.com.xmkj.ui.presenter.UserInfoPresenter;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou
 * on 2018/5/28.
 * 我的
 */

public class MyFragment extends BaseFragment implements UserInfoContract.View{

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.ivBack) ImageView ivBack;
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.CircleImageView) CircleImageView circleImageView;
    @BindView(R.id.tvAccount) TextView tvAccount;
    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.ivRight) ImageView ivRight;

    public static String TAG = "MyFragment-我的";
    private UserInfoPresenter mPresenter = new UserInfoPresenter(this);
    private MyBaseAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void attachView() {
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initData() {
        List<MyBaseBean> data = new ArrayList<>();
        data.add(new MyBaseBean(MyMessageActivity.class,getString(R.string.my_news),R.drawable.icon_11));
        data.add(new MyBaseBean(RealNameAuthenticationActivity.class,getString(R.string.txt_real_name_authentication),R.drawable.icon_47));
        data.add(new MyBaseBean(RealNameAuthenticationActivity.class,"账户信息",R.drawable.icon_9));
        data.add(new MyBaseBean(CodeActivity.class,getString(R.string.txt_my_code),R.drawable.icon_10));
        data.add(new MyBaseBean(RegisterActivity.class,getString(R.string.txt_register),R.drawable.icon_9));
        data.add(new MyBaseBean(HelpActivity.class,getString(R.string.txt_help_center),R.drawable.icon_7));
        adapter = new MyBaseAdapter(mContext,R.layout.recycle_my,data);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void configViews() {
        ivBack.setVisibility(View.GONE);
        tvHead.setText(R.string.txt_my_fragment);
        ivRight.setImageResource(R.drawable.header_1);
        mPresenter.getUserInfo();
    }


    @Override
    public void getUserInfoSuccess(UserInfoBean userInfoBean) {
        Log.d(TAG, "getUserInfoSuccess: "+userInfoBean.toString());
        if (userInfoBean.getCode()==200){
            UserInfoBean.DataBean dataBean = userInfoBean.getData();
            Glide.with(this).load(dataBean.getAvatar()).into(circleImageView);
            tvAccount.setText(dataBean.getUsername());
            tvName.setText(dataBean.getNickname());
            App.getInstance().setUserInfoBean(userInfoBean);
        }

    }

    @Override
    public String setId() {
        return App.getInstance().getLoginBean().getData().getId()+"";
    }

    @Override
    public String setToken() {
        return App.getInstance().getLoginBean().getData().getToken();
    }

    @Override
    public void showError() {
        ToastUtils.showLongToast("系统出错");
    }

    @Override
    public void complete() {

    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @OnClick({R.id.rlMyNews,R.id.rlMessage,R.id.rlLife,R.id.rlDynamic,R.id.rlMy,R.id.ivRight})
    void onClick(View view){
        switch (view.getId()){
            case R.id.rlMyNews://我的头像处-个人信息
                startToActivity(UserInfoActivity.class);
                break;
            case R.id.rlMessage://我的粉丝
                startToActivity(MyFansActivity.class);
                break;
            case R.id.rlLife://流通交易
                startToActivity(CurrentActivity.class);
                break;
            case R.id.rlDynamic://VRCH结算
                break;
            case R.id.rlMy://会员充值
                break;
            case R.id.ivRight:
                startToActivity(SettingActivity.class);
                break;
        }
    }
}
