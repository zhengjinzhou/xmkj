package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.FansListBean;

/**
 * Created by zhou on 2018/5/30.
 * 粉丝-总粉丝-分享粉丝-共享粉丝-社群粉丝
 * 主要就是更换type
 */

public interface FansContract {

    interface View extends BaseContract.BaseView {
        void getFansListSuccess(FansListBean fansListBean);

        int setId();

        String setToken();

        int setPage();

        int setType();

        int PageSize();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getFansList();

        int getId();

        String getToken();

        int getPage();

        int getType();

        int getPageSize();
    }
}
