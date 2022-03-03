package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    // 1.1 initial variables
    Button btn_login;
    TextView txt_email, txt_password, txt_forgotPassword, txt_facebook, txt_google, txt_haveNoAccount;

    // 2.1 declare firebase authentication object variable
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        // Transparent ActionBar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        // 1.2 assigning id to variables
        btn_login = findViewById(R.id.btnLogin);
        txt_email = findViewById(R.id.txtEmail);
        txt_password = findViewById(R.id.txtPassword);
        txt_forgotPassword = findViewById(R.id.txtForgotPassword);
        txt_facebook = findViewById(R.id.tvFacebook);
        txt_google = findViewById(R.id.tvGoogle);
        txt_haveNoAccount = findViewById(R.id.tvNoAccount);

        // 2.2 obtain the firebase instance
        mAuth = mAuth.getInstance();

        // 1.3 perform action when clicked
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Login_Activity.this,"Login button clicked!",Toast.LENGTH_SHORT).show();
                // 3.1 get text and store
                String email = txt_email.getText().toString().trim();
                String password = txt_password.getText().toString().trim();
                // 3.2 validation test
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login_Activity.this, "Please enter your email.", Toast.LENGTH_SHORT).show();
                    txt_email.setError("Required Email");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login_Activity.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                    txt_password.setError("Required Password");
                    return;
                }
                // 2.3 firebase login with email and password
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),Login_Activity.class));
                            Toast.makeText(Login_Activity.this, "Congrats! Login Completed.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Login_Activity.this, "Sorry, your Login Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        txt_forgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//
//                Intent intent = new Intent(Login_Activity.this, Forgot_Password_Activity.class);
//                startActivity(intent);

                // if intent doesn't work then use dialog box
                EditText resetEmail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your email to receive reset link.");
                passwordResetDialog.setView(resetEmail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // extract the email and send reset link
                        String  mail = resetEmail.getText().toString().trim();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Login_Activity.this, "Reset link sent to your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login_Activity.this, "Error! Reset link is not sent." +e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // close the dialog
                    }
                });

                passwordResetDialog.show();


            }
        });

        txt_facebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Login_Activity.this,"Facebook form!",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Login_Activity.this, SignUp_Activity.class);
//                startActivity(intent);
                // TODO
            }
        });

        txt_google.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Login_Activity.this,"Google Form!",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Login_Activity.this, SignUp_Activity.class);
//                startActivity(intent);
                // TODO
            }
        });

        txt_haveNoAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Login_Activity.this,"Taking you to sign up form!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_Activity.this, SignUp_Activity.class);
                startActivity(intent);
            }
        });


    }
}