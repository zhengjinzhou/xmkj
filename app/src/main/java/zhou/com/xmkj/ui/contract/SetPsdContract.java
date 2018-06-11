package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/11.
 */

public interface SetPsdContract {

    interface View extends BaseContract.BaseView {
        String setPassword();

        String Aspassword();

        String setMobile();

        void setNewPasswordSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        String getPassword();

        String getAspassword();

        String getMobile();

        void setNewPassword();
    }
}
