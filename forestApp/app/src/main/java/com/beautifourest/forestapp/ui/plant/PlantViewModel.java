package com.beautifourest.forestapp.ui.plant;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.Model.PostJsonsForResult;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;
import com.beautifourest.forestapp.ui.insertPlants.ExifUtils;
import com.victor.loading.rotate.RotateLoading;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class PlantViewModel extends baseViewModel {

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    public final ObservableField<String> plant_result=new ObservableField<>();

    // user
    UserJson user;
    Context context;

    RotateLoading rotateLoading;

    // 사진 + 정보 보내기
    private MultipartBody.Part mpFile;
    Bitmap originalBm;
    String filePath="";

    public PlantViewModel(UserJson user,Context context) {
        this.user = user;
        this.plant_result.set("궁금한 식물 사진을 등록해주세요");
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

    public void getresult(){ // 식물 판별
        Log.d("Test","determine plant");

        if(filePath.equals("")){ // 사진 등록이 되어 있지 않다
            plant_result.set("!!!사진이 등록되지 않았습니다!!!");
            return;
        }

        // 사진 넣기
        Log.d("camera_forest", "plant bitmap viewmodel : " + originalBm);

        if (filePath != null) {
            String extension = filePath.substring(filePath.lastIndexOf("."));
            Log.d("",context.getFilesDir().getPath());
            File file = new File(context.getFilesDir(), "localImgFile"+extension);//내부저장소에서 가져오기
            //File file = new File(filePath);
            try {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                originalBm.compress(Bitmap.CompressFormat.JPEG, 70, os);
                originalBm= ExifUtils.rotateBitmap(filePath,originalBm);
                os.close();

                RequestBody rqFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                mpFile = MultipartBody.Part.createFormData("img", file.getName(), rqFile); // 키값, 파일 이름, 데이터

                Log.d("camera_forest", "mpfile plant 성공");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getContext(),"사진의 경로가 정확하지 않습니다.", Toast.LENGTH_SHORT).show();
            Log.d("camera_forest", "mpfile plant 실패");
            return;
        }

        requestForServer.setOp("uploadPlant"); // 실행할 명령 지정
        requestForServer.setMpFile(mpFile); // 파일 지정

        Log.d("camera_forest", "변수 식물 등록");

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
                    plant_result.set(data.getResult());
                }

                else if(data.getStatus().equals("not OK")){ // 파일 없
                    Log.d("camera_forest", "파일 안들어감. plant");
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