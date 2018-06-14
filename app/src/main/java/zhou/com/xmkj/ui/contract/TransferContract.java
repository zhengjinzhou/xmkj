package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.IndexBean;
import zhou.com.xmkj.bean.InvestBean;

/**
 * Created by zhou
 * on 2018/6/14.
 * 流通投资首页
 */

public interface TransferContract {
    interface View extends BaseContract.BaseView {
        void getInvestIndexSuccess(InvestBean indexBean);

        void userTransferSuccess(BaseBean baseBean);

        int setType();

        String setUserName();

        String setMoney();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getInvestIndex();

        void userTransfer();

        int getType();

        String getUserName();

        String getMoney();
    }
}
