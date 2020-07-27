package com.beautifourest.forestapp.ui.mushroom;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.PostJsonsForResult;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MushroomViewModel extends baseViewModel {

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    public final ObservableField<String> mushroom_result=new ObservableField<>();

    // user
    UserJson user;
    Context context;

    RotateLoading rotateLoading;

    // 사진 + 정보 보내기
    private MultipartBody.Part mpFile;
    Bitmap originalBm;
    String filePath="";

    public MushroomViewModel(UserJson user,Context context) {
        this.user = user;
        this.mushroom_result.set("궁금한 버섯 사진을 등록해주세요");
        this.context=context;
    }

    public Bitmap getOriginalBm() {
        return originalBm;
    }

    public void setOriginalBm(Bitmap originalBm) {
        this.originalBm = originalBm;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RotateLoading getRotateLoading() {
        return rotateLoading;
    }

    public void setRotateLoading(RotateLoading rotateLoading) {
        this.rotateLoading = rotateLoading;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    public void getresult(){ // 독버섯인지 버섯인지 판단
        Log.d("Test","determine mushroom");

        if(filePath.equals("")){ // 사진 등록이 되어 있지 않다
            mushroom_result.set("!!!사진이 등록되지 않았습니다!!!");
            Log.d("Test","필수 입력 값 안됨");
            return;
        }

        // 사진 넣기
        Log.d("camera_forest", "mushroom bitmaap viewmodel : " + originalBm);

        if (filePath != null) {
            String extension = filePath.substring(filePath.lastIndexOf("."));
            Log.d("",context.getFilesDir().getPath());
            File file = new File(context.getFilesDir(), "localImgFile"+extension);//내부저장소에서 가져오기
            //File file = new File(filePath);//filePath);
            try {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                originalBm.compress(Bitmap.CompressFormat.JPEG, 70, os);
                os.close();
                URLEncoder.encode(file.getName(), "utf-8");
                RequestBody rqFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                mpFile = MultipartBody.Part.createFormData("img", file.getName(), rqFile); // 키값, 파일 이름, 데이터

                Log.d("camera_forest", "mpfile mushroom 성공");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getContext(),"사진의 경로가 정확하지 않습니다.", Toast.LENGTH_SHORT).show();
            Log.d("camera_forest", "mpfile mushroom 실패");
            return;
        }

        requestForServer.setOp("uploadMushroom"); // 실행할 명령 지정
        requestForServer.setMpFile(mpFile); // 파일 지정

        Log.d("camera_forest", "변수 버섯 등록");

        rotateLoading.start();

        requestForServer.exec_photo(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsonsForResult data = (PostJsonsForResult)receivedData;

                if(data.getStatus().equals("OK")){ // 보내기 성공
                    rotateLoading.stop();
                    mushroom_result.set(data.getResult());
                }

                else if(data.getStatus().equals("not OK")){ // 파일 없
                    Log.d("camera_forest", "파일 안들어감. mushroom");
                }
                else{
                    Log.d("camera_forest",data.getStatus());
                    Log.d("camera_forest",data.getMessage());
                }
            }


            @Override
            public void onFailure(int code) {
                Log.d("camera_forest", "Code:" +code);
                Log.d("Test","Failure");
            }
        });
        Log.d("camera_forest", "프래그먼트 종료");
    }
}