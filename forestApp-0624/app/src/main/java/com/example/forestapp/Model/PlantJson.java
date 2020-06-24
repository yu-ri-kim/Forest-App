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
    private String fseName;
    @SerializedName("fsLifeTime")
    @Expose
    private String fsLifeTime;
    @SerializedName("fsImg_1")
    @Expose
    private String fsImg1;
    @SerializedName("fsImg_2")
    @Expose
    private String fsImg2;
    @SerializedName("fsGbn")
    @Expose
    private String fsGbn;
    @SerializedName("fsClassname")
    @Expose
    private String fsClassname;
    @SerializedName("isHerb")
    @Expose
    private Integer isHerb;
    @SerializedName("s_Month")
    @Expose
    private Integer sMonth;
    @SerializedName("hName")
    @Expose
    private String hName;
    @SerializedName("season")
    @Expose
    private String season;

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

    public String getFseName() {
        return fseName;
    }

    public void setFseName(String fseName) {
        this.fseName = fseName;
    }

    public String getFsLifeTime() {
        return fsLifeTime;
    }

    public void setFsLifeTime(String fsLifeTime) {
        this.fsLifeTime = fsLifeTime;
    }

    public String getFsImg1() {
        return fsImg1;
    }

    public void setFsImg1(String fsImg1) {
        this.fsImg1 = fsImg1;
    }

    public String getFsImg2() {
        return fsImg2;
    }

    public void setFsImg2(String fsImg2) {
        this.fsImg2 = fsImg2;
    }

    public String getFsGbn() {
        return fsGbn;
    }

    public void setFsGbn(String fsGbn) {
        this.fsGbn = fsGbn;
    }

    public String getFsClassname() {
        return fsClassname;
    }

    public void setFsClassname(String fsClassname) {
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

    public String getHName() {
        return hName;
    }

    public void setHName(String hName) {
        this.hName = hName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
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
