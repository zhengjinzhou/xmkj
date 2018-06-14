package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public interface KeyContract {

    interface View extends BaseContract.BaseView {
        String setAccessKey();

        String setSecretKey();

        void editKeySuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void editKey();

        String getAccessKey();

        String getSecretKey();
    }
}
