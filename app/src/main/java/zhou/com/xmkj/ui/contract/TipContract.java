package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public interface TipContract  {
    interface View extends BaseContract.BaseView{
        void editUserInfoSuccess(BaseBean baseBean);
        String setTip();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void editUserInfo();
        String getTip();
    }
}
