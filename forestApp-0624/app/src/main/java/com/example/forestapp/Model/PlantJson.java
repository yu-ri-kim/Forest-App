package com.example.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlantJson {
    @SerializedName("pNum")
    @Expose
    private Integer pNum;
    @SerializedName("fskName")
    @Expose
    private String fskName;
    @SerializedName("fseName")
    @Expose
    private Object fseName;
    @SerializedName("fsLifeTime")
    @Expose
    private Object fsLifeTime;
    @SerializedName("fsImg_1")
    @Expose
    private String fsImg1;
    @SerializedName("fsImg_2")
    @Expose
    private Object fsImg2;
    @SerializedName("fsGbn")
    @Expose
    private Object fsGbn;
    @SerializedName("fsClassname")
    @Expose
    private Object fsClassname;
    @SerializedName("isHerb")
    @Expose
    private Integer isHerb;
    @SerializedName("s_Month")
    @Expose
    private Integer sMonth;
    @SerializedName("hName")
    @Expose
    private Object hName;
    @SerializedName("season")
    @Expose
    private Object season;

    public Integer getPNum() {
        return pNum;
    }

    public void setPNum(Integer pNum) {
        this.pNum = pNum;
    }

    public String getFskName() {
        return fskName;
    }

    public void setFskName(String fskName) {
        this.fskName = fskName;
    }

    public Object getFseName() {
        return fseName;
    }

    public void setFseName(Object fseName) {
        this.fseName = fseName;
    }

    public Object getFsLifeTime() {
        return fsLifeTime;
    }

    public void setFsLifeTime(Object fsLifeTime) {
        this.fsLifeTime = fsLifeTime;
    }

    public String getFsImg1() {
        return fsImg1;
    }

    public void setFsImg1(String fsImg1) {
        this.fsImg1 = fsImg1;
    }

    public Object getFsImg2() {
        return fsImg2;
    }

    public void setFsImg2(Object fsImg2) {
        this.fsImg2 = fsImg2;
    }

    public Object getFsGbn() {
        return fsGbn;
    }

    public void setFsGbn(Object fsGbn) {
        this.fsGbn = fsGbn;
    }

    public Object getFsClassname() {
        return fsClassname;
    }

    public void setFsClassname(Object fsClassname) {
        this.fsClassname = fsClassname;
    }

    public Integer getIsHerb() {
        return isHerb;
    }

    public void setIsHerb(Integer isHerb) {
        this.isHerb = isHerb;
    }

    public Integer getSMonth() {
        return sMonth;
    }

    public void setSMonth(Integer sMonth) {
        this.sMonth = sMonth;
    }

    public Object getHName() {
        return hName;
    }

    public void setHName(Object hName) {
        this.hName = hName;
    }

    public Object getSeason() {
        return season;
    }

    public void setSeason(Object season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "PlantJson{" +
                "pNum=" + pNum +
                ", fskName='" + fskName + '\'' +
                ", fseName=" + fseName +
                ", fsLifeTime=" + fsLifeTime +
                ", fsImg1='" + fsImg1 + '\'' +
                ", fsImg2=" + fsImg2 +
                ", fsGbn=" + fsGbn +
                ", fsClassname=" + fsClassname +
                ", isHerb=" + isHerb +
                ", sMonth=" + sMonth +
                ", hName=" + hName +
                ", season=" + season +
                '}';
    }
}
