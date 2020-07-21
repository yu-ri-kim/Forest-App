package com.beautifourest.forestapp.ui.mybook;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.MyPlantsInfoJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.MyplantsJsons;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MybookViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    private CallAnotherActivityNavigator navigator;
    MybookAdapter adapter;

    GridView gridView;
    UserJson user;
    int plant_bid;

    Context context;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    Activity activity;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    int position;

    public List<MbViewModel> init_time_myplants = new ArrayList<>();
    public ObservableArrayList<MbViewModel> init_name_myplants = new ObservableArrayList<>();
    public ObservableArrayList<MbViewModel> myplants = new ObservableArrayList<>();

    public MybookViewModel(UserJson user, CallAnotherActivityNavigator navigator, GridView gridview , MybookAdapter adapter) {
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
                plant_bid=((MbViewModel)adapter.getItem(position)).did;
                getInfoByDid(); // 내식물 정보 받아옴
            }
        });
        getInitList();
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

    private void getInitList(){
        init_name_myplants.clear();
        myplants.clear();

        requestForServer.setOp("getAllPlants"); // 실행할 명령 지정
        requestForServer.setOb((Object)user);
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
                    // Log.d("Test",my.getFsImg1());
                    init_name_myplants.add(new MbViewModel(my.getFsImg1(),my.getFskName(),my.getIsHerb(), my.getBid()));
                    init_time_myplants.add(new MbViewModel(my.getFsImg1(),my.getFskName(),my.getIsHerb(), my.getBid()));
                    myplants.add(new MbViewModel(my.getFsImg1(),my.getFskName(),my.getIsHerb(),my.getBid()));
                }

                Collections.sort(init_name_myplants); // 이름순 정렬
            }
            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    public void SpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //  스피너의 선택 내용이 바뀌면 호출된다
        Log.d("Test","position:"+position);
        this.position=position;
        if(position==0) {
            myplants.clear();
            for(MbViewModel m : init_time_myplants){
                myplants.add(m);
            }
        }
        if(position==1) {
            myplants.clear();
            for(MbViewModel m : init_name_myplants){
                myplants.add(m);
            }
        }
    }

    public void nextDialog() {
        Log.d("Test","next plant insert diaglog");
        navigator.callFragment(user,3, null);
    }

    public void allDelete(){
        requestForServer.setOp("deleteAllPlants"); // 실행할 명령 지정
        requestForServer.setOb((Object)user); // 보낼 객체 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals("OK")){
                    Toast.makeText(getContext(),"모두 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("Test","삭제 성공");
                }
                else{
                    Toast.makeText(getContext(),"삭제 실패", Toast.LENGTH_SHORT).show();
                    Log.d("Test", data.getStatus());
                    Log.d("Test","삭제 실패");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
        navigator.refreshFragment(0);
    }


    private void getInfoByDid(){
        MyplantsJson pj = new MyplantsJson();
        pj.setBid(plant_bid);
        pj.setUid(user.getUid());

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
                navigator.callFragmentForInfo(1, null,  data.getData(), user);
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }
}