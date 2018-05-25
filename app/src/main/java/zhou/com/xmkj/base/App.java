package zhou.com.xmkj.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhou on 2018/5/25.
 */

public class App extends Application {

    private static App app;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mContext = this;
    }

    public static App getInstance(){
        return app;
    }

    public static Context getAppContext() {
        return mContext;
    }
}
