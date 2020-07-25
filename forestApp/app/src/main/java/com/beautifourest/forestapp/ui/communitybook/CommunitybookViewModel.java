package com.beautifourest.forestapp.ui.communitybook;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.MyPlantsInfoJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.MyplantsJsons;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;
import com.beautifourest.forestapp.ui.bookSearch.BkViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 게시판 viewmodel */
public class CommunitybookViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;
    private CommunitybookAdapter adapter;

    /* 이름으로 검색 검색 */
    public final ObservableField<String> search = new ObservableField<>();

    GridView gridView; // 게시판 그리드뷰
    UserJson user; // 로그인 유저 정보
    int plant_bid; // 클릭시 넘겨질 게시글 넘버
    String cur_uid; // 로그인 된 유저 아이디
    int position;

    Context context;
    Activity activity;

    public ObservableArrayList<CbViewModel> myplants = new ObservableArrayList<>();
    public ObservableArrayList<CbViewModel> initplants = new ObservableArrayList<>();

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public CommunitybookViewModel(UserJson user, CallAnotherActivityNavigator navigator, GridView gridview , CommunitybookAdapter adapter) {
        this.navigator = navigator;
        this.user=user;
        this.gridView = gridview;
        this.adapter = adapter;
    }

    @Override
    public void onCreate() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                plant_bid=((CbViewModel)adapter.getItem(position)).did;
                cur_uid = ((CbViewModel)adapter.getItem(position)).userid;
                getInfoByDid(); // 게시글 식물 정보 받아옴
            }
        });

        getInitList();

        /* 검색 시 입력할 때마다 값 바뀜 */
        search.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                changeList();
            }
        });
    }

    @Override
    public void onResume() {
        getInitList();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    /* 검색창에 값이 입력될 때마다 보여지는 식물이 바뀐다 */
    private void changeList() {
        String cmd = this.search.get();
        myplants.clear();

        for (CbViewModel pp : initplants) {
            if (pp.name.get().toLowerCase().contains(cmd.toLowerCase())) { // 이름에 단어가 포함되어 있다면
                myplants.add(pp);
            }
        }
    }

    private void getInitList(){
        myplants.clear();
        initplants.clear();

        requestForServer.setOp("getALLTempPlants"); // 실행할 명령 지정
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                MyplantsJsons da = (MyplantsJsons)receivedData;
                List<MyplantsJson> data = da.getData();
                for(MyplantsJson my : data){
                    Log.d("Test",my.toString());
                    initplants.add(new CbViewModel(my.getFsImg1(),my.getFskName(),my.getIsHerb(),my.getBid(),my.getUid()));
                    myplants.add(new CbViewModel(my.getFsImg1(),my.getFskName(),my.getIsHerb(),my.getBid(),my.getUid()));
                }
            }
            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    private void getInfoByDid(){
        MyplantsJson pj = new MyplantsJson();
        pj.setBid(plant_bid);
        pj.setUid(cur_uid);

        requestForServer.setOb((Object)pj);
        requestForServer.setOp("getInfoByDid"); // 실행할 명령 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                MyPlantsInfoJson data = (MyPlantsInfoJson)receivedData;
                Log.d("Test","booksearchview model: "+ data.getData().toString());
                // 프래그먼트 생성
                navigator.callFragmentForInfo(1, null,  data.getData(),user);
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    public void allDelete(){
//        requestForServer.setOp("deleteAllPlants"); // 실행할 명령 지정
//        requestForServer.setOb((Object)user); // 보낼 객체 지정
//
//        requestForServer.exec(new RetroCallback() { // 통신 시작
//            @Override
//            public void onError(Throwable t) {
//                t.printStackTrace();
//            }
//
//            @Override
//            public void onSuccess(int code, Object receivedData) {
//                PostJsons data = (PostJsons)receivedData;
//                if(data.getStatus().equals("OK")){
//                    Toast.makeText(getContext(),"모두 삭제되었습니다.", Toast.LENGTH_SHORT).show();
//                    Log.d("Test","삭제 성공");
//                }
//                else{
//                    Toast.makeText(getContext(),"삭제 실패", Toast.LENGTH_SHORT).show();
//                    Log.d("Test", data.getStatus());
//                    Log.d("Test","삭제 실패");
//                }
//            }
//
//            @Override
//            public void onFailure(int code) {
//                Log.d("Test","Failure");
//            }
//        });
//        navigator.refreshFragment(0);
    }
}