package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.AddAddressBean;
import zhou.com.xmkj.bean.AddressBean;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public interface AddAddressContract {
    interface View extends BaseContract.BaseView {
        void addUserAddressSuccess(AddAddressBean addAddressBean);

        String setUsername();

        String setMobile();

        String setAddress();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void addUserAddress();

        String getUsername();

        String getMobile();

        String getAddress();
    }
}
