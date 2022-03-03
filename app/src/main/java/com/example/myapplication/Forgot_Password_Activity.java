package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password_Activity extends AppCompatActivity {

    // 1.0 initial variable
    private Button btn_reset;
    private EditText txt_email;
    private ImageView imgV_backArrow;
    private String email;

    // 2.1 declare firebase authentication object variable
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password_);

        // 1.2 assign id to variable
        btn_reset = findViewById(R.id.btnReset);
        txt_email = findViewById(R.id.txtEmail);
        imgV_backArrow = findViewById(R.id.imgBackArrow);
        // 2.2 obtain the firebase instance
        mAuth = mAuth.getInstance();

        // 1.3 perform action on click
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Forgot_Password_Activity.this, "Password reset link is sent to your phone.", Toast.LENGTH_SHORT).show();
                // 3.1 calling function
                // 2.3 firebase reset password
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Forgot_Password_Activity.this, "Check Your Email.", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(Forgot_Password_Activity.this,Login_Activity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(Forgot_Password_Activity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                validateData();
            }
        });

        imgV_backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forgot_Password_Activity.this, SignUp_Activity.class);
                startActivity(intent);

            }
        });


    }

    // 3.2 function
    private void validateData() {
        // 3.3 get the text
        String email = txt_email.getText().toString().trim();
        // 3.4 validation
        if(email.isEmpty()){
            txt_email.setError("Required Email ID");
        }
        else{
            ForgotPassword();
        }
    }

    // 3.5 function
    private void ForgotPassword() {

        // 2.3 firebase reset password
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Forgot_Password_Activity.this, "Check Your Email.", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Forgot_Password_Activity.this,Login_Activity.class));
                    finish();
                } else {
                    Toast.makeText(Forgot_Password_Activity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}