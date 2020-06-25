package com.example.forestapp.ui.hurbSearch;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.CallAnotherActivityNavigator;
import com.example.forestapp.Model.DiseaseJson;
import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.Model.UserJson;
import com.example.forestapp.baseViewModel;
import com.example.forestapp.ui.bookSearch.BkViewModel;

import java.util.ArrayList;
import java.util.List;

public class HurbSearchViewModel extends baseViewModel {
    private CallAnotherActivityNavigator navigator;
    private List<String> diseaseList=new ArrayList<String>();
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
                    diseaseList.add(d.getDname());
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
}