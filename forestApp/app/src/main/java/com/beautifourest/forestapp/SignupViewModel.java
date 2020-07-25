package com.beautifourest.forestapp;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;

public class SignupViewModel extends baseViewModel{
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;

    /* binding하고 있는 값들 (id, pwd, name, gender, age, 값 입력되었는지) */
    public final ObservableField<String> uid = new ObservableField<>();
    public final ObservableField<String> pwd = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();
    public final ObservableBoolean isValid = new ObservableBoolean();

    /* 기본 함수들 */
    public SignupViewModel(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onCreate() {
        isValid.set(false);

        /* 값들이 모두 입력되었는지 확인하기 위한 리스너 */
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

    /* 입력이 모두 되어야 버튼 활성화 되게 만듦 */
    private void validation() {
        boolean isValidUid = !TextUtils.isEmpty(uid.get());
        boolean isValidGender = !TextUtils.isEmpty(gender.get());
        boolean isValidAge = !TextUtils.isEmpty(age.get());
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidPwd = !TextUtils.isEmpty(pwd.get());
        isValid.set((isValidName && isValidPwd) && (isValidUid && isValidAge && isValidGender));
    }

    /* 회원가입 */
    public void signup() {
        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("Signup");

        UserJson user = new UserJson();
        user.setUid(this.uid.get());
        user.setPw(this.pwd.get());
        user.setAge(Integer.parseInt(this.age.get()));
        user.setGender(this.gender.get());
        user.setUname(this.name.get());

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

                /* 회원가입 성공 */
                if(data.getStatus().equals(("OK"))){
                    navigator.forToast("회원가입에 성공했습니다.");
                    navigator.callActivity(null);
                }
                else{
                    navigator.forToast("회원가입에 실패했습니다. (중복 email)");
                    Log.d("Test","회원가입실패 - 중복된 id");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
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
