package com.example.forestapp.ui.bookSearch;

import androidx.databinding.ObservableField;

public class BkViewModel {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> data = new ObservableField<>();

    public BkViewModel(String name, String data) {
        this.name.set(name);
        this.data.set(data);
    }
}
