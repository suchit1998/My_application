package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreatemailActivity extends AppCompatActivity {
    private EditText name,mobileno,email,pass;
    private Button submit;



    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root  = db.getReference().child("user");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createmail);

        name = findViewById(R.id.name);
        mobileno = findViewById(R.id.mobileno);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        submit = findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Mobileno = mobileno.getText().toString();
                String Email = email.getText().toString();
                String Pass = pass.getText().toString();

                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("name", Name);
                userMap.put("mobileno", Mobileno);
                userMap.put("email", Email);
                userMap.put("pass", Pass);

                root.push().setValue(userMap);
                Intent intent = new Intent(CreatemailActivity.this,UserActivity.class);
                startActivity(intent);



            }
        });
    }
}