package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.ShareSalesBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface SunContract {
    interface View extends BaseContract.BaseView {
        void userExchangeSuccess(BaseBean baseBean);

        int setType();

        String setMoney();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void userExchange();

        int getType();

        String getMoney();
    }
}
