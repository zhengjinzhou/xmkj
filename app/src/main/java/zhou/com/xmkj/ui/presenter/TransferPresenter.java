package zhou.com.xmkj.ui.presenter;

import okhttp3.OkHttpClient;
import zhou.com.xmkj.api.XmkjApi;
import zhou.com.xmkj.ui.activity.current.TransferActivity;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class TransferPresenter  {

    TransferActivity vrchActivity;
    XmkjApi xmkjApi;

    public TransferPresenter(TransferActivity vrchActivity) {
        this.vrchActivity = vrchActivity;
        xmkjApi = new XmkjApi(new OkHttpClient());
    }
}
