package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridView_Activity extends AppCompatActivity {

    // 1.1  initial variable
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_);

        // 1.2 assign id to variable
        gridView = findViewById(R.id.gv_GridView);

        // 1.3 java class ImageAdapter connection storing the image using constructor
        gridView.setAdapter(new ImageAdapter(this));

        // 1.4 show full screen image on clicked
        // 1.5 in mainfest.xml add hardwareAccelerated=false and largeHeap=true to avoid app crash when large images are stored
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridView_Activity.this, "Click item "+i, Toast.LENGTH_SHORT).show();

                // 1.6 go to activity
                Intent fullimageintent = new Intent(getApplicationContext(),Full_Screen_Image.class);
                // 1.7 showing image position then go to Full_Screen_Image 1.4
                fullimageintent.putExtra("id",i);
                startActivity(fullimageintent);
            }
        });


    }
}