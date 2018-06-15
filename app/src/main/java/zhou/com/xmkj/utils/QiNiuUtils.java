package zhou.com.xmkj.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public class QiNiuUtils {

    public static void uploadImageToQiniu(String filePath, String token) {
        UploadManager uploadManager = new UploadManager();
        Log.d("-----------------", "uploadImageToQiniu: "+filePath);
        uploadManager.put(filePath, null, token, new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo info, JSONObject res) {
                // info.error中包含了错误信息，可打印调试
                // 上传成功后将key值上传到自己的服务器
                if (info.isOK()){
                    ToastUtils.showLongToast("上传成功");
                }else {
                    ToastUtils.showLongToast("上传失败");
                }
            }
        }, null);
    }
}
