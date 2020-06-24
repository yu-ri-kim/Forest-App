package com.example.forestapp.ui.hurbSearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HurbSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HurbSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}