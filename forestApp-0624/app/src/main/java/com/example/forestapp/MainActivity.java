package com.example.forestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.forestapp.databinding.ActivityLoginBinding;

public class MainActivity extends AppCompatActivity {
    ActivityLoginBinding mBinding;
    private MainViewModel model = new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //mBinding.idinput.setText("바인딩 성공");
        //mBinding.setActivity(this);
        //mBinding.setModel(model);
        model.onCreate();
}

    public void SignupClicked(View view)
    {
        //Toast.makeText(this.getApplicationContext(),"이것은 Toast 메시지입니다.", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(MainActivity.this, ListActivity.class) ;
        //startActivity(intent) ;

        Intent intent = new Intent(MainActivity.this, ServerActivity.class) ;
        startActivity(intent) ;
    }

    public void LoginClicked(View view)
    {
        //Toast.makeText(this.getApplicationContext(),"이것은 Toast 메시지입니다.", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(MainActivity.this, ListActivity.class) ;
        //startActivity(intent) ;

        Intent intent = new Intent(MainActivity.this, ServerActivity.class) ;
        startActivity(intent) ;
    }
}