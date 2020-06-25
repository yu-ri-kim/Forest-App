package com.example.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostJsons { // post 결과값 받기 위한 객체
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
