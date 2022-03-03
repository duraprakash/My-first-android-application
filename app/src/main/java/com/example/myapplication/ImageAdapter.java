package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

// 1.1 extends BaseAdapter then implement all methods
public class ImageAdapter extends BaseAdapter {

    // 1.2 creating constructor
    private Context mcontext;
    // 1.3 storing image
    // from https://www.holidify.com/country/nepal/places-to-visit.html
    public int[] imageArray = {
            R.drawable.bandipur1, R.drawable.bhaktapur1, R.drawable.biratnagar1, R.drawable.birgunj1,
            R.drawable.chandragiri_hill1, R.drawable.chitwan_national_park1, R.drawable.daman1,
            R.drawable.dharan1, R.drawable.dhulikhel1, R.drawable.gorkha1, R.drawable.itahari1,
            R.drawable.janakpur1, R.drawable.jomsom1, R.drawable.kagbeni1, R.drawable.mt_manaslu1
    };

    // 1.4 context constructor using generate then go to java 1.3
    public ImageAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        // 1.5 count image
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        // 1.6 get image
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 1.7 then go to  1.3
        ImageView imageView = new ImageView(mcontext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300,350));

        return imageView;
    }
}
