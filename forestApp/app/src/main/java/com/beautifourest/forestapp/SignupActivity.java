package com.beautifourest.forestapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.databinding.ActivityLoginBinding;
import com.beautifourest.forestapp.databinding.ActivitySignupBinding;

import java.util.List;

/* 회원가입 액티비티 */
public class SignupActivity extends AppCompatActivity implements CallAnotherActivityNavigator{
    private SignupViewModel model = new SignupViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar abar = getSupportActionBar();
        abar.hide();
        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        binding.setModel(model);
        model.onCreate();
    }

    /* 회원가입 성공시 로그인 화면으로 전환 */
    @Override
    public void callActivity(UserJson user) {
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    /* 구현안한 함수들 */
    @Override
    public void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList) { }

    @Override
    public void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2, UserJson user) {

    }

    @Override
    public void callFragmentForInfo(int num, HerbJson herb_info) {

    }

    @Override
    public void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user) {

    }

    @Override
    public void closeFragment() { }

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
