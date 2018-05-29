package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.MyFansBean;

/**
 * Created by zhou on 2018/5/29.
 */

public interface MyFansContract {

    interface View extends BaseContract.BaseView {
        void getIndexFansSuccess(MyFansBean myFansBean);

        String setId();

        String setToken();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getIndexFans();

        String getId();

        String getToken();
    }
}
