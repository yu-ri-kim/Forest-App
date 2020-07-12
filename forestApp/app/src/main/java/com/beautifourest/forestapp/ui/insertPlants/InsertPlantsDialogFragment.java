package com.beautifourest.forestapp.ui.insertPlants;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.ActivityResultEvent;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.ImageResizeUtils;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentInsertbookdialogBinding;
import com.beautifourest.forestapp.databinding.FragmentInsertdialogBinding;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.squareup.otto.Subscribe;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertPlantsDialogFragment extends DialogFragment implements CallAnotherActivityNavigator {
    /* 카메라 */
    private static final String TAG = "camera_forest"; // 디버깅 변수
    private Boolean isPermission = true; // 환경설정변수
    private static final int PICK_FROM_ALBUM = 1;
    private static final int PICK_FROM_CAMERA = 2;
    private File tempFile; // 임시파일
    private Activity activity; // 액티비티
    View o; // 뷰
    private Boolean isCamera = false;
    /* 카메라 */

    public static final String TAG_EVENT_DIALOG = "dialog_event";
    InsertPlantsDialogViewModel model;
    private UserJson user;

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    public InsertPlantsDialogFragment() {
        // Required empty public constructor
    }
    public static InsertPlantsDialogFragment instance() {
        return new InsertPlantsDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        o = DataBindingUtil.inflate(inflater, R.layout.fragment_insertbookdialog, container, false).getRoot();
        model = new InsertPlantsDialogViewModel(user,this); // 유저랑 병명 정보 리스트 주기

        /* 카메라 */
        tedPermission(); // 권한 설정

        o.findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 권한 허용에 동의하지 않았을 경우 토스트를 띄웁니다.
                if(isPermission) goToAlbum();
                else Toast.makeText(view.getContext(), getResources().getString(R.string.permission_2), Toast.LENGTH_LONG).show();
            }
        });

        o.findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 권한 허용에 동의하지 않았을 경우 토스트를 띄웁니다.
                if(isPermission)  takePhoto();
                else Toast.makeText(view.getContext(), getResources().getString(R.string.permission_2), Toast.LENGTH_LONG).show();
            }
        });
        /* 카메라 */

        return o;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        //createDateListView(activity);
        this.activity = activity;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentInsertbookdialogBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }

    private void tedPermission() {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                // 권한 요청 성공
                isPermission = true;
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                // 권한 요청 실패
                isPermission = false;
            }
        };

        TedPermission.with(activity)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();

    }

    /* 카메라 - 앨범에서 가져오기 */
    private void goToAlbum() {
        isCamera = false;

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    /* 카메라 - 카메라에서 가져오기 */
    private void takePhoto() {
        isCamera = true;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            Toast.makeText(o.getContext(), "이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        if (tempFile != null) {

            try{
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    Uri photoUri = FileProvider.getUriForFile(activity,
                            "com.beautifourest.forestapp.ui.mushroom.provider", tempFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(intent, PICK_FROM_CAMERA);

                } else {
                    Uri photoUri = Uri.fromFile(tempFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(intent, PICK_FROM_CAMERA);

                }
            }catch (Exception e){
                Toast.makeText(o.getContext(), "카메라 기능을 지원하지 않는 휴대폰입니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /* 카메라 - 폴더 및 사진 만들기 */
    private File createImageFile() throws IOException {
        // 이미지 파일 이름 ( blackJin_{시간}_ )
        String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        String imageFileName = "ForestApp_" + timeStamp + "_";

        // 이미지가 저장될 폴더 이름 ( blackJin )
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/ForestApp/");
        if (!storageDir.exists()) storageDir.mkdirs();

        // 파일 생성
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        Log.d(TAG, "createImageFile : " + image.getAbsolutePath());

        return image;
    }

    /* 카메라 - 사진 바꾸기 */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) { // 취소한 경
            Toast.makeText(o.getContext(), "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            if(tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        Log.e(TAG, tempFile.getAbsolutePath() + " 삭제 성공");
                        tempFile = null;
                    }
                }
            }

            return;
        }

        if (requestCode == PICK_FROM_ALBUM) { //앨범에서 고른경우

            Uri photoUri = data.getData();
            Log.d(TAG, "PICK_FROM_ALBUM photoUri : " + photoUri); // uri로부터 사진을 가져오겠다.

            Cursor cursor = null;

            try {
                /* Uri 스키마를 content:/// 에서 file:/// 로 변경한다. */

                String[] proj = { MediaStore.Images.Media.DATA };
                assert photoUri != null;
                cursor = activity.getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));

                Log.d(TAG, "tempFile Uri : " + Uri.fromFile(tempFile));

            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

            setImage();

        } else if (requestCode == PICK_FROM_CAMERA) {

            setImage();

        }
    }

    /* 카메라 - 비트맵으로 만들기 */
    private void setImage() {
        ImageView imageView = o.findViewById(R.id.imageView); // 이 이미지뷰에 사진을 넣겠다.

        ImageResizeUtils.resizeFile(tempFile, tempFile, 320, isCamera);

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        Log.d(TAG, "setImage : " + tempFile.getAbsolutePath());

        imageView.setImageBitmap(originalBm); // 비트맵으로 변환된 사진을 set 한다.

        model.setOriginalBm(originalBm);
        model.setFilePath(tempFile.getAbsolutePath());

        Log.d(TAG, "bitmaap fragment : " + originalBm);


        /**
         *  tempFile 사용 후 null 처리를 해줘야 합니다.
         *  (resultCode != RESULT_OK) 일 때 tempFile 을 삭제하기 때문에
         *  기존에 데이터가 남아 있게 되면 원치 않은 삭제가 이뤄집니다.
         */
        tempFile = null;

    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onActivityResultEvent(@NonNull ActivityResultEvent event) {
        onActivityResult(event.getRequestCode(), event.getResultCode(), event.getData());
    }


    @Override
    public void callActivity(UserJson user) {

    }

    @Override
    public void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList) {

    }

    @Override
    public void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2) {

    }

    @Override
    public void callFragmentForInfo(int num, HerbJson herb_info) {

    }

    @Override
    public void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user) {

    }

    @Override
    public void closeFragment() {
        dismiss();
    }

    @Override
    public void forToast(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshFragment(int num) {

    }

    @Override
    public void callImageActivity(List<String> imgs, String name) {

    }
}