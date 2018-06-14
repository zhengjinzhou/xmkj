package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.WalletMoreBean;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public interface WalletMoreContract {
    interface View extends BaseContract.BaseView {
        int setPage();

        int setPageSize();

        int setType();

        void getWalletMoreSuccess(WalletMoreBean moreBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        int getPage();

        int getPageSize();

        int getType();

        void getWalletMoreDetail();
    }
}
