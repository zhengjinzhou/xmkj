package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.VrchInfoBean;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public interface VRCHContract {
    interface View extends BaseContract.BaseView {
        void getVrchInfoSuccess(VrchInfoBean vrchInfoBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getVrchInfo();
    }
}
