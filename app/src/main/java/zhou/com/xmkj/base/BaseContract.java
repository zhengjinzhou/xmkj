package zhou.com.xmkj.base;

/**
 * Created by zhou on 2018/3/21.
 * 所有方法的基类，是整个应用都需要用上的方法
 * 一般是加载完成出错成功等的方法
 * 分为view与presenter两样式
 */

public interface BaseContract {

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }

    interface BaseView {
        void showError();

        void complete();
    }
}
