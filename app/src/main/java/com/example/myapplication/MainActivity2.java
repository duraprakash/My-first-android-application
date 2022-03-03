package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    // 1.1 initial variable
    Button login, signup;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 1.2 assigning id to variables
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignUp);
        skip = findViewById(R.id.tvSkip);

        // 1.3 perform action when clicked
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 1.4 go to login activity
//                Toast.makeText(MainActivity2.this, "Login Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, Login_Activity.class);
                startActivity(intent);
            }
        });

        // 1.5 perform action when clicked
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 1.6 go to signup activity
                Intent intent = new Intent(MainActivity2.this, SignUp_Activity.class);
                startActivity(intent);
            }
        });

        // 1.7 perform action when clicked
        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 1.8 go to another dashboard activity
                // todo
                Toast.makeText(MainActivity2.this, "Skipped", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, List_Activity.class);
                startActivity(intent);
            }
        });

    }
}