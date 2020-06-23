package com.example.forestapp.Model;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface { // 서버에게 보낼 url들
    @GET("/{op}")
    Call<UserJsons> getFirst(@Path("op") String op);

    @POST("/User/UserValid")
    Call<PostJsons> postLogin(@Body UserJson user);

    @POST("/User/InsertUser")
    Call<PostJsons> postSignup(@Body UserJson user);
}
