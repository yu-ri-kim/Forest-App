package com.beautifourest.forestapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* 결과값을 위한 클래스 */
public class PostJsons {
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("Exception")
    @Expose
    private String Exception;
    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("message")
    @Expose
    private String message;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getException() {
        return Exception;
    }

    public void setException(String exception) {
        Exception = exception;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PostJsons{" +
                "data='" + data + '\'' +
                ", status='" + status + '\'' +
                ", Exception='" + Exception + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
