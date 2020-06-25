package com.example.forestapp.ui.hurbSearch;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.Model.UserJson;
import com.example.forestapp.baseViewModel;

public class HurbSearchViewModel extends baseViewModel {
    UserJson user;

    public HurbSearchViewModel(UserJson user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        Log.d("Test","viewmodel: "+user.toString());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    public void photo(){

    }
}