package com.beautifourest.forestapp.ui.mybook;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class MbViewModel extends BaseObservable implements Comparable<MbViewModel>{
    ////유경추가///
    public int bid;
    /////////////

    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();

    public int did;

    public int isHerb;

    public MbViewModel(String img, String name, int isHerb, int did) {
        this.img.set(img);
        this.name.set(name);
        this.isHerb=isHerb;
        this.did= did;
    }

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    @Bindable
    public int getSaleVisibility(){ // 허브면 체크버튼 보여줌
        return isHerb==1 ? View.VISIBLE : View.GONE;
    }

    @Override
    public int compareTo(MbViewModel myplantsJson) {
        return this.name.get().compareTo(myplantsJson.name.get());
    }
}
