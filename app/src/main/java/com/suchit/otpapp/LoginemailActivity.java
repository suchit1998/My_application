package com.suchit.otpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class LoginemailActivity extends AppCompatActivity {

    Button sendBtn;
    EditText emailaddress,subject,message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginemail);


        sendBtn =findViewById(R.id.sendBtn);
        emailaddress = findViewById(R.id.emailaddress);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }
    private void sendMail(){
        String recipientList = emailaddress.getText().toString();
        String[] recipients = recipientList.split(",");

        String Subject = subject.getText().toString();
        String Message = message.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
        intent.putExtra(Intent.EXTRA_TEXT, Message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choice the mail client"));
    }
}