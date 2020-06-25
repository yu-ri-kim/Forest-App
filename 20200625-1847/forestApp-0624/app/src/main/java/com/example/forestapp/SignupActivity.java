package com.example.forestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.forestapp.Model.UserJson;
import com.example.forestapp.databinding.ActivityLoginBinding;
import com.example.forestapp.databinding.ActivitySignupBinding;

import java.util.List;

public class SignupActivity extends AppCompatActivity implements CallAnotherActivityNavigator{ //회원가입 액티비티
    private SignupViewModel model = new SignupViewModel(this); // 회원가입 뷰 모델

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        binding.setModel(model);
        model.onCreate();
    }

    @Override
    public void callActivity(UserJson user) { // 화면 전환. 회원가입 성공시 로그인 화면으로 전환
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    @Override
    public void callFragment(UserJson user, int num, List<String> diseaseList) {

    }
}
