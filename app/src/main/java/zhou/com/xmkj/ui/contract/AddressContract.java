package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.AddressBean;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public interface AddressContract {
    interface View extends BaseContract.BaseView {
        void getAddressListSuccess(AddressBean addressBean);

        void delUserAddressSuccess(BaseBean baseBean);

        int setPage();

        int setPageSize();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getAddressList();

        int getPage();

        int getPageSize();

        void delUserAddress(int pid);
    }
}
