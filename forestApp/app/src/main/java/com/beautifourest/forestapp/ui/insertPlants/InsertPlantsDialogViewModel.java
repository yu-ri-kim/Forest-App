package com.beautifourest.forestapp.ui.insertPlants;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class InsertPlantsDialogViewModel extends baseViewModel {

    // 사진 + 정보 보내기
    private MultipartBody.Part mpFile;
    private Map<String, RequestBody> rqMap;
    Bitmap originalBm;
    String filePath="";

    //binding하고 있는 값들
    public final ObservableField<String> fskname = new ObservableField<>();
    public final ObservableField<String> fsename = new ObservableField<>();
    public final ObservableField<String> fslifetime = new ObservableField<>();
    public final ObservableField<String> fsgbn = new ObservableField<>();
    public final ObservableField<String> fsclassname = new ObservableField<>();
    public int isHerb=-1; // 아무값도 선택 안되면 -1
    public int isPV=1;

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    UserJson user; // 유저
    private CallAnotherActivityNavigator navigator; // 화면 전환

    public InsertPlantsDialogViewModel() { }
    public InsertPlantsDialogViewModel(UserJson user, CallAnotherActivityNavigator navigator) {
        this.user = user;
        this.navigator= navigator;
    }

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
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

    public void insert(){
        Log.d("Test","insert");

        if(fskname.get()==null || isHerb==-1 || filePath.equals("")){ // 이름, 허브 선택, 사진 등록이 안되었다면 토스트
            navigator.forToast("필수 입력 값이 입력되지 않았습니다.");
            Log.d("Test","필수 입력 값 안됨");
            return;
        }

        if(fsgbn.get()==null || fsgbn.get().equals("목본류")||fsgbn.get().equals("초본류") ){

        }
        else{
            navigator.forToast("목본류/초본류로 입력해주세요.");
            return;
        }


        Log.d("camera_forest","fskname:"+fskname);
        rqMap = new HashMap<>();
        RequestBody rq_uid = RequestBody.create(MediaType.parse("text/plain"), user.getUid());
        RequestBody rq_fskname = RequestBody.create(MediaType.parse("text/plain"), fskname.get()+"");
        RequestBody rq_fsename = RequestBody.create(MediaType.parse("text/plain"), fsename.get()+"");
        RequestBody rq_fslifetime = RequestBody.create(MediaType.parse("text/plain"), fslifetime.get()+"");
        RequestBody rq_fsgbn = RequestBody.create(MediaType.parse("text/plain"), fsgbn.get()+"");
        RequestBody rq_fsclassname = RequestBody.create(MediaType.parse("text/plain"), fsclassname.get()+"");
        RequestBody rq_herb = RequestBody.create(MediaType.parse("text/plain"),isHerb+"");
        RequestBody rq_pv = RequestBody.create(MediaType.parse("text/plain"),isPV+"");

        Log.d("camera_forest", rq_uid.toString());
        Log.d("camera_forest", rq_fskname.toString());

        rqMap.put("uid", rq_uid); // 유저 아이디
        rqMap.put("fskName", rq_fskname); // 이름
        rqMap.put("fseName", rq_fsename); // 영어이름
        rqMap.put("fsLifeTime", rq_fslifetime); // 식물이야기
        rqMap.put("fsGbn", rq_fsgbn); // 류
        rqMap.put("fsClassname", rq_fsclassname); // 과
        rqMap.put("isHerb", rq_herb); // 허브인지 아닌지
        rqMap.put("isPV", rq_pv); // 공개인지 아닌지

        // 사진 넣기
        Log.d("camera_forest", "bitmaap viewmodel : " + originalBm);

        if (filePath != null) {
            File file = new File(filePath);
            try {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                originalBm.compress(Bitmap.CompressFormat.JPEG, 80, os);
                os.close();

                RequestBody rqFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                mpFile = MultipartBody.Part.createFormData("file", file.getName(), rqFile); // 키값, 파일 이름, 데이터

                Log.d("camera_forest", "mpfile 성공");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            navigator.forToast("사진이 제대로 등록되지 않았습니다.");
            Log.d("camera_forest", "mpfile 실");

            navigator.closeFragment();
            return;
        }

        requestForServer.setOp("InsertPlants"); // 실행할 명령 지정
        requestForServer.setMpFile(mpFile); // 파일 지정
        requestForServer.setRqMap(rqMap); // 보내는 변수들 지정

        Log.d("camera_forest", "변수등록");

        requestForServer.exec_photo(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;

                if(data.getStatus().equals("OK")){ // 보내기 성공
                    navigator.forToast("도감 등록이 완료되었습니다.");
                    Log.d("Test","완료");
                    Log.d("camera_forest", "완ㄹ");
                    navigator.closeFragment();


                }
                else if(data.getStatus().equals("Already Exist")){ // 이미 존재한다면
                    navigator.forToast("등록 실패(error - 중복된 식물명)");
                    Log.d("Test","실패");
                    Log.d("camera_forest", "실패");
                    navigator.closeFragment();

                }
                else{
                    Log.d("camera_forest",data.getStatus());
                    Log.d("camera_forest",data.getException());


                }
            }


            @Override
            public void onFailure(int code) {
                Log.d("camera_forest", "Code:" +code);

                Log.d("Test","Failure");
                navigator.closeFragment();

            }
        });
        Log.d("camera_forest", "프래그먼트 종료");
        navigator.refreshFragment(0);
    }

    public void cancel(){
        Log.d("Test","cancel");
        navigator.closeFragment();
    }

    public void onSplitTypeChanged(RadioGroup radioGroup, int id) {
        Log.d("Test", id+"");
        if(id==1) isHerb=1;
        else isHerb=0;
    }

    public void onSplitTypeChanged2(RadioGroup radioGroup, int id) {
        Log.d("Test", id+"");
        if(id==3) isPV=0;
        else if(id==4) isPV=1;

        Log.d("Test", "공개 비공개: "+isPV);
    }

}