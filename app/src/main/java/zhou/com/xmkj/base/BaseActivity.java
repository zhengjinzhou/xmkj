package zhou.com.xmkj.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import butterknife.ButterKnife;
import zhou.com.xmkj.utils.LoadDialog;

/**
 * Created by zhou on 2018/5/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayout();//layout
    public abstract void initData();//加载数据方法
    public abstract void configView();//初始化控件
    public Context mContext;
    protected LoadDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        ButterKnife.bind(this);
        dialog = new LoadDialog(this,false,"正在加载...");
        initData();
        configView();
        getstureDe();
    }

    /**
     * 顶部颜色透明对应
     */
    private void initTop() {
        //Android5.0以上状态栏颜色修改
        if(Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 手势控制
     * 用于左右滑动
     */
    private void getstureDe() {

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
