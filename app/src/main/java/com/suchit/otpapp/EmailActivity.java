package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailActivity extends AppCompatActivity {
    private Button forget_password,createmail,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        forget_password =  findViewById(R.id.forget_password);
        createmail = findViewById(R.id.createmail);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmailActivity.this,LoginemailActivity.class);
                startActivity(intent);
            }
        });



        createmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmailActivity.this,CreatemailActivity.class);
                startActivity(intent);



            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmailActivity.this,ForgetmailActivity.class);
                startActivity(intent);
            }
        });
    }





}