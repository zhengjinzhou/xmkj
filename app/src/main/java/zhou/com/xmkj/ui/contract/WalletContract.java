package zhou.com.xmkj.ui.contract;

import zhou.com.xmkj.base.BaseContract;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.WalletBean;

/**
 * Created by zhou
 * on 2018/6/13.
 * 获取用户钱包
 * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
 */

public interface WalletContract {

    interface View extends BaseContract.BaseView {
        int setType();

        void getUserWalletSuccess(WalletBean walletBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        int getType();

        void getUserWallet();
    }
}
