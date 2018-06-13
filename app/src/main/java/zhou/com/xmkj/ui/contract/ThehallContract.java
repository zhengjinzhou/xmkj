package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.RewardDetailBean;
import zhou.com.xmkj.bean.ShareSalesBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface ThehallContract {
    interface View extends BaseContract.BaseView {
       void getShareIndexSuccess(ShareSalesBean shareSalesBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getShareIndex();
    }
}
