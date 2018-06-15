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
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zhou.com.xmkj.R;
import zhou.com.xmkj.base.App;
import zhou.com.xmkj.base.BaseActivity;
import zhou.com.xmkj.bean.BaseBean;
import zhou.com.xmkj.bean.QiNiuBean;
import zhou.com.xmkj.ui.activity.personmessage.TipActivity;
import zhou.com.xmkj.ui.contract.UserContract;
import zhou.com.xmkj.ui.presenter.UserPresenter;
import zhou.com.xmkj.utils.QiNiuUtils;
import zhou.com.xmkj.utils.ToastUtils;

/**
 * Created by zhou on 2018/5/28.
 * 个人信息
 */

public class UserInfoActivity extends BaseActivity implements UserContract.View{

    private static final int REQUEST_PICK_IMAGE = 1;
    private static final String TAG = "UserInfoActivity";
    @BindView(R.id.tvHead) TextView tvHead;
    @BindView(R.id.tvNickname) TextView tvNickname;
    @BindView(R.id.CircleImageView) CircleImageView circleImageView;
    @BindView(R.id.tvAccount) TextView tvAccount;
    @BindView(R.id.tvGender) TextView tvGender;
    @BindView(R.id.tvRight) TextView tvRight;
    private String[] mCustomItems = new String[]{"相册", "拍照"};
    public static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    public static final int CROP_PHOTO = 2;
    private static final int CHOOSE_PHOTO = 3;//打开相册
    public static File tempFile;
    private Uri imageUri;
    private UserPresenter mPresenter = new UserPresenter(this);
    private String txGenderString = "1";
    String imagePath = "";


    @Override
    public int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initData() {
        tvNickname.setText(App.getInstance().getUserInfoBean().getData().getNickname());
        tvAccount.setText(App.getInstance().getUserInfoBean().getData().getUsername());
        int gender = App.getInstance().getUserInfoBean().getData().getGender();
        if (gender == 1) {
            tvGender.setText(R.string.male);
        } else {
            tvGender.setText(R.string.female);
        }
    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        tvHead.setText(R.string.my_userinfo);
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("保存");
        Glide.with(this).load(App.getInstance().getUserInfoBean().getData().getAvatar()).into(circleImageView);
    }

    @OnClick({R.id.ivBack, R.id.rlMyIcon, R.id.rlAddress, R.id.rlTip, R.id.rlGender,R.id.rlNickname,R.id.tvRight})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRight://保存
                dialog.show();
                mPresenter.editUserSuccess();
                break;
            case R.id.rlNickname:
                startToActivity(NicknameActivity.class);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.rlGender://性别
                final List<String> mData = new ArrayList<>();
                mData.add(getResources().getString(R.string.male));
                mData.add(getResources().getString(R.string.female));
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        txGenderString = mData.get(options1);
                        tvGender.setText(txGenderString);
                    }
                }).build();
                pickerView.setPicker(mData);
                pickerView.show();
                break;
            case R.id.rlMyIcon:
                selectPicture();
                break;
            case R.id.rlAddress://收货地址
                startToActivity(AddressActivity.class);
                break;
            case R.id.rlTip://个性标签
                startToActivity(TipActivity.class);
                break;
        }
    }

    /**
     * 选择照片
     * 拍照
     */
    private void selectPicture() {
        //创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择：");
        builder.setItems(mCustomItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //相册
                    if (ContextCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(UserInfoActivity.this, new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, CHOOSE_PHOTO);
                    }
                } else if (which == 1) {
                    //拍照
                    if (ContextCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(UserInfoActivity.this, new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        openCamera();
                    }
                }
            }
        });
        builder.create().show();
    }

    /**
     * //拍照
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
                        imagePath = saveCroppedImage(bitmap);

                        circleImageView.setImageBitmap(bitmap);
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
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {

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
        Glide.with(this).load(imagePath).into(circleImageView);
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

    @Override
    public void editUserSuccess(BaseBean baseBean) {
        Log.d(TAG, "editUserSuccess: "+baseBean.toString());
        ToastUtils.showLongToast(baseBean.getMsg());

        if (baseBean.getCode()==200){
            //上传到七牛
            QiNiuBean qiNiuBean = App.getInstance().getQiNiuBean();
            if (qiNiuBean.getData()!=null){
                QiNiuUtils.uploadImageToQiniu(imagePath,qiNiuBean.getData().getUpToken());
            }
        }
    }

    private String saveCroppedImage(Bitmap bmp) {
        File file = new File("/sdcard/myFolder");
        if (!file.exists())
            file.mkdir();

        String newFilePath = "/sdcard/myFolder" + "/" + System.currentTimeMillis() + "_cropped" +  ".jpg";
        file = new File(newFilePath);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFilePath;
    }

    @Override
    public String setAvater() {
        Log.d(TAG, "setAvater: "+imagePath);
        return imagePath;
    }

    @Override
    public String setGender() {
        Log.d(TAG, "setGender: "+txGenderString);
        String pos = "1";
        if (txGenderString.equals("女")){
            pos = "2";
        }
        return pos;
    }

    @Override
    public void showError() {
        dialog.dismiss();
    }

    @Override
    public void complete() {
        dialog.dismiss();
    }
}
