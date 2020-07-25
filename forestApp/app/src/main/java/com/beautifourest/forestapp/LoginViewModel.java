package com.beautifourest.forestapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.Model.UserJsons;

/* 로그인 뷰모델 */
public class LoginViewModel extends baseViewModel{
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;

    /* 자동 로그인을 위한 변수들 */
    private boolean saveLoginData;
    private SharedPreferences appData;
    private String tmpid;
    private String tmppwd;
    private Context context;

    /* binding하고 있는 값들 (id, pwd, 값 입력되었는지, 자동로그인 유무) */
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> pwd = new ObservableField<>();
    public final ObservableBoolean isValid = new ObservableBoolean();
    public final ObservableBoolean checkedValue = new ObservableBoolean();

    /* 로그인 성공시 객체 정보를 얻어오기 위함 */
    private boolean LoginStatus;
    private UserJson user=new UserJson();

    /* 기본 함수들 */
    public LoginViewModel() {}

    public LoginViewModel(CallAnotherActivityNavigator navigator, Context context) {
        this.navigator = navigator;
        this.context = context;
    }

    public Context getContext() { return context; }

    public void setContext(Context context) { this.context = context; }

    public void setLoginStatus(boolean loginStatus) { LoginStatus = loginStatus; }

    public boolean getLoginStatus() { return LoginStatus; }

    public void setUser(UserJson user) { this.user = user; }

    @Override
    public void onCreate() {
        isValid.set(false);

        /* 자동 로그인(저장된 값 확인, 자동로그인 상태면 값 불러와서 바꿈) */
        appData = context.getSharedPreferences("appData", context.MODE_PRIVATE);
        load();

        if(saveLoginData){
            this.name.set(tmpid);
            this.pwd.set(tmppwd);
            this.checkedValue.set(saveLoginData);
        }

        /* 자동로그인에 체크되어 있다면 지금 값을 저장 */
        if(this.checkedValue.get()){
            save();
        }

        /* email, pwd가 모두 입력되었는지 확인하기 위한 리스너 */
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

    private void load(){
        saveLoginData = appData.getBoolean("SAVE_LOGIN_DATA",false);
        tmpid = appData.getString("ID","");
        tmppwd = appData.getString("PWD","");
    }

    private void save(){
        SharedPreferences.Editor editor = appData.edit();

        /* 자동로그인 상태인지 아닌지 저장하는 변수 */
        editor.putBoolean("SAVE_LOGIN_DATA", this.checkedValue.get());

        editor.putString("ID", this.name.get());
        editor.putString("PWD",this.pwd.get());

        /* apply 하지 않으면 값이 저장되지 않는다 */
        editor.apply();
    }

    /* 입력이 모두 되어야 버튼 활성화 되게 만듦 */
    private void validation() {
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidPwd = !TextUtils.isEmpty(pwd.get());
        isValid.set(isValidName && isValidPwd);
    }

    /* 로그인 */
    public void login() {
        save();

        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("Login");
        user.setUid(this.name.get());
        user.setPw(this.pwd.get());
        requestForServer.setOb((Object)user);

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;

                /* 로그인 성공 */
                if(data.getData().equals(("1"))){
                    setLoginStatus(true);
                    getUserInfo();
                }
                /* 로그인 실패 */
                else{
                    navigator.forToast("로그인에 실패했습니다.");
                    Log.d("Test","로그인 실패");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    /* 로그인 된 유저의 정보 가져오기 */
    public void getUserInfo(){
        if(LoginStatus){
            /* 실행할 명령어와 서버로 보낼 객체 설정 */
            requestForServer.setOp("GetUserInfo");
            requestForServer.setOb((Object)user);

            /* 서버랑 통신 시작 */
            requestForServer.exec(new RetroCallback() {
                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onSuccess(int code, Object receivedData) {
                    UserJsons data = (UserJsons)receivedData;
                    setUser(data.getData().get(0));

                    /* 뷰에 현재 엑티비티를 메인 액티비티로 변경할 것을 요청 */
                    navigator.callActivity(user);
                }

                @Override
                public void onFailure(int code) {
                    Log.d("Test", "객체 정보 얻어오기 실패 , code: " +Integer.toString(code));
                }
            });
        }
        else{
            Log.d("Test","로그인 실패 상태 - 객체 정보 못 얻어옴");
        }
    }

    /* 구현안한 함수들 */
    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
