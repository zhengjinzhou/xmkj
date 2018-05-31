package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.MyFansBean;
import zhou.com.xmkj.ui.contract.MyFansContract;
import zhou.com.xmkj.ui.presenter.MyFansPresenter;

public class MyFansActivity extends BaseActivity implements MyFansContract.View{

    private static final String TAG = "MyFansActivity-我的粉丝首页";
    @BindView(R.id.tvSumFans) TextView tvSumFans;
    @BindView(R.id.tvShardFans) TextView tvShardFans;
    @BindView(R.id.tvGongXiang) TextView tvGongXiang;
    @BindView(R.id.tvCommunity) TextView tvCommunity;
    @BindView(R.id.tvHead) TextView tvHead;
    private MyFansPresenter mPresenter = new MyFansPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_my_fans;
    }

    @Override
    public void initData() {
        mPresenter.getIndexFans();
    }

    @Override
    public void configView() {
        tvHead.setText(getString(R.string.txt_myfans));
        dialog.show();
        mPresenter.attachView(this);
    }

    @OnClick({R.id.rlFansPoint,R.id.rlSumFans,R.id.rlShardFans,R.id.rlGongXiang,R.id.rlCommunityFans,R.id.ivBack})
    void onClick(View view){
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlFansPoint://粉丝接入点图
                startToActivity(FansPointActivity.class);
                break;
            case R.id.rlSumFans://总粉丝
                startActivity(FansActivity.newIntent(this,getResources().getString(R.string.fans_sum),0));
                break;
            case R.id.rlShardFans://分享粉丝
                startActivity(FansActivity.newIntent(this,getResources().getString(R.string.fans_share),1));
                break;
            case R.id.rlGongXiang://共享粉丝
                startActivity(FansActivity.newIntent(this,getResources().getString(R.string.fans_shared),2));
                break;
            case R.id.rlCommunityFans://社群粉丝
                startActivity(FansActivity.newIntent(this,getResources().getString(R.string.fans_Community),3));
                break;
        }
    }

    @Override
    public void getIndexFansSuccess(MyFansBean myFansBean) {
        Log.d(TAG, "getIndexFansSuccess: "+myFansBean.toString());
        if (myFansBean.getCode()==200){
            MyFansBean.DataBean data = myFansBean.getData();
            tvSumFans.setText(data.getAllFans()+"人");
            tvShardFans.setText(data.getOneFans()+"人");
            tvGongXiang.setText(data.getTwoFans()+"人");
            tvCommunity.setText(data.getThreeFans()+"人");
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

    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
