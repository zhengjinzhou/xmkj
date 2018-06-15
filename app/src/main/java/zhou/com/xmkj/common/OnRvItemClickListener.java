package zhou.com.xmkj.common;

import android.view.View;

/**
 * Created by zhou
 * on 2018/6/15.
 */
public interface OnRvItemClickListener<T> {
    void onItemClick(View view, int position, T data);
}
