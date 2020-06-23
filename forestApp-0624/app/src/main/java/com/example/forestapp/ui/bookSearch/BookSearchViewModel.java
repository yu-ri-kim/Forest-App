package com.example.forestapp.ui.bookSearch;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.baseViewModel;

import java.util.List;

public class BookSearchViewModel extends baseViewModel{
    public final ObservableArrayList<BkViewModel> initplants = new ObservableArrayList<>();
    public ObservableArrayList<BkViewModel> plants = new ObservableArrayList<>();

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    //binding하고 있는 값들
    public final ObservableField<String> search = new ObservableField<>();

    @Override
    public void onCreate() {
        getInitList();
        search.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                changeList();
            }
        });

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

    private void changeList() { // 입력될 때마다 값 바
        String cmd = this.search.get();
        plants.clear();
        Log.d("Test","changeList");

        for(BkViewModel pp : initplants){
            if(pp.name.get().contains(cmd)){ // 이름에 단어가 포함되어 있다면
                Log.d("Test",pp.name.get());
                plants.add(new BkViewModel(pp.name.get(),pp.data.get()));
            }
//            else{
//                Log.d("Test",pp.name.get());
//            }
        }
    }

    private void getInitList(){
        requestForServer.setOp("AllPlant"); // 실행할 명령 지정
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data = (List<PlantJson>)receivedData;
                Log.d("Test",data.get(0).toString());

                for(PlantJson d: data){ // 모든 도감 데이터 집어 넣음
                    String info="이름: "+d.getFskName();
                    initplants.add(new BkViewModel(d.getFskName(),info));
                    plants.add(new BkViewModel(d.getFskName(),info));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

}
