package com.beautifourest.forestapp.ui.deleteDisease;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.DiseaseJsons;
import com.beautifourest.forestapp.Model.InsertDisease;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DeleteDiseaseViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    public ObservableArrayList<DiseaseViewModel> diseases=new ObservableArrayList<>(); //질병 이름

    private CallAnotherActivityNavigator navigator; // 화면 전환



    // user
    UserJson user;
    DeleteDiseaseAdapter adapter;
    ListView listView;

    DiseaseJson diseaseJson;
    String uid;
    String userid;

    String dname;
    String disease_name;

    private List<DiseaseJson> diseaseList=new ArrayList<DiseaseJson>();

    public DeleteDiseaseViewModel(UserJson user, ListView listView, DeleteDiseaseAdapter adapter, CallAnotherActivityNavigator navigator){
        this.user=user;
        this.listView=listView;
        this.adapter=adapter;
        this.navigator=navigator;
    }

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    public ListView getListView(){
        return listView;
    }

    public void setListView(ListView listView){
        this.listView=listView;
    }

    public DeleteDiseaseAdapter getAdapter(){
        return adapter;
    }

    public void setAdapter(DeleteDiseaseAdapter adapter){
        this.adapter=adapter;
    }

    public String getDname(){
        return dname;
    }

    public void setDname(String dname){
        this.dname=dname;
    }

    public CallAnotherActivityNavigator getNavigator(){
        return navigator;
    }

    public void setNavigator(CallAnotherActivityNavigator navigator){
        this.navigator=navigator;
    }


    @Override
    public void onCreate() {
        getDisease();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dname=((DiseaseViewModel)adapter.getItem(position)).dname.get();
                delete();
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

    public void getDisease(){ // 관심있는 질병 리스트를 얻어와서
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

                HashSet<String> dnameSet=new HashSet<>();
                for(DiseaseJson d:dj){
                    DiseaseJson tmp = new DiseaseJson();
                    dnameSet.add(d.getDname());

                }
                List disease_list=new ArrayList(dnameSet);
                Collections.sort(disease_list);

                if(disease_list.size()==0){
                    navigator.forToast("등록된 관심질병이 없습니다.");
                }
                for(int i=0;i<disease_list.size();i++){
                    disease_name=disease_list.get(i).toString();
                    //Log.d("Test id",uid);
                    Log.d("Test name",disease_name);
                    diseases.add(new DiseaseViewModel(uid,disease_name));

                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    public void delete(){   //삭제
        requestForServer.setOp("DeleteDisease"); // 실행할 명령 지정
        //DeleteDisease ob=new DeleteDisease();
        InsertDisease ob=new InsertDisease();
        ob.setUid(user.getUid());
        ob.setDname(dname);
        Log.d("Test",ob.getUid());
        Log.d("Test",ob.getDname());

        requestForServer.setOb((InsertDisease)ob);
        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals(("OK"))){
                    Log.d("Test","Success");
                    navigator.forToast(dname+" 이(가) 삭제되었습니다.\n 이전 페이지로 돌아가세요");

                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
        navigator.closeFragment();
    }
    public void cancel(){
        Log.d("Test","cancel");
        navigator.closeFragment();
    }

}
