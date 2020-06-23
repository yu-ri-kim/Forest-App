package com.example.forestapp;

import androidx.databinding.ObservableArrayList;

import java.util.Random;

public class UsersViewModel extends baseViewModel { // 유저 목록을 가지고 있음
    public final ObservableArrayList<UserViewModel> users = new ObservableArrayList<>();
    @Override
    void onCreate() {

    }

    @Override
    void onResume() {

    }

    @Override
    void onPause() {

    }

    @Override
    void onDestroy() {

    }

    public void newUser() { // activity_list.xml에서 버튼을 누르면 유저가 생성됨
        users.add(new UserViewModel("name " + random(), "email " + random()));
    }

    private int random() {
        return new Random().nextInt();
    }
}
