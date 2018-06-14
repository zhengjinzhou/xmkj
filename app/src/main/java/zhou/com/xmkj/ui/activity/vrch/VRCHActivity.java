package zhou.com.xmkj.ui.activity.vrch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.base.Constant;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.VrchInfoBean;
import zhou.com.xmkj.ui.contract.VRCHContract;
import zhou.com.xmkj.ui.presenter.VRCHPresenter;

public class VRCHActivity extends BaseActivity implements VRCHContract.View {

    private static final String TAG = "VRCHActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvKtval) TextView tvKtval;
    @BindView(R.id.tvVrchval) TextView tvVrchval;
    @BindView(R.id.tvPrice) TextView tvPrice;
    @BindView(R.id.webView) WebView webView;
    @BindView(R.id.ivRight) ImageView ivRight;
    private VRCHPresenter mPresenter = new VRCHPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_vrch;
    }

    @Override
    public void initData() {
        int id = App.getInstance().getLoginBean().getData().getId();
        String token = App.getInstance().getLoginBean().getData().getToken();
        String url = Constant.BASE_URL + "outtrade/infohtml?" + "id=" + id + "&token=" + token;
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置 缓存模式
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        webView.getSettings().setDomStorageEnabled(true);

        LoginBean.DataBean data = App.getInstance().getLoginBean().getData();
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void configView() {
        tvHead.setText("VRCH交易");
        ivRight.setImageResource(R.drawable.header_1);
        mPresenter.attachView(this);
        dialog.show();
        mPresenter.getVrchInfo();
    }

    @OnClick({R.id.ivBack, R.id.rlOut, R.id.rlIn,R.id.ivRight})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivRight:
                startToActivity(KeyActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlOut:
                startToActivity(VrchOutActivity.class);//转出
                break;
            case R.id.rlIn:
                startToActivity(VrchInActivity.class);//转入
                break;
        }
    }

    @Override
    public void getVrchInfoSuccess(VrchInfoBean vrchInfoBean) {
        Log.d(TAG, "getVrchInfoSuccess: " + vrchInfoBean.toString());
        if (vrchInfoBean.getCode() == 200) {
            tvKtval.setText(vrchInfoBean.getData().getKtval());
            tvVrchval.setText(vrchInfoBean.getData().getVrchval());
            tvPrice.setText(vrchInfoBean.getData().getPrice());
        }
    }

    @Override
    public void showError() {
        dialog.dismiss();
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
