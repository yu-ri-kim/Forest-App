package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("bid")
    @Expose
    private Integer bid;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("writeD")
    @Expose
    private String writeD;
    @SerializedName("cid")
    @Expose
    private Integer cid;
    @SerializedName("cmuid")
    @Expose
    private String cmuid;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWriteD() {
        return writeD;
    }

    public void setWriteD(String writeD) {
        this.writeD = writeD;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCmuid() {
        return cmuid;
    }

    public void setCmuid(String cmuid) {
        this.cmuid = cmuid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "bid=" + bid +
                ", uid='" + uid + '\'' +
                ", detail='" + detail + '\'' +
                ", writeD='" + writeD + '\'' +
                ", cid=" + cid +
                ", cmuid='" + cmuid + '\'' +
                '}';
    }
}
