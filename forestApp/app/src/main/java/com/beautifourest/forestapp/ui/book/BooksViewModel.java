package com.beautifourest.forestapp.ui.book;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.baseViewModel;

import java.util.List;

public class BooksViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;

    /* binding 하는 값들 */
    public final ObservableArrayList<BookViewModel> initplants = new ObservableArrayList<>();
    public final ObservableArrayList<BookViewModel> initherbs=new ObservableArrayList<>();
    public ObservableArrayList<BookViewModel> plants = new ObservableArrayList<>();

    View view;
    GridView gridView;
    BookAdapter adapter;
    String plantname;
    Integer herbid;

    public BooksViewModel(){}
    public BooksViewModel(GridView gridView, BookAdapter adapter, CallAnotherActivityNavigator navigator){
        this.gridView=gridView;
        this.adapter=adapter;
        this.navigator=navigator;
    }

    /*
        0 : 전체도감
        1 : 허브도감
    */
    private int position;
    private int check;

    @Override
    public void onCreate() {
        /* gridview 클릭 이벤트 리스너 */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                plantname=((BookViewModel)adapter.getItem(position)).name.get();
                herbid=((BookViewModel)adapter.getItem(position)).hrbid.get();

                if(check==1){
                    getInfoByName();    //식물 정보 받아옴
                }
                else if(check==2){
                    getHerbInfo();      //허브 정보 받아옴
                }
            }
        });

        getInitList1();
        getInitList2();
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

    /* 스피너의 선택 내용이 바뀌면 호출된다 */
    public void SpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position=position;
        if(position==0) {
            check=1;
            plants.clear();
            for(BookViewModel m : initplants){
                plants.add(m);
            }
        }
        if(position==1) {
            check=2;
            plants.clear();
            for(BookViewModel m : initherbs){
                plants.add(m);
            }
        }
    }

    /* 전체도감 받아오는 함수 */
    private void getInitList1(){
        if(initplants.size()!=0) return;

        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("AllPlant");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) { t.printStackTrace(); }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data=(List<PlantJson>)receivedData;

                /* 모든 도감 데이터 넣기 */
                for(PlantJson d:data){
                    String img=d.getFsImg1();
                    String name=d.getFskName();

                    initplants.add(new BookViewModel(null,img,name));
                    plants.add(new BookViewModel(null,img,name));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    /* 허브도감 받아오는 함수 */
    private void getInitList2(){
        if(initherbs.size()!=0) return;

        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("AllHerb");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<HerbJson> data=(List<HerbJson>)receivedData;

                /* 모든 도감 데이터 넣기 */
                for(HerbJson d:data){
                    Integer hrbId=d.getHrbId();
                    String img=d.getFsImg1();
                    String name=d.getHrbName();

                    initherbs.add(new BookViewModel(hrbId,img,name));
                    plants.add(new BookViewModel(hrbId,img,name));

                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    /* 식물 이름으로 전체 정보 얻어오기 */
    private void getInfoByName() {
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        PlantJson pj=new PlantJson();
        pj.setFskName(plantname);
        requestForServer.setOb((Object)pj);
        requestForServer.setOp("getInfoByname");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<PlantJson> data=(List<PlantJson>)receivedData;
                navigator.callFragmentForInfo(0,data.get(0),null);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }

    /* 허브 id로 전체 정보 얻어오기 */
    private void getHerbInfo(){
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        HerbJson hj=new HerbJson();
        hj.setHrbId(herbid);
        requestForServer.setOb((Object)hj);
        requestForServer.setOp("GetHerbID");

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                HerbJson data=(HerbJson)receivedData;
                navigator.callFragmentForInfo(0,data);
            }

            @Override
            public void onFailure(int code) {

            }
        });

    }

}
