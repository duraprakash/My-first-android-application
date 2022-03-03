package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Full_Screen_Image extends AppCompatActivity {

    // 1.1 initial variable
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full__screen__image);

        // 1.2 hide actionBar and set title
//        getSupportActionBar.hide();
//        getSupportActionBar().setTitle("Full Screen");

        // 1.3 assign id to variable then go to GridView_Activity
        imageView = findViewById(R.id.iv_fullImage);

        // 1.4 set data to be shown
        Intent intent = getIntent();
        int i = intent.getExtras().getInt("id");

        // 1.5 to show adapter
        ImageAdapter imageAdapter = new ImageAdapter(this);
        // 1.6 providing image position
        imageView.setImageResource(imageAdapter.imageArray[i]);


    }
}