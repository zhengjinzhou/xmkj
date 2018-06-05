package zhou.com.xmkj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.base.Constant;
import zhou.com.xmkj.bean.LoginBean;

/**
 * 粉丝接入图-h5界面
 */
public class FansPointActivity extends BaseActivity {

    @BindView(R.id.webView) WebView webView;
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvRight) TextView tvRight;
    private String url;

    @Override
    public int getLayout() {
        return R.layout.activity_fans_point;
    }

    @Override
    public void initData() {
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
        url = Constant.BASE_URL + "fans/getFansNet?id=" + data.getId() + "&token=" + data.getToken();
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
        tvHead.setText(getString(R.string.fans_point));
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(R.string.txt_refresh);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }

    @OnClick(R.id.ivBack)
    void onClick() {
        finish();
    }

    @OnClick(R.id.ivRight)
    void onRefreshClick() {
        webView.loadUrl(url);
    }
}
