package com.beautifourest.forestapp.ui.herbRecommend;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.DiseaseJsons;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HerbRcViewModel extends baseViewModel {

    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    // 당뇨, 감기에 좋은 약초
    public final ObservableField<String> disease_list = new ObservableField<>();

    //~님에게 약초를 추천드릴게요
    public final ObservableField<String> user_info = new ObservableField<>();

    // 약초 정보들
    public ObservableArrayList<HerbViewModel> herbs = new ObservableArrayList<>();

    // user
    UserJson user;

    GridView gridView;
    HerbAdapter adapter;
    Integer herbid;

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
        this.gridView = gridView;
    }

    public HerbAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(HerbAdapter adapter) {
        this.adapter = adapter;
    }

    public Integer getHerbid() {
        return herbid;
    }

    public void setHerbid(Integer herbid) {
        this.herbid = herbid;
    }

    public CallAnotherActivityNavigator getNavigator() {
        return navigator;
    }

    public void setNavigator(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    private CallAnotherActivityNavigator navigator;

    public HerbRcViewModel(UserJson user) {
        this.user = user;
    }

    public HerbRcViewModel(UserJson user, GridView gridView, HerbAdapter adapter, CallAnotherActivityNavigator navigator){
        this.user=user;
        this.gridView=gridView;
        this.adapter=adapter;
        this.navigator=navigator;
    }

    @Override
    public void onCreate() {
        user_info.set(user.getUname()+"님에게 약초를 추천드릴게요.");
        getHerbs();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                herbid=((HerbViewModel)adapter.getItem(position)).hrbid.get();
                getHerbInfo();
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

    public void getHerbs(){ // 허브리스트를 얻어와서
        // herb에 add한다
        requestForServer.setOp("GetUserHerbs"); // 실행할 명령 지정
        requestForServer.setOb((UserJson)user); // 유저 객체 줌

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                DiseaseJsons data = (DiseaseJsons)receivedData;
                List<DiseaseJson> dj = data.getData();

                //(String img, String name, String data)
                HashSet<String> dnameSet= new HashSet<>();

                for(DiseaseJson d: dj){
                    String dnameli="";

                    dnameSet.add(d.getDname());

                    for(int i=0;i<d.getDnameLi().size();i++){
                        dnameli+=d.getDnameLi().get(i);

                        if(i!=d.getDnameLi().size()-1){
                            dnameli+=", ";
                        }

                    }
                    herbs.add(new HerbViewModel(d.getHrbId(),d.getFsImg1(), d.getHrbName(),dnameli));
                    // 이미지, 약초이름, 도움되는 병들(가려움증, 당뇨, 감기)
                }

                List sortedHerbname = new ArrayList(dnameSet);
                Collections.sort(sortedHerbname);

                String tmp="";
                for(int i=0;i<sortedHerbname.size();i++){
                    tmp+=sortedHerbname.get(i);

                    if(i!=sortedHerbname.size()-1){
                        tmp+=", ";
                    }
                }

                if(tmp.equals("")){
                    tmp = "아직 관심을 가지시는 질병이 없네요. 등록해보시는건 어떨까요? ";
                }
                else tmp+="에 좋은 약초들입니다.";
                disease_list.set(tmp);

            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    private void getHerbInfo(){
        HerbJson hj=new HerbJson();
        hj.setHrbId(herbid);
        requestForServer.setOb((Object)hj);
        requestForServer.setOp("GetHerbID");
        Log.d("Test","Herbid: "+hj.getHrbId());
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                HerbJson data=(HerbJson)receivedData;
                Log.d("Test","herbview: "+data.toString());
                navigator.callFragmentForInfo(0,data);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
}