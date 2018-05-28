package zhou.com.xmkj.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import zhou.com.xmkj.utils.LoadDialog;

/**
 * Created by zhou on 2018/5/25.
 */

public abstract class BaseFragment extends Fragment {
    public abstract int getLayout();
    public abstract void attachView();
    public abstract void initData();
    public abstract void configViews();
    protected LayoutInflater inflater;
    protected Context mContext;
    protected View parentView;
    protected FragmentActivity activity;
    private LoadDialog dialog;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        attachView();
        initData();
        configViews();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayout(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;
        return parentView;
    }

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    /**
     * 跳转便捷方法
     * @param clzz
     */
    public void startToActivity(Class<?> clzz){
        Intent intent = new Intent(mContext,clzz);
        startActivity(intent);
    }
}
