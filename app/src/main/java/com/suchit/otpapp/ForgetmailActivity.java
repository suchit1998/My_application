package com.suchit.otpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetmailActivity extends AppCompatActivity {
    EditText emailaddress;
    Button reserpassword;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetmail);

        emailaddress = findViewById(R.id.emailaddress);
        reserpassword = findViewById(R.id.reserpassword);


        reserpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailaddress.getText().toString();



                if (email.isEmpty()){
                    Toast.makeText(ForgetmailActivity.this, "please provide your mail", Toast.LENGTH_SHORT).show();
                }else {
                    forgetmailpassword();
                }
            }
        });

    }
    private void forgetmailpassword(){
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetmailActivity.this, "check your mail", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgetmailActivity.this, LoginemailActivity.class));
                    finish();
                }else {
                    Toast.makeText(ForgetmailActivity.this, "error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}