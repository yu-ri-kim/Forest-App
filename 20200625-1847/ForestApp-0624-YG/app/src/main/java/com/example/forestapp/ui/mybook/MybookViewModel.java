package com.example.forestapp.ui.mybook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MybookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MybookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mybook fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}