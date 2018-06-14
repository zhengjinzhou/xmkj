package zhou.com.xmkj.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;

/**
 * 我的二维码
 */
public class CodeActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.ivCode) ImageView ivCode;
    @BindView(R.id.ivAvater) ImageView ivAvater;

    @Override
    public int getLayout() {
        return R.layout.activity_code;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.txt_my_code);
        String avatar = App.getInstance().getLoginBean().getData().getAvatar();

        Glide.with(this).load(avatar).into(ivAvater);

        Bitmap mBitmap = CodeUtils.createImage(avatar, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        ivCode.setImageBitmap(mBitmap);
    }

    @OnClick({R.id.ivBack})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
