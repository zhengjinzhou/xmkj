package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.UserInfoBean;

/**
 * Created by zhou on 2018/5/28.
 */

public interface UserInfoContract {

    interface View extends BaseContract.BaseView {
        void getUserInfoSuccess(UserInfoBean userInfoBean);

        String setId();

        String setToken();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getUserInfo();

        String getId();

        String getToken();
    }
}
