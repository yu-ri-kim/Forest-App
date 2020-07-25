package com.beautifourest.forestapp.Model;

import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* 서버 통신 클래스 */
public class RequestForServer {
    final private String SERVER_URL = "http://3.129.13.221:5000";

    private String op="";
    private Object ob;
    private Retrofit retrofit;
    private RetrofitInterface retrofitAPI;

    /* insert plant, mushroom에 있는 카메라에 사용 */
    private MultipartBody.Part mpFile; // 이미지 보내기 위한 객체
    private Map<String, RequestBody> rqMap; // 다른 정보를 보내기 위한 객체

    /* naver query */
    private String query="";

    public RequestForServer() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://52.14.219.87:8080")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitInterface.class);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public MultipartBody.Part getMpFile() {
        return mpFile;
    }

    public void setMpFile(MultipartBody.Part mpFile) {
        this.mpFile = mpFile;
    }

    public Map<String, RequestBody> getRqMap() {
        return rqMap;
    }

    public void setRqMap(Map<String, RequestBody> rqMap) {
        this.rqMap = rqMap;
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

        else if(op.equals("AllPlantInfo")){
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
        else if(op.equals("AllPlant")){
            retrofitAPI.getPlantInfo().enqueue(new Callback<List<PlantJson>>() {
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

        else if(op.equals("AllPlantMok")){
            retrofitAPI.getPlantInfoMok_detail().enqueue(new Callback<List<PlantJson>>() {
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

        else if(op.equals("AllPlantCho")){
            retrofitAPI.getPlantInfoCho_detail().enqueue(new Callback<List<PlantJson>>() {
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

        else if(op.equals("GetHerbID")){
            HerbJson hj=(HerbJson)ob;
            Integer HrbId=hj.getHrbId();
            retrofitAPI.getHerbByID(HrbId).enqueue(new Callback<HerbJson>() {
                @Override
                public void onResponse(Call<HerbJson> call, Response<HerbJson> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<HerbJson> call, Throwable t) {
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

        else if(op.equals("GetDisesaseInfo")){ // 질병으로 약초 얻기
            retrofitAPI.getDisesaseInfo().enqueue(new Callback<List<DiseaseJson>>() {
                @Override
                public void onResponse(Call<List<DiseaseJson>> call, Response<List<DiseaseJson>> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<DiseaseJson>> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("GetDiseaseName")){ // 질병 이름만 얻기
            retrofitAPI.getDiseaseNames().enqueue(new Callback<List<DiseaseJson>>() {
                @Override
                public void onResponse(Call<List<DiseaseJson>> call, Response<List<DiseaseJson>> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<DiseaseJson>> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("InsertDisease")){ // 질병 등록하기
            retrofitAPI.insertDisease((InsertDisease) ob).enqueue(new Callback<PostJsons>() {
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

        else if(op.equals("GetUserHerbs")){ // 사용자에게 맞는 허브 가져오기
            retrofitAPI.postGetUserHerbs((UserJson) ob).enqueue(new Callback<DiseaseJsons>() {
                @Override
                public void onResponse(Call<DiseaseJsons> call, Response<DiseaseJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<DiseaseJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("deleteAllPlants")){ // 나의 temp plants 전체 삭제
            retrofitAPI.deleteAllPlants((UserJson) ob).enqueue(new Callback<PostJsons>() {
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

        else if(op.equals("getAllPlants")){ // 나의 temp plant 다 받아오기
            retrofitAPI.getAllPlants((UserJson) ob).enqueue(new Callback<MyplantsJsons>() {
                @Override
                public void onResponse(Call<MyplantsJsons> call, Response<MyplantsJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<MyplantsJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("getInfoByname")){ // 이름으로 식물찾기
            PlantJson pj = (PlantJson)getOb();
            String name = pj.getFskName();

            retrofitAPI.getInfoByname(name).enqueue(new Callback<List<PlantJson>>() {
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

        else if(op.equals("getInfoByDid")){ // 번호로 가져오기
            MyplantsJson gg = (MyplantsJson)ob;
            Log.d("Test",gg.toString());

            retrofitAPI.getInfoByDid((MyplantsJson)ob).enqueue(new Callback<MyPlantsInfoJson>() {
                @Override
                public void onResponse(Call<MyPlantsInfoJson> call, Response<MyPlantsInfoJson> response) {
                    if (response.isSuccessful()) {
                        Log.d("Test", "success"+response.body());
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<MyPlantsInfoJson> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("deleteTempPlants")){ // 나의 temp plants 일부 삭제
            retrofitAPI.deleteTempPlants((MyplantsJson) ob).enqueue(new Callback<PostJsons>() {
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

        else if(op.equals("DeleteDisease")){ //관심있는 질병 삭제
            retrofitAPI.deleteDisease((InsertDisease)ob).enqueue(new Callback<PostJsons>() {
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

        else if(op.equals("getOnePlant")){  //temp plant 중 한 개 가져오기
            retrofitAPI.getOnePlants((MyplantsJson)ob).enqueue(new Callback<MyplantsJsons>() {
                @Override
                public void onResponse(Call<MyplantsJsons> call, Response<MyplantsJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<MyplantsJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("getALLTempPlants")){  // 전체 게시판 가져오기
            retrofitAPI.getAllTempPlants().enqueue(new Callback<MyplantsJsons>() {
                @Override
                public void onResponse(Call<MyplantsJsons> call, Response<MyplantsJsons> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<MyplantsJsons> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

        else if(op.equals("writeComment")){  // 댓글 쓰기
            retrofitAPI.writeComment((Comment) ob).enqueue(new Callback<PostJsons>() {
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

        else if(op.equals("getAllComment")){  // 댓글 가져오기
            retrofitAPI.getAllComment((MyplantsJson) ob).enqueue(new Callback<Comments>() {
                @Override
                public void onResponse(Call<Comments> call, Response<Comments> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<Comments> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }

       else if(op.equals("getSearchResult")){
            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RetrofitInterface retrofitAPI2 = retrofit2.create(RetrofitInterface.class);

            Log.d("Test", query);
            retrofitAPI2.getSearchResult(query).enqueue(new Callback<SearchResult>() {
                @Override
                public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<SearchResult> call, Throwable t) {
                    callback.onError(t);
                }
            });
        }
    }

    public void exec_photo(final RetroCallback callback){
        if (op.equals("InsertPlants")){
            Log.d("camera_forest", "request_For_server start");

            retrofitAPI.uploadPlants(mpFile,rqMap).enqueue(new Callback<PostJsons>() {
                @Override
                public void onResponse(Call<PostJsons> call, Response<PostJsons> response) {
                    if (response.isSuccessful()) {
                        Log.d("camera_forest", "request_For_server successful");

                        callback.onSuccess(response.code(), response.body());
                    } else {
                        Log.d("camera_forest", "request_For_server failure");

                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsons> call, Throwable t) {
                    Log.d("camera_forest", "request_For_server error");

                    callback.onError(t);
                }
            });
        }
        else if(op.equals("uploadMushroom")){
            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl("http://3.129.13.221:5000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RetrofitInterface retrofitAPI2 = retrofit2.create(RetrofitInterface.class);

            Log.d("camera_forest", "upload mushroom start");

            retrofitAPI2.uploadMushroom(mpFile).enqueue(new Callback<PostJsonsForResult>() {
                @Override
                public void onResponse(Call<PostJsonsForResult> call, Response<PostJsonsForResult> response) {
                    if (response.isSuccessful()) {
                        Log.d("camera_forest", "upload mushroom successful");

                        callback.onSuccess(response.code(), response.body());
                    } else {
                        Log.d("camera_forest", "rupload mushroom failure");
                        Log.d("camera_forest", "rupload mushroom failure");
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsonsForResult> call, Throwable t) {
                    Log.d("camera_forest", "upload mushroom error");

                    callback.onError(t);
                }
            });
        }

        else if(op.equals("uploadPlant")){
            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl("http://3.129.13.221:5000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RetrofitInterface retrofitAPI2 = retrofit2.create(RetrofitInterface.class);

            Log.d("camera_forest", "upload plant start");

            retrofitAPI2.uploadPlant(mpFile).enqueue(new Callback<PostJsonsForResult>() {
                @Override
                public void onResponse(Call<PostJsonsForResult> call, Response<PostJsonsForResult> response) {
                    if (response.isSuccessful()) {
                        Log.d("camera_forest", "upload plant successful");

                        callback.onSuccess(response.code(), response.body());
                    } else {
                        Log.d("camera_forest", "rupload plant failure");
                        Log.d("camera_forest", "rupload plant failure");
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsonsForResult> call, Throwable t) {
                    Log.d("camera_forest", "upload plant error");

                    callback.onError(t);
                }
            });
        }

        else if (op.equals("updatePlants")){
            Log.d("camera_forest", "update start");

            retrofitAPI.updatePlants(mpFile,rqMap).enqueue(new Callback<PostJsons>() {
                @Override
                public void onResponse(Call<PostJsons> call, Response<PostJsons> response) {
                    if (response.isSuccessful()) {
                        Log.d("camera_forest", "update successful");
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        Log.d("camera_forest", "update failure");
                        callback.onFailure(response.code());
                    }
                }

                @Override
                public void onFailure(Call<PostJsons> call, Throwable t) {
                    Log.d("camera_forest", "update error");
                    callback.onError(t);
                }
            });
        }

    }
}
