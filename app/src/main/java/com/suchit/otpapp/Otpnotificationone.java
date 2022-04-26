package com.suchit.otpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Optverification;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otpnotificationone extends AppCompatActivity {
    EditText entertain;
    EditText editText2;
    Button button;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpnotificationone);

        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);

        final ProgressBar progressbar = findViewById(R.id.progressbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText2.getText().toString().trim().isEmpty()){
                    if ((editText2.getText().toString().trim()).length() == 10){

                         progressbar.setVisibility(View.VISIBLE);
                         button.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + editText2.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                Otpnotificationone.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressbar.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressbar.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);
                                        Toast.makeText(Otpnotificationone.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressbar.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);

                                        Intent intent = new Intent(Otpnotificationone.this, Optverification.class);
                                        intent.putExtra("mobile",editText2.getText().toString());
                                        intent.putExtra("backendotp",backendotp);
                                        startActivity(intent);

                                    }
                                }
                        );

                        Intent intent = new Intent(Otpnotificationone.this, Optverification.class);
                        intent.putExtra("mobile",editText2.getText().toString());
                        startActivity(intent);
                    }else{
                        Toast.makeText(Otpnotificationone.this, "pls enter correct no", Toast.LENGTH_SHORT).show();
                    }
                    }else{
                    Toast.makeText(Otpnotificationone.this, "enter mobile no", Toast.LENGTH_SHORT).show();

                }
                }
            });
        }
    }

