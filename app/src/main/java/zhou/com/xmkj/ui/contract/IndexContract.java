package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.IndexBean;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public interface IndexContract {

    interface View extends BaseContract.BaseView{
        void getIndexSuccess(IndexBean indexBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void getIndex();
    }
}
