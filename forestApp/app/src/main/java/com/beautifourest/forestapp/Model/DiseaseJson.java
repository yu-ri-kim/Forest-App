package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/* 질병정보 클래스 */
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
    @SerializedName("dname_li")
    @Expose
    private List<String> dnameLi = null;

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

    public List<String> getDnameLi() {
        return dnameLi;
    }

    public void setDnameLi(List<String> dnameLi) {
        this.dnameLi = dnameLi;
    }

    @Override
    public String toString() {
        return "DiseaseJson{" +
                "fsImg1='" + fsImg1 + '\'' +
                ", hrbId=" + hrbId +
                ", hrbName='" + hrbName + '\'' +
                ", dname='" + dname + '\'' +
                ", did=" + did +
                ", dnameLi=" + dnameLi +
                '}';
    }
}
