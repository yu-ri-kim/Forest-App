package com.beautifourest.forestapp.Model;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* API 리스트 */
public interface RetrofitInterface {
    @GET("/{op}")
    Call<UserJsons> getFirst(@Path("op") String op);

    @GET("/PlantInfo/getAllPlants")
    Call<List<PlantJson>> getPlantInfo();

    @GET("/PlantInfo/getAllPlantsInfo")
    Call<List<PlantJson>> getPlantInfo_detail();

    @GET("/PlantInfo/getAllPlantsByMok")
    Call<List<PlantJson>> getPlantInfoMok_detail();

    @GET("/PlantInfo/getAllPlantsByCho")
    Call<List<PlantJson>> getPlantInfoCho_detail();

    @GET("/PlantInfo/getAllHerb")
    Call<List<HerbJson>> getHerbInfo();

    @POST("/User/UserValid")
    Call<PostJsons> postLogin(@Body UserJson user);

    @POST("/User/InsertUser")
    Call<PostJsons> postSignup(@Body UserJson user);

    @POST("/User/getUserByID")
    Call<UserJsons> postGetUser(@Body UserJson user);

    @GET("/PlantInfo/getHerbs")
    Call<HerbJson> getHerbByID(@Query("HrbId")Integer id);

    @GET("/PlantInfo/getPlantsbyDisease?search=")
    Call<List<DiseaseJson>> getDisesaseInfo();

    @GET("/Disease/getDList?search=")
    Call<List<DiseaseJson>> getDiseaseNames();

    @POST("/Disease/insertDbyID")
    Call<PostJsons> insertDisease(@Body InsertDisease insertDisease);

    @POST("/Disease/deleteDisease")
    Call<PostJsons> deleteDisease(@Body InsertDisease insertDisease);

    @POST("/PlantInfo/getUserHerbs")
    Call<DiseaseJsons> postGetUserHerbs(@Body UserJson user);

    @Multipart
    @POST("/TempPlants/InsertTempPlants")
    Call<PostJsons> uploadPlants(@Part MultipartBody.Part file, @PartMap Map<String, RequestBody> info);

    @Multipart
    @POST("/TempPlants/UpdateTempPlants")
    Call<PostJsons> updatePlants(@Part MultipartBody.Part file, @PartMap Map<String, RequestBody> info);

    @Multipart
    @POST("/poisonresult")
    Call<PostJsonsForResult> uploadMushroom(@Part MultipartBody.Part file);

    @Multipart
    @POST("/herbresult")
    Call<PostJsonsForResult> uploadPlant(@Part MultipartBody.Part file);

    @HTTP(method = "DELETE", path = "/TempPlants/deleteallTempPlants", hasBody = true)
    Call<PostJsons> deleteAllPlants(@Body UserJson user);

    @POST("/TempPlants/getTempPlants")
    Call<MyplantsJsons> getAllPlants(@Body UserJson user);

    @GET("/PlantInfo/getPlantsbyName")
    Call<List<PlantJson>> getInfoByname(@Query("search") String name);

    @POST("/TempPlants/getoneTempPlants")
    Call<MyPlantsInfoJson> getInfoByDid(@Body MyplantsJson info);

    @HTTP(method = "DELETE", path = "/TempPlants/deleteTempPlants", hasBody = true)
    Call<PostJsons> deleteTempPlants(@Body MyplantsJson user);

    @POST("/TempPlants/getoneTempPlants")
    Call<MyplantsJsons> getOnePlants(@Body MyplantsJson myplant);

    @GET("/TempPlants/getALLTempPlants")
    Call<MyplantsJsons> getAllTempPlants();

    @POST("/TempPlants/Comment")
    Call<PostJsons> writeComment(@Body Comment info);

    @POST("/TempPlants/getComments")
    Call<Comments> getAllComment(@Body MyplantsJson info);

    @GET("/naverapi?search=")
    Call<Navers> getNaverapi();
}
