package com.beautifourest.forestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.databinding.ActivityImageViewBinding;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

public class ImageViewActivity extends AppCompatActivity  implements View.OnClickListener {
    int selected = 0;
    List<String> imgs;
    TextView text;
    ImageButton leftBtn, rightBtn;
    PhotoView imageView;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        /* 전달 받은 이미지 값 얻어옴 */
        Intent intent = getIntent();
        imgs = (List<String>) intent.getExtras().getSerializable("imgs");
        name = intent.getExtras().getString("name");

        imageView = findViewById(R.id.image);
        text = findViewById(R.id.plantname);
        text.setText(name);

        Glide.with(imageView.getContext()).load(imgs.get(0)).into(imageView);

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.leftBtn :
                if(selected > 0) selected--;
                else{
                    selected = imgs.size()-1;
                }
                Glide.with(imageView.getContext()).load(imgs.get(selected)).into(imageView);
                break;
            case R.id.rightBtn :
                if(selected < imgs.size()-1) selected++;
                else{
                    selected = 0;
                }
                Glide.with(imageView.getContext()).load(imgs.get(selected)).into(imageView);
                break;
        }
    }
}