package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard_activity extends AppCompatActivity {
    LinearLayout contact;
    LinearLayout message;
    LinearLayout mail;
    LinearLayout contact1;
    LinearLayout contact2;
    LinearLayout report;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        contact = (LinearLayout) findViewById(R.id.contact);
        message = (LinearLayout) findViewById(R.id.message);
        mail = (LinearLayout) findViewById(R.id.mail);


        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_activity.this,EmailActivity.class);
                startActivity(intent);
            }
        });


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_activity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact_activity();
            }
        });
    }
    public void Contact_activity(){
        Intent intent = new Intent(this,Contact_activity.class);
        startActivity(intent);
    }
}