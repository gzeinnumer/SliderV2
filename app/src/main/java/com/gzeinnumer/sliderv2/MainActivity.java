package com.gzeinnumer.sliderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CarouselView customCarouselView;

    String[] sampleNetworkImageURLs = {
            "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg",
            "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547__340.jpg",
            "https://c4.wallpaperflare.com/wallpaper/246/739/689/digital-digital-art-artwork-illustration-abstract-hd-wallpaper-thumb.jpg",
            "https://c4.wallpaperflare.com/wallpaper/39/346/426/digital-art-men-city-futuristic-night-hd-wallpaper-thumb.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCarouselView = findViewById(R.id.customCarouselView);

        customCarouselView.setPageCount(sampleNetworkImageURLs.length);
        customCarouselView.setSlideInterval(1000);

        customCarouselView.setViewListener(position -> {
            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);
            ImageView fruitImageView = customView.findViewById(R.id.fruitImageView);
            Glide.with(getApplicationContext()).load(sampleNetworkImageURLs[position]).into(fruitImageView);
            return customView;
        });
        customCarouselView.setImageClickListener(position -> {
            Toast.makeText(getApplicationContext(), "Clicked item: " + position, Toast.LENGTH_SHORT).show();
        });

        //https://github.com/sayyam/carouselview
    }

}