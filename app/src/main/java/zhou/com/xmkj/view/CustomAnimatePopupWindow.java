package zhou.com.xmkj.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.PopupWindow;

import zhou.com.xmkj.R;

/**
 * Created by zhou
 * on 2018/6/12.
 */


public class CustomAnimatePopupWindow extends PopupWindow {
    private View contentView;
    private final int duration = 300;
    private OnCustomDismissListener onCustomDismissListener;

    public CustomAnimatePopupWindow(View view,int width, int height) {
        super();
        contentView = view;
        setContentView(contentView);
        setWidth(width);
        setHeight(height);
        // 去掉默认的动画效果(showAsDropDown可能会自带默认动画)
        setAnimationStyle(R.style.custom_anim_pop);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
        postAnimateIn(anchor);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        postAnimateIn(parent);
    }

    private void postAnimateIn(View postView) {
        postView.postDelayed(new Runnable() {
            @Override
            public void run() {
                animateIn();
            }
        }, 1);
    }

    private void animateIn() {

        int height = contentView.getHeight();
        contentView.setTranslationY(height);
        contentView.animate().translationY(0).setDuration(duration)
                .setListener(null).setInterpolator(new AccelerateDecelerateInterpolator()).start();

    }

    /**
     * 直接关闭PopupWindow，没有动画效果
     */
    public void superDismiss() {
        super.dismiss();
        if (onCustomDismissListener != null) {
            onCustomDismissListener.onDismiss();
        }
    }

    @Override
    public void dismiss() {

    }

    public void setOnCustomDismissListener(OnCustomDismissListener onCustomDismissListener) {
        this.onCustomDismissListener = onCustomDismissListener;
    }

    public interface OnCustomDismissListener {

        /**
         * 开始消失，这个时候PopupWindow还在，只是在执行消失动画
         */
        public void onStartDismiss();

        /**
         * 完全消失
         */
        public void onDismiss();
    }

}
