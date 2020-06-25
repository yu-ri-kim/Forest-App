package com.example.forestapp.Model;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface { // 서버에게 보낼 url들
    @GET("/{op}")
    Call<UserJsons> getFirst(@Path("op") String op);

    @GET("/PlantInfo/getAllPlants")
    Call<List<PlantJson>> getPlantInfo();

    @GET("/PlantInfo/getAllPlantsInfo")
    Call<List<PlantJson>> getPlantInfo_detail();

    @GET("/PlantInfo/getAllHerb")
    Call<List<HerbJson>> getHerbInfo();

    @POST("/User/UserValid")
    Call<PostJsons> postLogin(@Body UserJson user);

    @POST("/User/InsertUser")
    Call<PostJsons> postSignup(@Body UserJson user);

    @POST("/User/getUserByID")
    Call<UserJsons> postGetUser(@Body UserJson user);

    @GET("/PlantInfo/getPlantsbyDisease?search=")
    Call<List<DiseaseJson>> getDisesaseInfo();
}
