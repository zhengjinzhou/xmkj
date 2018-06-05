package zhou.com.xmkj.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.ui.contract.RealNameContract;
import zhou.com.xmkj.ui.presenter.RealNamePresenter;
import zhou.com.xmkj.utils.IDCardUtil;
import zhou.com.xmkj.utils.Ranst;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * 实名认证
 */
public class RealNameAuthenticationActivity extends BaseActivity implements RealNameContract.View {

    private static String TAG = "RealNameAuthenticationActivity";
    @BindView(R.id.tvHead)
    TextView tvHead;
    @BindView(R.id.tvAccount)
    TextView tvAccount;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etNumber)
    EditText etNumber;
    @BindView(R.id.ivZhengMian)
    ImageView ivZhengMian;
    @BindView(R.id.ivFanMian)
    ImageView ivFanMian;
    private String[] mCustomItems = new String[]{"相册", "拍照"};
    private int index = 0;
    public static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    public static final int CROP_PHOTO = 2;
    private static final int CHOOSE_PHOTO = 3;//打开相册
    private Uri imageUri;
    public static File tempFile;
    private RealNamePresenter mPresenter = new RealNamePresenter(this);
    private List<String> imageURL = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_real_name_authentication;
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        tvHead.setText(R.string.txt_real_name_authentication);
        if (App.getInstance().getUserInfoBean() != null)
            tvAccount.setText(App.getInstance().getUserInfoBean().getData().getUsername());
        mPresenter.attachView(this);
    }

    @OnClick({R.id.ivBack, R.id.ivZhengMian, R.id.ivFanMian, R.id.btSubmit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivZhengMian:
                showDialogCustom(0);
                break;
            case R.id.ivFanMian:
                showDialogCustom(1);
                break;
            case R.id.btSubmit:
                String username = etUsername.getText().toString().trim();
                String number = etNumber.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    ToastUtils.showLongToast("真实姓名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(number)) {
                    ToastUtils.showLongToast("身份证不能为空");
                    return;
                }
                try {
                    String s = IDCardUtil.IDCardValidate(number);
                    if (s.length() > 0) {
                        ToastUtils.showLongToast(s);
                        return;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (imageURL.size() == 0) {
                    ToastUtils.showLongToast("请上传完整身份证正反面！");
                    return;
                } else if (imageURL.size() == 1) {
                    ToastUtils.showLongToast("请上传完整身份证正反面！");
                    return;
                }
                dialog.show();
                mPresenter.userCertificate();
                break;
        }
    }

    /**
     * 弹出对话框
     */
    private void showDialogCustom(final int pos) {
        //创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择：");
        builder.setItems(mCustomItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //相册
                    if (ContextCompat.checkSelfPermission(RealNameAuthenticationActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(RealNameAuthenticationActivity.this, new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        openAlbum(pos);
                    }
                } else if (which == 1) {
                    //拍照
                    ToastUtils.showLongToast("拍张功能待续。");
                    //openCamera();
                }
            }
        });
        builder.create().show();
    }

    /**
     * 调用相册
     */
    private void openAlbum(int pos) {
        index = pos;
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PHOTO_REQUEST_CAREMA:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                }
                break;
            case CROP_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        //ivZhengMian.setImageBitmap(bitmap);
                        setUriPhoto(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    //已经选择图片成功
                    handleImageOnKitKat(data);
                }
                break;
        }

    }

    private void setUriPhoto(Bitmap bitmap) {
        switch (index) {
            case 0:
                ivZhengMian.setImageBitmap(bitmap);
                break;
            case 1:
                ivFanMian.setImageBitmap(bitmap);
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的URI，则通过document id 处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1]; //解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的Uri,则用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是file类型的Uri,直接获取图片路径即可
            imagePath = uri.getPath();
        }
        //displayImage(imagePath); //根据图片路径显示图片
        setPhoto(imagePath);
    }

    /**
     * 选择相册---显示照片
     *
     * @param imagePath
     */
    private void setPhoto(String imagePath) {
        switch (index) {
            case 0:
                imageURL.add(imagePath);
                Glide.with(this).load(imagePath).into(ivZhengMian);
                break;
            case 1:
                imageURL.add(imagePath);
                Glide.with(this).load(imagePath).into(ivFanMian);
                break;
        }
    }

    /**
     * 查找照片
     *
     * @param uri
     * @param selection
     * @return
     */
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    /**
     * 拍照
     */
    public void openCamera() {
        //獲取系統版本
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                    "yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(),
                    filename + ".jpg");
            if (currentapiVersion < 24) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                    return;
                }
                imageUri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
        this.startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
    }

    /**
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    @Override
    public String setId() {
        return App.getInstance().getLoginBean().getData().getId() + "";
    }

    @Override
    public String setToken() {
        return App.getInstance().getLoginBean().getData().getToken();
    }

    @Override
    public String setRealname() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String setIdCard() {
        return etNumber.getText().toString().trim();
    }

    @Override
    public String setIdcardFront() {
        return imageURL.get(0);
    }

    @Override
    public String setIdcardBack() {
        return imageURL.get(1);
    }

    @Override
    public void userCertificateSuccess(BaseBean baseBean) {
        Log.d(TAG, "userCertificateSuccess: " + baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }
}
