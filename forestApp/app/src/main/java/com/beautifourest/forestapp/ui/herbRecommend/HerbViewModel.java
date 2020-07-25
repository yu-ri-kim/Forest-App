package com.beautifourest.forestapp.ui.herbRecommend;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class HerbViewModel {
    public final ObservableField<Integer> hrbid=new ObservableField<>();
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> data = new ObservableField<>();

    public HerbViewModel(Integer hrbid,String img, String name, String data) {
        this.hrbid.set(hrbid);
        this.img.set(img);
        this.name.set(name);
        this.data.set(data);
    }


    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }
}
