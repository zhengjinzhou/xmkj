package zhou.com.xmkj.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import zhou.com.xmkj.base.App;

/**
 * Created by zhou
 * on 2018/6/5.
 */

public class Ranst {
    /**
     * 数字与小写字母混编字符串
     * @param size
     * @return
     */
    public static String getNumSmallLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            if(random.nextInt(2) % 2 == 0){//字母
                buffer.append((char) (random.nextInt(27) + 'a'));
            }else{//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }
    public static String getIdentity() {
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        String identity = preference.getString("identity", null);
        if (identity == null) {
            identity = java.util.UUID.randomUUID().toString();
            preference.edit().putString("identity", identity);
        }
        return identity;
    }


    public static Bitmap comp(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        //判断如果图片大于1M,进行压缩避免在生成图片
        //（BitmapFactory.decodeStream）时溢出
        if( baos.toByteArray().length / 1024>1024) {
            baos.reset();//重置baos即清空baos
            //这里压缩50%，把压缩后的数据存放到baos中
            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }
    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        //循环判断如果压缩后图片是否大于100kb,大于继续压缩
        while ( baos.toByteArray().length / 1024>100) {
            //重置baos即清空baos
            baos.reset();
            //这里压缩options%，把压缩后的数据存放到baos中
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;//每次都减少10
        }
        //把压缩后的数据baos存放到ByteArrayInputStream中
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        //把ByteArrayInputStream数据生成图片
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        return bitmap;
    }
}
