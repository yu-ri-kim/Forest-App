package com.example.forestapp.ui.book;

import android.media.Image;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.forestapp.Model.PlantJson;
import com.example.forestapp.Model.RequestForServer;
import com.example.forestapp.Model.RetroCallback;
import com.example.forestapp.baseViewModel;

import java.util.List;

public class BookViewModel{
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name=new ObservableField<>();

    public BookViewModel(String img, String name){
        this.img.set(img);
        this.name.set(name);
    }

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }

}
