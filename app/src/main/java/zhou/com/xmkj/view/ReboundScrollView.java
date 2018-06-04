package zhou.com.xmkj.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * Created by zhou
 * on 2018/6/4.
 */

public class ReboundScrollView extends NestedScrollView {

    private View contentView;
    // 用于记录正常的布局位置
    private Rect originalRect = new Rect();
    private boolean canPullDown;
    private boolean canPullUp;
    private float startY;
    // 在手指滑动的过程中记录是否移动了布局
    private boolean isMoved = false;
    // 松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 300;
    // 移动因子, 是一个百分比, 比如手指移动了100px, 那么View就只移动50px 目的是达到一个延迟的效果
    private static final float MOVE_FACTOR = 0.5f;

    public ReboundScrollView(Context context) {
        this(context, null);
    }

    public ReboundScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReboundScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * onFinishInflate
     * 当View中所有的子控件均被映射成xml后出发
     */
    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
        super.onFinishInflate();
    }

    /**
     * 在该方法总获取ScrollView中的唯一子控件的位置信息
     * 这个位置信息在整个控件的生命周期中保持不变
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (contentView == null) {
            return;
        }
        // ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(), contentView.getBottom());
    }

    /**
     * 在触摸事件中，处理上拉下拉的逻辑
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (contentView == null) {
            return super.dispatchTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //判断是否可以上下拉
                canPullDown = isCanPullDown();
                canPullUp = isCanPullUp();

                startY = ev.getY();
                break;

            case MotionEvent.ACTION_UP:
                if (!isMoved)
                    break;// 如果没有移动布局， 则跳过执行
                //开启动画
                TranslateAnimation animation = new TranslateAnimation(0, 0, contentView.getTop(), originalRect.top);
                animation.setDuration(ANIM_TIME);
                contentView.startAnimation(animation);

                //设置回到正常的布局位置
                contentView.layout(originalRect.left, originalRect.top, originalRect.right, originalRect.bottom);
                //将标志设回flase
                canPullUp = false;
                canPullDown = false;
                isMoved = false;
                break;

            case MotionEvent.ACTION_MOVE:
                // 在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if (!canPullDown && !canPullUp) {
                    startY = ev.getY();
                    canPullUp = isCanPullUp();
                    canPullDown = isCanPullDown();
                }
                //计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = (int) (nowY - startY);
                // 是否应该移动布局
                boolean shouldMove = (canPullDown && deltaY > 0) // 可以下拉， 并且手指向下移动
                        || (canPullUp && deltaY < 0) // 可以上拉， 并且手指向上移动
                        || (canPullUp && canPullDown); // 既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）
                if (shouldMove) {

                    // 计算偏移量
                    int offset = (int) (deltaY * MOVE_FACTOR);

                    // 随着手指的移动而移动布局
                    contentView.layout(originalRect.left, originalRect.top + offset, originalRect.right, originalRect.bottom + offset);

                    isMoved = true; // 记录移动了布局
                }
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }



    /**
     * 判断是否可以滚动到顶部
     *
     * @return
     */
    private boolean isCanPullDown() {
        return getScrollY() == 0 || contentView.getHeight() < getHeight() + getScrollY();
    }

    /**
     * 判断是否可以滚动底部
     *
     * @return
     */
    private boolean isCanPullUp() {
        return contentView.getHeight() <= getHeight() + getScrollY();
    }
}
