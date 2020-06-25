package com.example.forestapp.ui.insertDisease;

import android.util.Log;
import android.widget.AutoCompleteTextView;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forestapp.baseViewModel;

public class InsertDialogViewModel extends baseViewModel {
    public final ObservableField<String> disease = new ObservableField<>();

    @Override
    public void onCreate() {
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

    public void insert(){
        Log.d("Test","insert");
    }
    public void cancel(){
        Log.d("Test","cancel");
    }

}