package com.example.forestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.forestapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements CallAnotherActivityNavigator{ // 로그인 액티비티
    private LoginViewModel model = new LoginViewModel(this); // 로그인 뷰모델

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setModel(model);
        model.onCreate();
    }

    public void SignupClicked(View view) { // 회원가입 버튼클릭시 회원가입창으로 이동
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class) ;
        startActivity(intent) ;
    }

    @Override
    public void callActivity() { // 로그인 성공 시 이동할 창. 임시로 serverActivity 넣어놓음
        startActivity(new Intent(getApplicationContext(), ServerActivity.class));
    }
}