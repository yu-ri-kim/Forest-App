package com.beautifourest.forestapp.ui.bookInfo;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.BookMainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.List;

/* 도감 상세정보 viewmodel */
public class BookInfoViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer();
    private CallAnotherActivityNavigator navigator;
    PlantJson plant;

    public final ObservableField<String> name=new ObservableField<>();
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> ename=new ObservableField<>();
    public final ObservableField<String> lifetime=new ObservableField<>();
    public final ObservableField<String> season=new ObservableField<>();
    public final ObservableField<String> gbn=new ObservableField<>();
    public final ObservableField<String> classname=new ObservableField<>();
    public final ObservableField<String> isHerb=new ObservableField<>();

    public String img2 ="";

    public BookInfoViewModel(PlantJson plant, CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
        this.plant=plant;
        this.name.set(plant.getFskName());
        this.img.set(plant.getFsImg1());
        this.ename.set(plant.getFseName());
        this.lifetime.set(plant.getFsLifeTime());
        this.season.set(plant.getSeason());
        this.gbn.set(plant.getFsGbn());
        this.classname.set(plant.getFsClassname());

        if(plant.getIsHerb() == 0){
            this.isHerb.set("일반 식물");
        }
        else{
            this.isHerb.set("약용 식물");
        }

        this.img2 = plant.getFsImg2();
    }


    public void showImage(){
        List<String> imgs= new ArrayList<>();
        imgs.add(img.get());
        imgs.add(img2);

        navigator.callImageActivity(imgs,name.get());
    }

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

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }

}