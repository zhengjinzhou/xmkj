package zhou.com.xmkj.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.base.Constant;
import zhou.com.xmkj.ui.fragment.fans.FansCommunityFragment;
import zhou.com.xmkj.ui.fragment.fans.FansShareFragment;
import zhou.com.xmkj.ui.fragment.fans.FansSharedFragment;
import zhou.com.xmkj.ui.fragment.fans.FansSumFragment;

/**
 * 粉丝-总粉丝-分享粉丝-共享粉丝-社群粉丝
 */
public class FansActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvSumFans) TextView tvSumFans;
    @BindView(R.id.tvShardFans) TextView tvShardFans;
    @BindView(R.id.tvGongXiang) TextView tvGongXiang;
    @BindView(R.id.tvCommunity) TextView tvCommunity;
    private Fragment[] fragments;
    private int currentTabIndex = 0;


    public static Intent newIntent(Context context, String head, int pos) {
        Intent intent = new Intent(context, FansActivity.class);
        intent.putExtra("HEAD",head);
        intent.putExtra("POS",pos);
        return intent;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_fans;
    }

    @Override
    public void initData() {
        FansSumFragment sumFragment = new FansSumFragment();
        FansShareFragment fansShareFragment = new FansShareFragment();
        FansSharedFragment fansSharedFragment = new FansSharedFragment();
        FansCommunityFragment fansCommunityFragment = new FansCommunityFragment();
        fragments = new Fragment[]{sumFragment, fansShareFragment, fansSharedFragment, fansSharedFragment, fansCommunityFragment};
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, sumFragment).hide(sumFragment)
                .add(R.id.fragment_content, fansShareFragment).hide(fansShareFragment)
                .add(R.id.fragment_content, fansSharedFragment).hide(fansSharedFragment)
                .add(R.id.fragment_content, fansCommunityFragment).hide(fansCommunityFragment)
                .show(sumFragment)
                .commit();
        //setCheckColor(0);
    }

    /**
     * 显示Fragment对应的背景色与字体色
     *
     * @param pos
     */
    private void setCheckColor(int pos) {
        switch (pos) {
            case 0:
                tvSumFans.setBackground(getDrawable(R.drawable.bg_fans_left));
                tvSumFans.setTextColor(getResources().getColor(R.color.white));
                break;
            case 1:
                tvShardFans.setBackgroundResource(R.color.colorPrimary);
                tvShardFans.setTextColor(getResources().getColor(R.color.white));
                break;
            case 2:
                tvGongXiang.setBackgroundResource(R.color.colorPrimary);
                tvGongXiang.setTextColor(getResources().getColor(R.color.white));
                break;
            case 3:
                tvCommunity.setBackground(getDrawable(R.drawable.bg_fans_right));
                tvCommunity.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }

    /**
     * 根据点击进入的不同
     * 头部信息显示不同的
     * 文字以及背景颜色
     */
    @Override
    public void configView() {
        tvHead.setText(getIntent().getStringExtra("HEAD"));
        setCheckColor(getIntent().getIntExtra("POS",0));
    }

    @OnClick({R.id.ivBack, R.id.tvSumFans, R.id.tvShardFans, R.id.tvGongXiang, R.id.tvCommunity})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.tvSumFans:
                tvHead.setText(R.string.fans_sum);
                showTabFragment(0);
                break;
            case R.id.tvShardFans:
                tvHead.setText(R.string.fans_share);
                showTabFragment(1);
                break;
            case R.id.tvGongXiang:
                tvHead.setText(R.string.fans_shared);
                showTabFragment(2);
                break;
            case R.id.tvCommunity:
                tvHead.setText(R.string.fans_Community);
                showTabFragment(3);
                break;
        }
    }
    /**
     * 选择显示的Fragment
     * @param pos
     */
    private void showTabFragment(int pos){
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        setUnCheckColor(currentTabIndex);
        if(!fragments[pos].isAdded()){
            trx.add(R.id.fragment_content,fragments[pos]);
        }
        setCheckColor(pos);
        trx.show(fragments[pos]);
        trx.commit();
        currentTabIndex = pos;
    }

    /**
     * 隐藏显示的图标
     *
     * @param pos
     */
    private void setUnCheckColor(int pos) {
        switch (pos){
            case 0:
                tvSumFans.setBackgroundResource(R.color.touming);
                tvSumFans.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 1:
                tvShardFans.setBackgroundResource(R.color.touming);
                tvShardFans.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 2:
                tvGongXiang.setBackgroundResource(R.color.touming);
                tvGongXiang.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 3:
                tvCommunity.setBackgroundResource(R.color.touming);
                tvCommunity.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }

}
