package com.example.forestapp.ui.bookSearch;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class BkViewModel {
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> data = new ObservableField<>();

    public BkViewModel(String img, String name, String data) {
        this.img.set(img);
        this.name.set(name);
        this.data.set(data);
    }

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }
}
