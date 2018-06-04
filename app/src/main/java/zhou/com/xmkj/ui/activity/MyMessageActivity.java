package zhou.com.xmkj.ui.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.MyBaseMessageBean;
import zhou.com.xmkj.bean.UserInfoBean;
import zhou.com.xmkj.bean.MyBaseAccountBean;
import zhou.com.xmkj.ui.adapter.MyBaseAccountAdapter;
import zhou.com.xmkj.ui.adapter.MyBaseMessageAdapter;
import zhou.com.xmkj.ui.contract.UserInfoContract;
import zhou.com.xmkj.ui.presenter.UserInfoPresenter;

public class MyMessageActivity extends BaseActivity implements UserInfoContract.View{

    private static final String TAG = "MyMessageActivity-我的信息";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.reMessage) RecyclerView reMessage;
    @BindView(R.id.reAccount) RecyclerView reAccount;
    private UserInfoPresenter mPresenter = new UserInfoPresenter(this);
    private MyBaseMessageAdapter adapterMessage;
    private MyBaseAccountAdapter adapterAccount;
    private List<MyBaseMessageBean> dataMessage;
    private List<MyBaseAccountBean> dataAccount;

    @Override
    public int getLayout() {
        return R.layout.activity_my_message;
    }

    @Override
    public void initData() {
        dataMessage = new ArrayList<>();
        dataAccount = new ArrayList<>();

        adapterMessage = new MyBaseMessageAdapter(this,R.layout.recycle_my, dataMessage);
        adapterAccount = new MyBaseAccountAdapter(this,R.layout.recycle_my, dataAccount);

        reMessage.setLayoutManager(new LinearLayoutManager(this));
        reMessage.setAdapter(adapterMessage);

        reAccount.setLayoutManager(new LinearLayoutManager(this));
        reAccount.setAdapter(adapterAccount);
    }

    @Override
    public void configView() {
        tvHead.setText(R.string.my_message);
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSuccess(UserInfoBean userInfoBean) {
        Log.d(TAG, "getUserInfoSuccess: "+userInfoBean.toString());
        if (userInfoBean.getCode()==200){
            UserInfoBean.DataBean userInfoBeanData = userInfoBean.getData();

            dataMessage.add(new MyBaseMessageBean(R.drawable.icon_11,"个人信息",userInfoBeanData.getUsername()));
            dataMessage.add(new MyBaseMessageBean(R.drawable.icon_11,"姓名",userInfoBeanData.getNickname()));
            dataMessage.add(new MyBaseMessageBean(R.drawable.icon_11,"手机",userInfoBeanData.getMobile()));
            dataMessage.add(new MyBaseMessageBean(R.drawable.icon_11,"推荐人",userInfoBeanData.getRname()));
            dataMessage.add(new MyBaseMessageBean(R.drawable.icon_11,"接点人",userInfoBeanData.getPname()));

            for (int i=0;i< userInfoBeanData.getWallet().size();i++){
                dataAccount.add(new MyBaseAccountBean( userInfoBeanData.getWallet().get(i).getIcon(), userInfoBeanData.getWallet().get(i).getName(), userInfoBeanData.getWallet().get(i).getMoney()));
            }

            adapterMessage.addDatas(dataMessage);
            adapterAccount.addDatas(dataAccount);

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
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @OnClick({R.id.ivBack}) void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null)
            mPresenter.detachView();
        super.onDestroy();
    }
}
