package com.example.forestapp;

import com.example.forestapp.Model.UserJson;

public interface CallAnotherActivityNavigator { // 화면전환을 위한 인터페이스
    void callActivity(UserJson user);
}