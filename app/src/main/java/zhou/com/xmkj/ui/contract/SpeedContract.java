package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.RewardDetailBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface SpeedContract {

    interface View extends BaseContract.BaseView {
        int setPage();

        int setPageSize();

        void getRewardDetailSuccess(RewardDetailBean rewardDetailBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        int getPage();

        int getPageSize();

        void getRewardDetail();
    }
}
