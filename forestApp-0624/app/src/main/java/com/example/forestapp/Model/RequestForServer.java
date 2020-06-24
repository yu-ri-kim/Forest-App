package com.example.forestapp.Model;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestForServer { // 서버랑 통신하기 위한 객체 -> 싱글톤패턴으로 바꿔야 함
    private String op;
    private Object ob;
    private Retrofit retrofit;
    private RetrofitInterface retrofitAPI;

    public RequestForServer() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://52.14.219.87:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitInterface.class);
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }

    public void exec(final RetroCallback callback) {
        if (op.equals("Login")) {
            retrofitAPI.postLogin((UserJson) ob).enqueue(new Callback<PostJsons>() {
                @Override
                public void onResponse(Call<PostJsons> call, Response<PostJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }
        else if(op.equals("Signup")){
            retrofitAPI.postSignup((UserJson) ob).enqueue(new Callback<PostJsons>() {
                @Override
                public void onResponse(Call<PostJsons> call, Response<PostJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("AllPlant")){
            retrofitAPI.getPlantInfo_detail().enqueue(new Callback<List<PlantJson>>() {
                @Override
                public void onResponse(Call<List<PlantJson>> call, Response<List<PlantJson>> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<PlantJson>> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("GetUserInfo")){ // id로 유저정보 가져오기
            retrofitAPI.postGetUser(((UserJson) ob)).enqueue(new Callback<UserJsons>() {
                @Override
                public void onResponse(Call<UserJsons> call, Response<UserJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<UserJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("AllHerb")){
            retrofitAPI.getHerbInfo().enqueue(new Callback<List<HerbJson>>() {
                @Override
                public void onResponse(Call<List<HerbJson>> call, Response<List<HerbJson>> response) {
                    if(response.isSuccessful()){
                        callback.onSuccess(response.code(),response.body());
                    }else{
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<HerbJson>> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

    }
}
