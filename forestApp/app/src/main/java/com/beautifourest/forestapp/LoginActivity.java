package com.beautifourest.forestapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.databinding.ActivityLoginBinding;

import java.util.List;

/* 로그인 액티비티 */
public class LoginActivity extends AppCompatActivity implements CallAnotherActivityNavigator{
    private LoginViewModel model;

    /* 로그인 뷰 모델 생성 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar abar = getSupportActionBar();
        abar.hide();

        model = new LoginViewModel(this, getApplicationContext());
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setModel(model);
        model.onCreate();
    }

    /* 회원가입 버튼 -> 회원가입 액티비티 */
    public void SignupClicked(View view) {
        finish();
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class) ;
        startActivity(intent) ;
    }

    /* 로그인 성공 시 실행되는 함수 -> main activity로 넘어감(로그인 한 유저정보와 함께) */
    @Override
    public void callActivity(UserJson user) {
        Intent intent = new Intent(getApplicationContext(), BookMainActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    @Override
    public void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList) { }

    @Override
    public void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2) {

    }

    @Override
    public void callFragmentForInfo(int num, HerbJson herb_info) {

    }

    @Override
    public void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user) {

    }


    @Override
    public void closeFragment() { }

    /* 뷰모델에서 토스트 메세지를 띄우기 위해 사용  */
    @Override
    public void forToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshFragment(int num) {

    }

    @Override
    public void callImageActivity(List<String> imgs, String name) {

    }
}