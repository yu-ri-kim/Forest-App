package com.beautifourest.forestapp.ui.book;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.ui.mybook.MbViewModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/* gridview의 구성요소 */
public class BookViewModel implements Comparable<BookViewModel>{
    public final ObservableField<Integer> hrbid=new ObservableField<>();
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name=new ObservableField<>();

    public BookViewModel(Integer hrbID, String img, String name){
        this.hrbid.set(hrbID);
        this.img.set(img);
        this.name.set(name);
    }

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    @Override
    public int compareTo(BookViewModel bookViewModel) {
        return this.name.get().compareTo(bookViewModel.name.get());
    }
}
