package com.example.forestapp;
import androidx.lifecycle.ViewModel;

public abstract class baseViewModel extends ViewModel { // 베이스 뷰모델
    public abstract void onCreate();
    public abstract void onResume();
    public abstract void onPause();
    public abstract void onDestroy();
}