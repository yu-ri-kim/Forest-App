package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/* 질병정보 데이터가 리스트와 status로 올 경우의 클래스 */
public class DiseaseJsons {
    @SerializedName("data")
    @Expose
    private List<DiseaseJson> data = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<DiseaseJson> getData() {
        return data;
    }

    public void setData(List<DiseaseJson> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
