package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public interface SetZhiContract {
    interface View extends BaseContract.BaseView {
        String setPaypwd();

        void editUserInfoSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        String getPaypwd();

        void editUserInfo();
    }
}
