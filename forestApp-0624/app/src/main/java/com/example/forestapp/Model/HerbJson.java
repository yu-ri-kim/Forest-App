package com.example.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HerbJson {
    @SerializedName("pNum")
    @Expose
    private Integer pNum;

    @SerializedName("fsImg_1")
    @Expose
    private String fsImg1;

    @SerializedName("hrbId")
    @Expose
    private Integer hrbId;

    @SerializedName("hrbName")
    @Expose
    private String hrbName;

    public Integer getPNum() {
        return pNum;
    }

    public void setPNum(Integer pNum) {
        this.pNum = pNum;
    }

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

    @Override
    public String toString() {
        return "HerbJson{" +
                "pNum=" + pNum +
                ", fsImg1='" + fsImg1 + '\'' +
                ", hrbId=" + hrbId +
                ", hrbName='" + hrbName + '\'' +
                '}';
    }
}