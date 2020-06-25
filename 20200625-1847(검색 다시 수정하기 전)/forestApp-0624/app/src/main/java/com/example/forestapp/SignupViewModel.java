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

public class SignupViewModel extends baseViewModel{
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체

    //binding하는 값들
    public final ObservableField<String> uid = new ObservableField<>();
    public final ObservableField<String> pwd = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();

    public final ObservableBoolean isValid = new ObservableBoolean();
    private CallAnotherActivityNavigator navigator; // 화면 전환

    public SignupViewModel(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
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
        uid.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
            }
        });
        gender.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                validation();
            }
        });
        age.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
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

    private void validation() { // 입력이 모두 되어야 버튼 활성화 되게 만듦. 우선 3개만 함. 나중에 고쳐야함
        boolean isValidUid = !TextUtils.isEmpty(uid.get());
        boolean isValidGender = !TextUtils.isEmpty(gender.get());
        boolean isValidAge = !TextUtils.isEmpty(age.get());
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidPwd = !TextUtils.isEmpty(pwd.get());
        isValid.set((isValidName && isValidPwd) && (isValidUid));
    }

    public void signup() { // 회원가입
        requestForServer.setOp("Signup"); // 실행할 명령어

        UserJson user = new UserJson();
        user.setUid(this.uid.get());
        user.setPw(this.pwd.get());
        user.setAge(Integer.parseInt(this.age.get()));
        user.setGender(this.gender.get());
        user.setUname(this.name.get());

        requestForServer.setOb((Object)user); // 보낼 객체

        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals(("OK"))){ // 회원가입 성공
                    navigator.callActivity(null);
                }
                else{
                    Log.d("Test","회원가입실패- 중복된 id");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

}
