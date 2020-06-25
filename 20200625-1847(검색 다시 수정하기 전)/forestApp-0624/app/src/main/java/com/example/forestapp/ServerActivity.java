package com.example.forestapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forestapp.Model.RetrofitInterface;
import com.example.forestapp.Model.UserJson;
import com.example.forestapp.Model.UserJsons;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        Intent intent = getIntent();
        UserJson user = (UserJson)intent.getExtras().get("user"); /*String형*/
        Log.d("Test",user.toString());

        /*
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.14.219.87:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitAPI = retrofit.create(RetrofitInterface.class);
        Log.d("Test","시");
        retrofitAPI.getFirst("getAllUser").enqueue(new Callback<UserJsons>(){
            @Override
            public void onResponse(Call<UserJsons> call, Response<UserJsons> response) {
                if(response.isSuccessful()){
                    UserJsons data = response.body();
                    Log.d("Test","성공성공");
                    Log.d("Test",data.getData().get(0).getGender());
                }
                else{
                    Log.d("Test","뭐지");
                }
            }

            @Override
            public void onFailure(Call<UserJsons> call, Throwable t) {
                Log.d("Test","실패실패");
                t.printStackTrace();
            }
        });
        Log.d("Test","완료");

         */
    }

}