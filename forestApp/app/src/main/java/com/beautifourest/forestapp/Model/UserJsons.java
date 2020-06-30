package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/* 전체 유저 객체와 결과값을 저장하는 클래스 */
public class UserJsons {
    @SerializedName("data")
    @Expose
    private List<UserJson> data = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<UserJson> getData() {
        return data;
    }

    public void setData(List<UserJson> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
