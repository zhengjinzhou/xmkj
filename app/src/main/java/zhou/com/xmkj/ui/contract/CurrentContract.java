package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.IntradeBean;

/**
 * Created by zhou on 2018/5/31.
 * 流通交易界面
 */

public interface CurrentContract {
    interface View extends BaseContract.BaseView {
        void getIntradeSuccess(IntradeBean intradeBean);

        int setId();

        String setToken();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getIntrade();

        int getId();

        String getToken();
    }
}
