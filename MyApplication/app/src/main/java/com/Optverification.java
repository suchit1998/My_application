package com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.suchit.otpapp.R;
import com.suchit.otpapp.Tp_Activity;

import java.util.concurrent.TimeUnit;

public class Optverification extends AppCompatActivity {

    EditText inputnumber1, inputnumber2, inputnumber3, inputnumber4, inputnumber5, inputnumber6;
    String getotpbacked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optverification);
        final Button verficationonclick = findViewById(R.id.buttongetotp);

        inputnumber1 = findViewById(R.id.inputot1);
        inputnumber2 = findViewById(R.id.inputot2);
        inputnumber3 = findViewById(R.id.inputot3);
        inputnumber4 = findViewById(R.id.inputot4);
        inputnumber5 = findViewById(R.id.inputot5);
        inputnumber6 = findViewById(R.id.inputot6);

        TextView textView = findViewById(R.id.textview14);
        textView.setText(String.format(
                "+91-@s", getIntent().getStringArrayExtra("mobile")
        ));

        getotpbacked = getIntent().getStringExtra("backendotp");

        final ProgressBar progressBarifyotp = findViewById(R.id.progressbar);

        verficationonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entercodeotp = inputnumber1.getText().toString() +
                        inputnumber2.getText().toString() +
                        inputnumber3.getText().toString() +
                        inputnumber4.getText().toString() +
                        inputnumber5.getText().toString() +
                        inputnumber6.getText().toString();
                if (getotpbacked != null) {
                    progressBarifyotp.setVisibility(View.VISIBLE);
                    verficationonclick.setVisibility(View.INVISIBLE);

                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            getotpbacked, entercodeotp
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBarifyotp.setVisibility(View.GONE);
                                    verficationonclick.setVisibility(View.VISIBLE);

                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), Tp_Activity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(Optverification  .this, "enter the correct otp", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                } else {
                    Toast.makeText(Optverification.this, "Plese check internet connection", Toast.LENGTH_SHORT).show();
                }

                    if (!inputnumber1.getText().toString().trim().isEmpty() && !inputnumber2.getText().toString().trim().isEmpty() && !inputnumber3.getText().toString().trim().isEmpty() && !inputnumber4.getText().toString().trim().isEmpty() && !inputnumber5.getText().toString().trim().isEmpty() && !inputnumber6.getText().toString().trim().isEmpty())
                {


                    Toast.makeText(Optverification.this, "Otp verify", Toast.LENGTH_SHORT).show();
                }
            else{


                    Toast.makeText(Optverification.this, "please enter mobile number", Toast.LENGTH_SHORT).show();
                }

            }
        });
        TextView resetlebel1 = findViewById(R.id.resendOtp);

        resetlebel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        Optverification.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(Optverification.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                            getotpbacked = newbackendotp;
                                Toast.makeText(Optverification.this, "succesfully otp", Toast.LENGTH_SHORT).show();
                            }
                        }
                );

            }
        });

    }

    private void numberOtpMove() {
        inputnumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
        inputnumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
        inputnumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
        inputnumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
        inputnumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
        inputnumber6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputnumber6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });
    }

}