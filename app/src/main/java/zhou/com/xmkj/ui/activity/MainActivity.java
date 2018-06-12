package zhou.com.xmkj.ui.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.ui.fragment.DynamicFragment;
import zhou.com.xmkj.ui.fragment.IndexFragment;
import zhou.com.xmkj.ui.fragment.LifeFragment;
import zhou.com.xmkj.ui.fragment.MessageFragment;
import zhou.com.xmkj.ui.fragment.MyFragment;

public class MainActivity extends BaseActivity {

    private Fragment[] fragments;
    private int currentTabIndex = 0;
    @BindView(R.id.ivMessage) ImageView ivMessage;
    @BindView(R.id.tvMessage) TextView tvMessage;
    @BindView(R.id.ivLife) ImageView ivLife;
    @BindView(R.id.tvLife) TextView tvLife;
    @BindView(R.id.ivDynamic) ImageView ivDynamic;
    @BindView(R.id.tvDynamic) TextView tvDynamic;
    @BindView(R.id.ivMy) ImageView ivMy;
    @BindView(R.id.tvMy) TextView tvMy;
    @BindView(R.id.ivIndex) ImageView ivIndex;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        MessageFragment messageFragment = new MessageFragment();
        LifeFragment lifeFragment = new LifeFragment();
        IndexFragment indexFragment = new IndexFragment();
        DynamicFragment dynamicFragment = new DynamicFragment();
        MyFragment myFragment = new MyFragment();

        fragments = new Fragment[]{messageFragment, lifeFragment, indexFragment, dynamicFragment, myFragment};
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fragment_content, indexFragment).hide(indexFragment).add(R.id.fragment_content, messageFragment).hide(messageFragment)
                .add(R.id.fragment_content, lifeFragment).hide(lifeFragment)

                .add(R.id.fragment_content, dynamicFragment).hide(dynamicFragment)
                .show(indexFragment)
                .commit();
        setCheckImager(2);

    }

    /**
     * 显示Fragment对应的图标更换
     *
     * @param pos
     */
    private void setCheckImager(int pos) {
        switch (pos) {
            case 0:
                ivMessage.setImageResource(R.drawable.footer_2);
                tvMessage.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 1:
                ivLife.setImageResource(R.drawable.footer_4);
                tvLife.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 2:
                ivIndex.setImageResource(R.drawable.footer_6);
                break;
            case 3:
                ivDynamic.setImageResource(R.drawable.footer_8);
                tvDynamic.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 4:
                ivMy.setImageResource(R.drawable.footer_10);
                tvMy.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }

    @OnClick({R.id.rlMessage, R.id.rlLife, R.id.rlIndex, R.id.rlDynamic, R.id.rlMy})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlMessage:
                showTabFragment(0);
                break;
            case R.id.rlLife:
                showTabFragment(1);
                break;
            case R.id.rlIndex:
                showTabFragment(2);
                break;
            case R.id.rlDynamic:
                showTabFragment(3);
                break;
            case R.id.rlMy:
                showTabFragment(4);
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
        setUnCheckImager(currentTabIndex);
        if(!fragments[pos].isAdded()){
            trx.add(R.id.fragment_content,fragments[pos]);
        }
        setCheckImager(pos);
        trx.show(fragments[pos]);
        trx.commit();
        currentTabIndex = pos;
    }

    /**
     * 隐藏显示的图标
     *
     * @param pos
     */
    private void setUnCheckImager(int pos) {
        switch (pos){
            case 0:
                ivMessage.setImageResource(R.drawable.footer_1);
                tvMessage.setTextColor(getResources().getColor(R.color.common_divider_narrow));
                ivIndex.setImageResource(R.drawable.footer_5);
                break;
            case 1:
                ivLife.setImageResource(R.drawable.footer_3);
                tvLife.setTextColor(getResources().getColor(R.color.common_divider_narrow));
                ivIndex.setImageResource(R.drawable.footer_5);
                break;
            case 2:
                ivIndex.setImageResource(R.drawable.footer_5);
                break;
            case 3:
                ivDynamic.setImageResource(R.drawable.footer_7);
                tvDynamic.setTextColor(getResources().getColor(R.color.common_divider_narrow));
                ivIndex.setImageResource(R.drawable.footer_5);
                break;
            case 4:
                ivMy.setImageResource(R.drawable.footer_9);
                tvMy.setTextColor(getResources().getColor(R.color.common_divider_narrow));
                ivIndex.setImageResource(R.drawable.footer_5);
                break;
        }
    }
}
