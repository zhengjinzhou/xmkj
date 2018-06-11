package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/11.
 */

public interface SettingPasswordContract {
    interface View extends BaseContract.BaseView {
        void getCodeNumSuccess(BaseBean baseBean);

        void checkVerifyCodeSueecss(BaseBean baseBean);

        String setMobile();

        String setCode();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCodeNum();//获取二维码

        void checkVerifyCode();

        String getMobile();

        String getCode();
    }
}
