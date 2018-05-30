package zhou.com.xmkj.ui.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.adapter.base.BaseCommonAdapter;
import zhou.com.xmkj.adapter.base.ViewHolder;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.MyBaseBean;

/**
 * Created by zhou on 2018/5/28.
 * 个人信息
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvNickname) TextView tvNickname;
    @BindView(R.id.CircleImageView) CircleImageView circleImageView;
    @BindView(R.id.tvAccount) TextView tvAccount;
    @BindView(R.id.tvGender) TextView tvGender;

    @Override
    public int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initData() {
        tvNickname.setText(App.getInstance().getUserInfoBean().getData().getNickname());
        tvAccount.setText(App.getInstance().getUserInfoBean().getData().getUsername());
        int gender = App.getInstance().getUserInfoBean().getData().getGender();
        if (gender == 1) {
            tvGender.setText(R.string.male);
        } else {
            tvGender.setText(R.string.female);
        }
    }

    @Override
    public void configView() {
        tvHead.setText(R.string.my_userinfo);
        Glide.with(this).load(App.getInstance().getUserInfoBean().getData().getAvatar()).into(circleImageView);
    }

    @OnClick({R.id.ivBack, R.id.rlMyIcon, R.id.rlMessage, R.id.rlAddress, R.id.rlTip, R.id.rlGender,R.id.rlNickname})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlNickname:
                startToActivity(NicknameActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlGender://性别
                final List<String> mData = new ArrayList<>();
                mData.add(String.valueOf(R.string.male));
                mData.add(String.valueOf(R.string.female));
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        String tx = mData.get(options1);
                        tvGender.setText(tx);
                    }
                }).build();
                pickerView.setPicker(mData);
                pickerView.show();
                break;
            case R.id.rlMyIcon:

                break;
            case R.id.rlMessage://账户信息

                break;
            case R.id.rlAddress://收货地址

                break;
            case R.id.rlTip://个性标签
                startToActivity(TipActivity.class);
                break;
        }
    }
}
