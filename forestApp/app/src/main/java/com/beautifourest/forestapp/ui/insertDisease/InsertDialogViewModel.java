package com.beautifourest.forestapp.ui.insertDisease;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.InsertDisease;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.List;

public class InsertDialogViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    public final ObservableField<String> disease = new ObservableField<>();
    UserJson user;
    private List<DiseaseJson> diseaseList; // 전체 정보가 담긴 리스트
    private CallAnotherActivityNavigator navigator; // 화면 전환

    public List<DiseaseJson> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<DiseaseJson> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public InsertDialogViewModel() { }
    public InsertDialogViewModel(UserJson user, List<DiseaseJson> diseaseList, CallAnotherActivityNavigator navigator) {
        this.user = user;
        this.diseaseList = diseaseList;
        this.navigator= navigator;
    }

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
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
//        Log.d("Test","insert");
//        Log.d("Test",user.toString());
//        Log.d("Test", disease.get());
//        Log.d("Test",diseaseList.toString());

        requestForServer.setOp("InsertDisease"); // 실행할 명령 지정

        //InsertDisease) ob
        //        requestForServer.setOb((Object)user); // 보낼 객체 지정
        InsertDisease ob = new InsertDisease();
        ob.setUid(user.getUid());
        List<String> dids = new ArrayList<>();

        for(DiseaseJson d: diseaseList){
            if(d.getDname().equals(disease.get())){
                dids.add(d.getDid()+"");
                break;
            }
        }

        if(dids.size() == 0 ){
            Log.d("Test","no match did");
        }

        else{
            ob.setDid(dids);
        }

        requestForServer.setOb((InsertDisease)ob);
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals(("OK"))){
                    navigator.forToast("관심있는 병명이 등록되었습니다");
                }
                else{
                    navigator.forToast("관심있는 병명 등록이 실패했습니다(이미 등록된 병명)");
                    Log.d("Test","유저 병명 등록 실패");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
        navigator.closeFragment();
    }
    public void cancel(){
        Log.d("Test","cancel");
        navigator.closeFragment();
    }

}