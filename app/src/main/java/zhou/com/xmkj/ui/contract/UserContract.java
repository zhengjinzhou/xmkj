package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.UserInfoBean;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public interface UserContract {
    interface View extends BaseContract.BaseView {
        void editUserSuccess(BaseBean baseBean);

        String setAvater();

        String setGender();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        String getAvater();

        String getGender();

        void editUserSuccess();
    }
}
