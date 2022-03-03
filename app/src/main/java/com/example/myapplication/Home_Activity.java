package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home_Activity extends AppCompatActivity {

    // 1.1 initial variable
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        //Bottom Navigation Start
        bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int items=item.getItemId();
                switch (items){
                    case R.id.bottom_home:
                        Toast.makeText(Home_Activity.this, "Clicked Home in Bottom", Toast.LENGTH_SHORT).show();
                        Intent intent_home=new Intent(getApplicationContext(),Home_Activity.class);
                        startActivity(intent_home);
                        break;
                    case R.id.bottom_about:
                        Toast.makeText(Home_Activity.this, "Clicked About in Bottom", Toast.LENGTH_SHORT).show();
                        Intent intent_about=new Intent(getApplicationContext(),About_Activity.class);
                        startActivity(intent_about);
                        break;
                    case R.id.bottom_contact:
                        Toast.makeText(Home_Activity.this, "Clicked Contact in Bottom", Toast.LENGTH_SHORT).show();
                        Intent intent_contact=new Intent(getApplicationContext(),Contact_Activity.class);
                        startActivity(intent_contact);
                        break;

                    case R.id.bottom_share:
                        Intent shareintent=new Intent(Intent.ACTION_SEND);
                        shareintent.setType("text/plain");
                        shareintent.putExtra(Intent.EXTRA_SUBJECT ,"Your Application Link ");
                        shareintent.putExtra(Intent.EXTRA_TEXT,"Check your cool Application ");
                        startActivity(Intent.createChooser(shareintent,"Share via"));
                        break;

                }
                return false;
            }
        });
        //Bottom Navigation End


        //Top Navigation start

        navigationView=findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home_menu:
                        Toast.makeText(Home_Activity.this, "Clicked Home Page ", Toast.LENGTH_SHORT).show();
                        Intent homeintent=new Intent(getApplicationContext(),Home_Activity.class);
                        startActivity(homeintent);
                        break;

                    case R.id.about_menu:
                        Toast.makeText(Home_Activity.this, "Clicked About Page ", Toast.LENGTH_SHORT).show();
                        Intent aboutintent=new Intent(getApplicationContext(),About_Activity.class);
                        startActivity(aboutintent);
                        break;

                    case R.id.contact_menu:
                        Toast.makeText(Home_Activity.this, "Clicked contact  Page ", Toast.LENGTH_SHORT).show();
                        Intent conintent=new Intent(getApplicationContext(),Contact_Activity.class);
                        startActivity(conintent);
                        break;

                    case R.id.share_menu:
                        Intent shareintent=new Intent(Intent.ACTION_SEND);
                        shareintent.setType("text/plain");
                        shareintent.putExtra(Intent.EXTRA_TEXT,"https://www.facebook.com/");
                        shareintent.putExtra(Intent.EXTRA_SUBJECT,"Your Application link hare ");
                        startActivity(Intent.createChooser(shareintent,"share Via"));


                        break;
                }


                return false;
            }
        });

        //Top Navigation End


        final DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
}