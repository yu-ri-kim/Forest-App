package com.example.forestapp.ui.book;

import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.baseViewModel;

import java.util.List;

public class BooksViewModel extends baseViewModel {
    public final ObservableArrayList<BookViewModel> initplants = new ObservableArrayList<>();
    public ObservableArrayList<BookViewModel> plants = new ObservableArrayList<>();

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    //binding하고 있는 값들
    public final ObservableField<String> books = new ObservableField<>();

    @Override
    public void onCreate() {
        getInitList();
        books.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
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

    private void changeList(){

    }
    private void getInitList(){
        requestForServer.setOp("AllPlant"); //실행할 명령 지정
        requestForServer.exec(new RetroCallback() { //통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data=(List<PlantJson>)receivedData;
                Log.d("TestBook",data.get(0).toString());

                for(PlantJson d:data){  //모든 도감 데이터 넣기
                    String img=d.getFsImg1();
                    String name=d.getFskName();

                    initplants.add(new BookViewModel(img,name));
                    plants.add(new BookViewModel(img,name));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("TestBook","Failure");
            }
        });
    }



}
