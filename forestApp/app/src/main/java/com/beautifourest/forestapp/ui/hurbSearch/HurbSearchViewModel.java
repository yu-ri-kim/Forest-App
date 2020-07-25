package com.beautifourest.forestapp.ui.hurbSearch;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HurbSearchViewModel extends baseViewModel {
    private CallAnotherActivityNavigator navigator;
    private List<DiseaseJson> diseaseList=new ArrayList<DiseaseJson>();
    UserJson user;
    public final ObservableField<String> tmp = new ObservableField<>();

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체


    public HurbSearchViewModel(){}
    public HurbSearchViewModel(UserJson user, CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
        this.user=user;
    }


    @Override
    public void onCreate() {
        Log.d("Test","viewmodel: "+ user.toString());
        tmp.set(user.toString());
        getDiseaseName();
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

    public void getDiseaseName(){
        requestForServer.setOp("GetDiseaseName"); // 실행할 명령 지정
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<DiseaseJson> data = (List<DiseaseJson>)receivedData;

                for(DiseaseJson d: data){ // 모든 도감 데이터 집어 넣음
                    DiseaseJson tmp = new DiseaseJson();

                    tmp.setDname(d.getDname());
                    tmp.setDid(d.getDid());

                    diseaseList.add(tmp);
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }
    public void photo(){
        //int num=0;
        //navigator.callFragment(user,num);
    }

    public void nextDialog() {
        Log.d("Test","next diaglog");
        navigator.callFragment(user,0, diseaseList);
    }

    public void nextFragment1() {
        Log.d("Test","nextFragment1");
        navigator.callFragment(user,1, diseaseList);
    }

    public void nextFragment2() {
        Log.d("Test","nextFragment2");
        navigator.callFragment(user,2, null);
    }

    public void nextFragment3() {
        Log.d("Test","nextFragment2");
        navigator.callFragment(user,4, null);
    }

    public void nextFragment4() {   //병명 취소
        Log.d("Test","nextFragment5");
        navigator.callFragment(user,5, diseaseList);
    }
}