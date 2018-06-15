package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.LoginBean;
import zhou.com.xmkj.bean.QiNiuBean;

/**
 * Created by zhou on 2018/5/25.
 */

public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(LoginBean loginBean);

        void uploadTokenSuccess(QiNiuBean qiNiuBean);

        String setUsername();

        String setPasswrod();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login();

        void uploadToken();

        String getUsername();

        String getPassword();
    }
}
