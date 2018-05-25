package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.LoginBean;

/**
 * Created by zhou on 2018/5/25.
 */

public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(LoginBean loginBean);
        String setUsername();

        String setPasswrod();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login();

        String getUsername();

        String getPassword();
    }
}
