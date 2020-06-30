package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/* 나만의 식물도감 전체 데이터 클래스 */
public class MyplantsJsons {
    @SerializedName("data")
    @Expose
    private List<MyplantsJson> data = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<MyplantsJson> getData() {
        return data;
    }

    public void setData(List<MyplantsJson> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
