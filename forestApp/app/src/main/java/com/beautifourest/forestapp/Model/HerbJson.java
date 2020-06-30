package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/* 허브 정보 클래스 */
public class HerbJson implements Serializable {
    @SerializedName("pNum")
    @Expose
    private Integer pNum;
    @SerializedName("mng")
    @Expose
    private String mng;
    @SerializedName("caution")
    @Expose
    private String caution;
    @SerializedName("internal")
    @Expose
    private String internal;
    @SerializedName("external")
    @Expose
    private String external;
    @SerializedName("fsImg_1")
    @Expose
    private String fsImg1;
    @SerializedName("fsImg_2")
    @Expose
    private String fsImg2;
    @SerializedName("country")
    @Expose
    private List<String> country = null;
    @SerializedName("disease")
    @Expose
    private List<String> disease = null;
    @SerializedName("hrbId")
    @Expose
    private Integer hrbId;
    @SerializedName("hrbName")
    @Expose
    private String hrbName;

    public String getMng() {
        return mng;
    }

    public void setMng(String mng) {
        this.mng = mng;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
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

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getDisease() {
        return disease;
    }

    public void setDisease(List<String> disease) {
        this.disease = disease;
    }

    public Integer getPNum() {
        return pNum;
    }

    public void setPNum(Integer pNum) {
        this.pNum = pNum;
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

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    @Override
    public String toString() {
        return "HerbJson{" +
                "pNum=" + pNum +
                ", mng='" + mng + '\'' +
                ", caution='" + caution + '\'' +
                ", internal='" + internal + '\'' +
                ", external='" + external + '\'' +
                ", fsImg1='" + fsImg1 + '\'' +
                ", fsImg2='" + fsImg2 + '\'' +
                ", country=" + country +
                ", disease=" + disease +
                ", hrbId=" + hrbId +
                ", hrbName='" + hrbName + '\'' +
                '}';
    }
}