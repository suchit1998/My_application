package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    EditText phone_no,message;
    Button send,select_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        phone_no = findViewById(R.id.phone_no);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);
        select_NO = findViewById(R.id.select_No);


        select_NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                        sendSMS();
                    }else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }

            }
        });
    }
        private void sendSMS(){
            String phoneNo =phone_no.getText().toString().trim();
            String Sms =message.getText().toString().trim();

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo,null,Sms,null,null);
                Toast.makeText(this, "message sent", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
