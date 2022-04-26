package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tp_Activity extends AppCompatActivity {
    Button sign_in;
    Button sign_up;
    EditText username;
    EditText password;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp);
        context = Tp_Activity.this;

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sign_in = findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent g = new Intent(Tp_Activity.this, Otpnotificationone.class);
                    startActivity(g);
                }


            }
        );

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("suchit") && password.getText().toString().equals("suchit")) {


                    Intent g = new Intent(Tp_Activity.this, Dashboard_activity.class);
                    startActivity(g);
                    finish();
                } else {
                    Toast.makeText(context, "wrong", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}


