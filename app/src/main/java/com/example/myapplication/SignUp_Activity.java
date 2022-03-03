package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Activity extends AppCompatActivity {

    // 1.1 initial variables
    Button btn_register;
    TextView txt_fullName, txt_phone, txt_email, txt_username, txt_password, txt_confirmPassword, txt_haveAccount; // ,txt_facebook, txt_google;

    // 4.1 declare firebase authentication object variable
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        // Transparent ActionBar
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        );

        // 1.2 assigning id to variables
        btn_register = findViewById(R.id.btnRegister);
        txt_fullName = findViewById(R.id.txtFullName);
        txt_phone = findViewById(R.id.txtPhone);
        txt_email = findViewById(R.id.txtEmail);
        txt_username = findViewById(R.id.txtUsername);
        txt_password = findViewById(R.id.txtPassword);
        txt_confirmPassword = findViewById(R.id.txtConfirmPassword);
//        txt_facebook = findViewById(R.id.tvFacebook);
//        txt_google = findViewById(R.id.tvGoogle);
        txt_haveAccount = findViewById(R.id.tvHaveAccount);
        // 4.2 obtain the firebase instance
        firebaseAuth = FirebaseAuth.getInstance();

        // from here https://developer.android.com/guide/topics/ui/controls/spinner#java
        // 2.1 spinner assigning id to variable
        Spinner spinner = (Spinner) findViewById(R.id.gender_spinner);
        // 2.2 Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // 2.3 Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 2.4 Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // 1.3 perform action when clicked
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(SignUp_Activity.this,"Register button clicked!",Toast.LENGTH_SHORT).show();
                // 3.1 get text and store
                String fullName = txt_fullName.getText().toString().trim();
                String phone = txt_phone.getText().toString().trim();
                String email = txt_email.getText().toString().trim();
                String username = txt_username.getText().toString().trim();
                String password = txt_password.getText().toString().trim();
                String confirmPassword = txt_confirmPassword.getText().toString().trim();
                // 3.2 validation test
                if(TextUtils.isEmpty(fullName)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your full name.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your phone number.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your email.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your username.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(SignUp_Activity.this, "Please enter your confirm password.", Toast.LENGTH_SHORT).show();
                }
                // 3.3 password length
                if(password.length()<6){
                    Toast.makeText(SignUp_Activity.this, "Your password must be 6 character long.", Toast.LENGTH_SHORT).show();
                }
                // 3.4 confirm password match
                if(password.equals(confirmPassword)){
                    // 4.3 firebase create user account
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp_Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),Login_Activity.class));
                                Toast.makeText(SignUp_Activity.this, "Congrats! Signup Completed.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(SignUp_Activity.this, "Sorry, your Signup Failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        // 1.4 perform action when clicked
        txt_haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });

    }
}