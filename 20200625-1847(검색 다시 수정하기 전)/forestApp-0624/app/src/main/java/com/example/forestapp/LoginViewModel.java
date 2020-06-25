package com.example.forestapp;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.example.forestapp.Model.PostJsons;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.Model.UserJson;
import com.example.forestapp.Model.UserJsons;

public class LoginViewModel extends baseViewModel{ // 로그인 뷰모델
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    //binding하고 있는 값들
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> pwd = new ObservableField<>();
    public final ObservableBoolean isValid = new ObservableBoolean();
    public final ObservableField<String> userinfo = new ObservableField<>();

    private CallAnotherActivityNavigator navigator; // 화면전환을 위한 객체

    private boolean LoginStatus;
    private UserJson user=new UserJson();

    public boolean getLoginStatus() {
        return LoginStatus;
    }

    public LoginViewModel() {}
    public LoginViewModel(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        isValid.set(false);
        name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
            }
        });
        pwd.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
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

    private void validation() { // 입력이 모두 되어야 버튼 활성화 되게 만듦
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidPwd = !TextUtils.isEmpty(pwd.get());
        isValid.set(isValidName && isValidPwd);
    }

    public void login() { // 로그인버튼이 눌렸을 때 동작하는 함수
        requestForServer.setOp("Login"); // 실행할 명령 지정

        user.setUid(this.name.get());
        user.setPw(this.pwd.get());

        requestForServer.setOb((Object)user); // 보낼 객체 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getData().equals(("1"))){ // 로그인 성공
                    setLoginStatus(true);
                    Log.d("Test", String.valueOf(getLoginStatus()));
                    getUserInfo();
                }
                else{
                    Log.d("Test","로그인실패");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    public void getUserInfo(){ // 로그인 성공하면 유저의 정보 가져와서 저장
        if(LoginStatus){
            requestForServer.setOp("GetUserInfo"); // 실행할 명령 지정

            Log.d("Test",user.getUid());

            requestForServer.setOb((Object)user); // 보낼 객체 지정

            requestForServer.exec(new RetroCallback() { // 통신 시작
                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onSuccess(int code, Object receivedData) {
                    UserJsons data = (UserJsons)receivedData;
                    setUser(data.getData().get(0));
                    userinfo.set(data.getData().get(0).toString());
                    navigator.callActivity(user);
                }

                @Override
                public void onFailure(int code) {
                    Log.d("Test",Integer.toString(code));
                }
            });
        }
        else{
            Log.d("Test","fail login");
        }
    }

}
