package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Dashboard_activity extends AppCompatActivity {
    LinearLayout contact;
    LinearLayout message;
    LinearLayout mail;
    LinearLayout map;
    LinearLayout contact2;
    LinearLayout report;
    ImageView imagep;
    private static final int PICK_IMAGE =1;
    public Uri imageUri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        contact = (LinearLayout) findViewById(R.id.contact);
        message = (LinearLayout) findViewById(R.id.message);
        mail = (LinearLayout) findViewById(R.id.mail);
        imagep = findViewById(R.id.imagep);
        map = findViewById(R.id.map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_activity.this,MapActivity.class);
                startActivity(intent);
            }
        });

        imagep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery,"select picture"),PICK_IMAGE);
            }
        });

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
     protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
         imageUri = data.getData();
         imagep.setImageURI(imageUri);
        uploadpicture();
     }

    private void uploadpicture() {
    }


}