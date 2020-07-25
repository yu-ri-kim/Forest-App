package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* 나만의 식물도감 정보 클래스 */
public class MyPlantsInfoJson {
    @SerializedName("data")
    @Expose
    private MyplantsJson data = null;
    @SerializedName("status")
    @Expose
    private String status;

    public MyplantsJson getData() {
        return data;
    }

    public void setData(MyplantsJson data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
