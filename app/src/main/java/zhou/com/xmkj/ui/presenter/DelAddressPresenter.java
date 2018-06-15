package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.base.RxPresenter;
import zhou.com.xmkj.ui.adapter.AddressAdapter;
import zhou.com.xmkj.ui.contract.DelAddressContract;
import zhou.com.xmkj.ui.contract.FansContract;
import zhou.com.xmkj.ui.fragment.IndexFragment;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public class DelAddressPresenter extends RxPresenter<DelAddressContract.View> implements DelAddressContract.Presenter<DelAddressContract.View>  {

    AddressAdapter addressAdapter;
    XmkjApi xmkjApi;

    public DelAddressPresenter(AddressAdapter addressAdapter){
        this.addressAdapter = addressAdapter;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }

    @Override
    public void delUserAddress() {

    }

}
