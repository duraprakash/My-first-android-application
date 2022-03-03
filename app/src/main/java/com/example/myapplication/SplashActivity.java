package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    // 2 ProgressBar
    // 2.1 variable
    ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 1.7 hide action bar
        // getSupportActionBar().hide();

        // 2.2 creating handler: exit app when back buttton is clicked
        new Handler().postDelayed(new Runnable(){
            @Override
            // 2.3 method
            public void run(){
                // 2.4 progressbar visibility
                progress_circular.setVisibility(View.GONE);
            }
        },4000); // 2.5 set time

        // 1 delay splash screen
        // 1.1 class variable(instance) = new object
        Thread thread = new Thread(){
            // 1.2 method
            public void run(){
                // 1.3 exception handling
                try{
                    // delay code for 4sec
                    sleep(4000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    // 1.4 intent: go to another activity
                    Intent intent = new Intent(SplashActivity.this, MainActivity2.class);
                    startActivity(intent);

                }
            }
        };thread.start(); // 1.5 using thread // 1.6 AndroidManifest.xml

    }
}