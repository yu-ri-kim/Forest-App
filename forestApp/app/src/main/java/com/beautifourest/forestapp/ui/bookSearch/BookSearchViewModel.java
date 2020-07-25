package com.beautifourest.forestapp.ui.bookSearch;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.baseViewModel;

import java.util.List;

/* 도감 검색 viewmodel */
public class BookSearchViewModel extends baseViewModel{
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;

    public final ObservableArrayList<BkViewModel> initplants = new ObservableArrayList<>();
    public final ObservableArrayList<BkViewModel> initdisease = new ObservableArrayList<>();
    public ObservableArrayList<BkViewModel> plants = new ObservableArrayList<>();

    View view;
    ListView listView;
    BookSearchAdapter adapter;
    String plantname;

    public BookSearchViewModel() {}
    public BookSearchViewModel(ListView listView, BookSearchAdapter adapter,CallAnotherActivityNavigator navigator) {
        this.listView = listView;
        this.adapter = adapter;
        this.navigator = navigator;
    }

    /* 검색 창 값 binding */
    public final ObservableField<String> search = new ObservableField<>();

    /* 스피너 값 binding */
    private int position;

    /* listview를 클릭하면 해당 식물의 상세 정보를 받아온다 */
    @Override
    public void onCreate() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                plantname = ((BkViewModel)adapter.getItem(position)).name.get();
                getInfoByName();
            }
        });
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

    /*  스피너의 선택 내용이 바뀌면 호출된다 */
    /*
        0 : 이름 검색
        1 : 병명 검색
     */
    public void SpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position=position;

        if(position==0) {
            getInitList();
        }
        if(position==1) {
            getInitList_Disease();
        }
    }

    /* 검색창에 값이 입력될 때마다 보여지는 식물이 바뀐다 */
    private void changeList() {
        if(position==0) {
            String cmd = this.search.get();
            plants.clear();

            for (BkViewModel pp : initplants) {
                if (pp.name.get().toLowerCase().contains(cmd.toLowerCase())) { // 이름에 단어가 포함되어 있다면
                    plants.add(new BkViewModel(pp.img.get(), pp.name.get(), pp.data.get()));
                }
            }
        }
        else{
            String cmd = this.search.get();
            plants.clear();

            for (BkViewModel pp : initdisease) {
                if (pp.data.get().toLowerCase().contains(cmd.toLowerCase())) { // 이름에 단어가 포함되어 있다면
                    plants.add(new BkViewModel(pp.img.get(), pp.name.get(), pp.data.get()));
                }
            }
        }
    }

    private void getInitList(){
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("AllPlantInfo");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data = (List<PlantJson>)receivedData;
                plants.clear();
                initplants.clear();

                /* 모든 도감 데이터를 add 한다 */
                for(PlantJson d: data){
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
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("GetDisesaseInfo");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<DiseaseJson> data = (List<DiseaseJson>)receivedData;
                plants.clear();
                initdisease.clear();

                /* 모든 도감 데이터를 add 한다 */
                for(DiseaseJson d: data){
                    String img=d.getFsImg1();
                    String info=d.getDname();
                    initdisease.add(new BkViewModel(img, d.getHrbName(),info));
                    plants.add(new BkViewModel(img, d.getHrbName(),info));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    /* 이름으로 식물정보 검색하기 */
    private void getInfoByName(){
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        PlantJson pj = new PlantJson();
        pj.setFskName(plantname);
        requestForServer.setOb((Object)pj);
        requestForServer.setOp("getInfoByname");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data = (List<PlantJson>)receivedData;

                /* 상세정보 페이지로 넘어감 */
                navigator.callFragmentForInfo(0, data.get(0), null, null);
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }
}
