package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/* 나만의 식물도감 정보 클래스 */
public class MyplantsJson implements Serializable {
    @SerializedName("bid")
    @Expose
    private Integer bid;
    @SerializedName("uid")
    @Expose
    private String uid;
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
    @SerializedName("fsGbn")
    @Expose
    private String fsGbn;
    @SerializedName("fsClassname")
    @Expose
    private String fsClassname;
    @SerializedName("isHerb")
    @Expose
    private Integer isHerb;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "MyplantsJson{" +
                "bid=" + bid +
                ", uid='" + uid + '\'' +
                ", fskName='" + fskName + '\'' +
                ", fseName='" + fseName + '\'' +
                ", fsLifeTime='" + fsLifeTime + '\'' +
                ", fsImg1='" + fsImg1 + '\'' +
                ", fsGbn='" + fsGbn + '\'' +
                ", fsClassname='" + fsClassname + '\'' +
                ", isHerb=" + isHerb +
                '}';
    }
}
