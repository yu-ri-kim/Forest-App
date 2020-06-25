package com.example.forestapp.ui.bookSearch;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.Model.DiseaseJson;
import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.baseViewModel;
import com.example.forestapp.ui.book.BookViewModel;

import java.util.List;

public class BookSearchViewModel extends baseViewModel{
    public final ObservableArrayList<BkViewModel> initplants = new ObservableArrayList<>();
    public final ObservableArrayList<BkViewModel> initdisease = new ObservableArrayList<>();

    public ObservableArrayList<BkViewModel> plants = new ObservableArrayList<>();
    public final ObservableField<Integer> selectedItemPosition = new ObservableField<>();

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    //binding하고 있는 값들
    public final ObservableField<String> search = new ObservableField<>();

    // 어떤 메뉴를 골랐는지
    private int position;

    @Override
    public void onCreate() {
        getInitList();
        getInitList_Disease();
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

    public void SpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //  스피너의 선택 내용이 바뀌면 호출된다
        Log.d("Test","position:"+position);
        this.position=position;
        if(position==0) {
            plants.clear();
            for(BkViewModel m : initplants){
                plants.add(m);
            }
        }
        if(position==1) {
            plants.clear();
            for(BkViewModel m : initdisease){
                plants.add(m);
            }
        }
    }

    private void changeList() { // 입력될 때마다 값 바
        if(position==0) {
            String cmd = this.search.get();
            plants.clear();

            for (BkViewModel pp : initplants) {
                if (pp.name.get().contains(cmd)) { // 이름에 단어가 포함되어 있다면
                    plants.add(new BkViewModel(pp.img.get(), pp.name.get(), pp.data.get()));
                }
            }
        }
        else{
            String cmd = this.search.get();
            plants.clear();

            for (BkViewModel pp : initdisease) {
                if (pp.data.get().contains(cmd)) { // 이름에 단어가 포함되어 있다면
                    plants.add(new BkViewModel(pp.img.get(), pp.name.get(), pp.data.get()));
                }
            }
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
                    String img=d.getFsImg1();
                    String info=d.getFseName()+"\n"+d.getFsGbn()+" "+d.getFsClassname();
                    initplants.add(new BkViewModel(img, d.getFskName(),info));
                    plants.add(new BkViewModel(img, d.getFskName(),info));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    private void getInitList_Disease(){
        requestForServer.setOp("GetDisesaseInfo"); // 실행할 명령 지정
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<DiseaseJson> data = (List<DiseaseJson>)receivedData;
                for(DiseaseJson d: data){ // 모든 도감 데이터 집어 넣음
                    String img=d.getFsImg1();
                    String info=d.getDname();
                    initdisease.add(new BkViewModel(img, d.getHrbName(),info));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

}
