package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/* 질병 정보 삽입을 위한 클래스 */
public class InsertDisease {
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("did")
    @Expose
    private List<String> did = null;
    @SerializedName("dname")
    @Expose
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getDid() {
        return did;
    }

    public void setDid(List<String> did) {
        this.did = did;
    }

}
