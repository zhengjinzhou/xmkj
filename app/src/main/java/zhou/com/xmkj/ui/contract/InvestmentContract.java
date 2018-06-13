package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface InvestmentContract {
    interface View extends BaseContract.BaseView {
        String setRname();

        int setPos();

        void updateUserVipSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void updateUserVip();

        String getRname();

        int getPos();
    }
}
