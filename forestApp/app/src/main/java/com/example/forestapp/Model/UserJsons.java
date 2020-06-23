package com.example.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserJsons { // 전체 유저 받으려고 만든 객체
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
