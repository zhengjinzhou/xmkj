package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface SettingContract {
    interface View extends BaseContract.BaseView {
        void LogoutSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void Logout();
    }
}
