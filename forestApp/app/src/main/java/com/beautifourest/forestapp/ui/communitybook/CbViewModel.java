package com.beautifourest.forestapp.ui.communitybook;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/* 모두의 도감에 보여질 각각의 게시글 */
public class CbViewModel extends BaseObservable implements Comparable<CbViewModel>{
    ////유경추가///
    public int bid;
    /////////////

    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();

    public int did;
    public int isHerb;
    public String userid;

    public CbViewModel(String img, String name, int isHerb, int did, String userid) {
        this.img.set(img);
        this.name.set(name);
        this.isHerb=isHerb;
        this.did= did;
        this.userid = userid;
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
    public int compareTo(CbViewModel myplantsJson) {
        return this.name.get().compareTo(myplantsJson.name.get());
    }
}
