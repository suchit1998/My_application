package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


public class Contact_activity extends AppCompatActivity {
    RecyclerView com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact2);
        com = findViewById(R.id.com);
        com.setLayoutManager(new LinearLayoutManager(this));

        String members[]={"A","B","C","D","E","f","G","H","I"};
        com.setAdapter(new Adpter(members));
    }
}