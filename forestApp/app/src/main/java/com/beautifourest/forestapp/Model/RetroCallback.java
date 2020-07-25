package com.beautifourest.forestapp.Model;

public interface RetroCallback<T> {
    void onError(Throwable t);
    void onSuccess(int code, T receivedData);
    void onFailure(int code);
}
