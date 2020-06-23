package com.example.forestapp.ui.book;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.PostJsons;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;

import java.util.List;

public class BookViewModel extends ViewModel {
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    private MutableLiveData<String> mText;

    public BookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is book fragment");
        getAllPlants();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void getAllPlants() { // 전체 식물 정보 가져오기
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
                mText.setValue(data.get(0).toString());
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }
}