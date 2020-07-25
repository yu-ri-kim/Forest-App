package com.beautifourest.forestapp.ui.updatePlants;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.MyplantsJson;
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

public class UpdatePlantsDialogViewModel extends baseViewModel {

    // 사진 + 정보 보내기
    private MultipartBody.Part mpFile=null;
    private Map<String, RequestBody> rqMap;
    Bitmap originalBm;
    String filePath;

    //binding하고 있는 값들
    public final ObservableField<String> fskname = new ObservableField<>();
    public final ObservableField<String> fsename = new ObservableField<>();
    public final ObservableField<String> fslifetime = new ObservableField<>();
    public final ObservableField<String> fsgbn = new ObservableField<>();
    public final ObservableField<String> fsclassname = new ObservableField<>();
    public final ObservableField<String> isHerb=new ObservableField<>();
    int newIsHerb;

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    UserJson user; // 유저
    MyplantsJson myplant;

    int checkUpdatePhoto = 0;
    private CallAnotherActivityNavigator navigator; // 화면 전환

    public UpdatePlantsDialogViewModel() { }
    public UpdatePlantsDialogViewModel(UserJson user, CallAnotherActivityNavigator navigator, MyplantsJson myplants) {
        this.user = user;
        this.navigator= navigator;
        this.myplant = myplants;

        this.fskname.set(myplant.getFskName());
        this.fsename.set(myplant.getFseName());
        this.fslifetime.set(myplant.getFsLifeTime());
        this.fsgbn.set(myplant.getFsGbn());
        this.fsclassname.set(myplant.getFsClassname());

        if(myplant.getIsHerb()==0){
            this.isHerb.set("일반 식물");
            newIsHerb = 0;
        }
        else{
            this.isHerb.set("약용 식물");
            newIsHerb = 1;
        }
    }

    public int isCheckUpdatePhoto() {
        return checkUpdatePhoto;
    }

    public void setCheckUpdatePhoto(int checkUpdatePhoto) {
        this.checkUpdatePhoto = checkUpdatePhoto;
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

        if(fskname.equals("")){ // 이름, 허브 선택, 사진 등록이 안되었다면 토스트
            navigator.forToast("필수 입력 값이 입력되지 않았습니다.");
            Log.d("Test","필수 입력 값 안됨");
            return;
        }

        Log.d("camera_forest","fskname:"+fskname);
        rqMap = new HashMap<>();
        RequestBody rq_bid = RequestBody.create(MediaType.parse("text/plain"), myplant.getBid()+"");
        RequestBody rq_uid = RequestBody.create(MediaType.parse("text/plain"), user.getUid());
        RequestBody rq_fskname = RequestBody.create(MediaType.parse("text/plain"), fskname.get()+"");
        RequestBody rq_fsename = RequestBody.create(MediaType.parse("text/plain"), fsename.get()+"");
        RequestBody rq_fslifetime = RequestBody.create(MediaType.parse("text/plain"), fslifetime.get()+"");
        RequestBody rq_fsgbn = RequestBody.create(MediaType.parse("text/plain"), fsgbn.get()+"");
        RequestBody rq_fsclassname = RequestBody.create(MediaType.parse("text/plain"), fsclassname.get()+"");
        RequestBody rq_herb = RequestBody.create(MediaType.parse("text/plain"),newIsHerb+"");
        RequestBody rq_changedpic = RequestBody.create(MediaType.parse("text/plain"),checkUpdatePhoto+"");

        Log.d("camera_forest", rq_uid.toString());
        Log.d("camera_forest", rq_fskname.toString());

        rqMap.put("bid", rq_bid); // 변경할 마이 식물
        rqMap.put("uid", rq_uid); // 유저 아이디
        rqMap.put("fskName", rq_fskname); // 이름
        rqMap.put("fseName", rq_fsename); // 영어이름
        rqMap.put("fsLifeTime", rq_fslifetime); // 식물이야기
        rqMap.put("fsGbn", rq_fsgbn); // 류
        rqMap.put("fsClassname", rq_fsclassname); // 과
        rqMap.put("isHerb", rq_herb); // 허브인지 아닌지
        rqMap.put("changedpic", rq_changedpic); // 사진이 바뀌었는지 아닌

        // 사진 넣기
        Log.d("camera_forest", "bitmaap viewmodel : " + originalBm);

        if (filePath != null) {
            File file = new File(filePath);
            try {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                originalBm.compress(Bitmap.CompressFormat.JPEG, 100, os);
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

        requestForServer.setOp("updatePlants"); // 실행할 명령 지정
        requestForServer.setMpFile(mpFile); // 파일 지정
        requestForServer.setRqMap(rqMap); // 보내는 변수들 지정

        Log.d("camera_forest","업데이트!!! "+rqMap.toString());
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
                    navigator.forToast("도감 수정이 완료되었습니다.");
                    Log.d("Test","완료");
                    Log.d("camera_forest", "완ㄹ");
                    navigator.closeFragment();
                }
                else if(data.getStatus().equals("Already Exist")){ // 이미 존재한다면
                    navigator.forToast("수정 실");
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
    }

    public void cancel(){
        Log.d("Test","cancel");
        navigator.closeFragment();
    }

    public void onSplitTypeChanged(RadioGroup radioGroup, int id) {
        Log.d("Test", id+"");
        if(id==1) newIsHerb=1;
        else newIsHerb=0;
    }

}