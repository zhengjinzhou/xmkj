package zhou.com.xmkj.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.BaseFragment;
import zhou.com.xmkj.bean.IndexBean;
import zhou.com.xmkj.bean.MyBaseBean;
import zhou.com.xmkj.ui.activity.vrch.VRCHActivity;
import zhou.com.xmkj.ui.activity.index.VRFilmActivity;
import zhou.com.xmkj.ui.activity.index.VRFootActivity;
import zhou.com.xmkj.ui.activity.index.VRHomeActivity;
import zhou.com.xmkj.ui.activity.index.VRMarketActivity;
import zhou.com.xmkj.ui.activity.index.VRMoreActivity;
import zhou.com.xmkj.ui.activity.index.VRShoppingActivity;
import zhou.com.xmkj.ui.activity.index.VRTravelActivity;
import zhou.com.xmkj.ui.adapter.MyBaseAdapter;
import zhou.com.xmkj.ui.contract.IndexContract;
import zhou.com.xmkj.ui.presenter.IndexPresenter;
import zhou.com.xmkj.view.GlideImageLoader;

/**
 * Created by zhou on 2018/5/28.
 * 主页
 */

public class IndexFragment extends BaseFragment implements IndexContract.View{

    private static String TAG = "IndexFragment-主页";
    @BindView(R.id.banner) Banner banner;
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.ivBack) ImageView ivBack;
    @BindView(R.id.ivBanner) ImageView ivBanner;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private MyBaseAdapter adapter;
    private IndexPresenter mPresenter = new IndexPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    public void attachView() {
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initData() {
        //资源文件
        ArrayList<String> images = new ArrayList<>();
        images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2784432848,511077205&fm=27&gp=0.jpg");
        images.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=431792944,1008990118&fm=200&gp=0.jpg");
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        List<MyBaseBean> data = new ArrayList<>();
        data.add(new MyBaseBean(VRCHActivity.class,"VR车房",R.drawable.index_8));
        data.add(new MyBaseBean(VRMarketActivity.class,"VR市场",R.drawable.index_7));
        data.add(new MyBaseBean(VRShoppingActivity.class,"VR商场",R.drawable.index_6));
        data.add(new MyBaseBean(VRHomeActivity.class,"VR家园",R.drawable.index_5));
        data.add(new MyBaseBean(VRFilmActivity.class,"VR影院",R.drawable.index_4));
        data.add(new MyBaseBean(VRTravelActivity.class,"VR旅游",R.drawable.index_3));
        data.add(new MyBaseBean(VRFootActivity.class,"VR美食",R.drawable.index_2));
        data.add(new MyBaseBean(VRMoreActivity.class,"更多",R.drawable.index_1));
        adapter = new MyBaseAdapter(mContext,R.layout.recycler_index,data);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,4));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void configViews() {
        mPresenter.getIndex();
        tvHead.setText(R.string.app_name);
        ivBack.setVisibility(View.GONE);

    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void getIndexSuccess(IndexBean indexBean) {
        Log.d(TAG, "getIndexSuccess: "+indexBean.toString());

    }

    @Override
    public void showError() {
    }

    @Override
    public void complete() {
    }
}
