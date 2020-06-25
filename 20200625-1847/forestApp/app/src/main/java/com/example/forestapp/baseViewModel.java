package com.example.forestapp;
import androidx.lifecycle.ViewModel;

public abstract class baseViewModel extends ViewModel { // 베이스 뷰모델
    abstract void onCreate();
    abstract void onResume();
    abstract void onPause();
    abstract void onDestroy();
}
