package com.example.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiseaseJson {
    @SerializedName("fsImg_1")
    @Expose
    private String fsImg1;
    @SerializedName("hrbId")
    @Expose
    private Integer hrbId;
    @SerializedName("hrbName")
    @Expose
    private String hrbName;
    @SerializedName("dname")
    @Expose
    private String dname;
    @SerializedName("did")
    @Expose
    private int did;

    public String getFsImg1() {
        return fsImg1;
    }

    public void setFsImg1(String fsImg1) {
        this.fsImg1 = fsImg1;
    }

    public Integer getHrbId() {
        return hrbId;
    }

    public void setHrbId(Integer hrbId) {
        this.hrbId = hrbId;
    }

    public String getHrbName() {
        return hrbName;
    }

    public void setHrbName(String hrbName) {
        this.hrbName = hrbName;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
