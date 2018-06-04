package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.LoginBean;

/**
 * Created by zhou
 * on 2018/6/4.
 * 实名验证
 */

public interface RealNameContract {
    interface View extends BaseContract.BaseView {
        String setId();

        String setToken();

        String setRealname();

        String setIdCard();

        String setIdcardFront();

        String setIdcardBack();

        void userCertificateSuccess(BaseBean baseBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        String getId();

        String getToken();

        String getRealname();

        String getIdCard();

        String getIdcardFront();

        String getIdcardBack();

        void userCertificate();
    }
}
