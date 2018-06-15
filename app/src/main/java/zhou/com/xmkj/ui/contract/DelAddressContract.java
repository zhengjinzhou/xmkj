package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.FansListBean;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public interface DelAddressContract {

    interface View extends BaseContract.BaseView {
        void delUserAddressSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void delUserAddress();
    }
}
