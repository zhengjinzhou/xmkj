package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;

/**
 * Created by zhou on 2018/5/29.
 */

public interface RegisterContract {
    interface View extends BaseContract.BaseView {
        void RegisterSuccess(BaseBean baseBean);
        void getCodeNumSuccess(BaseBean baseBean);

        String setMobile();

        String setCode();

        String setPassword();

        String getPusername();

        boolean setCheckBox();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCodeNum();//获取二维码

        void Register();

        boolean getCheckBox();

        String getMobile();

        String getCode();

        String getPassword();

        String getPusername();
    }
}
