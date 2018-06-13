package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.TradingBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface TradingContract {
    interface View extends BaseContract.BaseView {

        void getExchangeDetailSuccess(TradingBean tradingBean);

        int setPage();

        int setPageSize();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getExchangeDetail();

        int getPage();

        int getPageSize();
    }
}
