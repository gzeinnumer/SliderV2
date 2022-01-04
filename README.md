# SliderV2
 
```gradle
//library glide
implementation 'com.github.bumptech.glide:glide:4.11.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

implementation 'com.synnapps:carouselview:0.1.5'
```

```xml
<com.synnapps.carouselview.CarouselView
    android:id="@+id/customCarouselView"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    android:layout_marginTop="20dp"
    app:autoPlay="true"
    app:disableAutoPlayOnUserInteraction="false"
    app:fillColor="@color/purple_500"
    app:pageColor="@color/teal_700"
    app:indicatorVisibility="visible"
    app:radius="6dp"
    app:snap="false"
    app:pageTransformer="flow"
    app:indicatorOrientation="vertical"
    app:indicatorGravity="start|bottom"
    app:strokeColor="#FF0000"
    app:strokeWidth="1dp" />
```

```java
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
```


---

```
Copyright 2021 M. Fadli Zein
```