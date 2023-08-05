package com.example.compario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.ktx.Firebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class compariolog2 extends AppCompatActivity {
    ImageView imageview2;
    Long timeoutseconds = 60L;
    String verificationCode;
    PhoneAuthProvider.ForceResendingToken ResendingToken;

    EditText edittextotp;
    Button btnsign;
    ProgressBar prg;
    FirebaseAuth mauth = FirebaseAuth.getInstance();
    String phonenumber;
    TextView txtresend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compariolog2);
        edittextotp = findViewById(R.id.edittextotp);
        btnsign = findViewById(R.id.btnsign);
        prg = findViewById(R.id.progressBar);
        txtresend=findViewById(R.id.txtresend);
        phonenumber = getIntent().getExtras().getString("phone");
        sendOtp(phonenumber, false);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredotp = edittextotp.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, enteredotp);
                signin(credential);


            }
        });
    }

    void sendOtp(String phonenumber, boolean isResend) {
        setInProgress(true);

        PhoneAuthOptions.Builder builder =
                PhoneAuthOptions.newBuilder(mauth)
                        .setPhoneNumber(phonenumber)
                        .setTimeout(timeoutseconds, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signin(phoneAuthCredential);
                                setInProgress(false);


                            }


                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(getApplicationContext(), "otp verification failed", Toast.LENGTH_SHORT).show();
                                setInProgress(false);
                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                                verificationCode = s;
                                ResendingToken = forceResendingToken;
                                Toast.makeText(getApplicationContext(), "otp verification success", Toast.LENGTH_SHORT).show();
                                setInProgress(false);

                            }
                        });
        if (isResend) {
            PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(ResendingToken).build());
        } else {
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
        }
    }

     void setInProgress(boolean inProgress) {
        if(inProgress){
            prg.setVisibility(View.VISIBLE);

        }else{ prg.setVisibility(View.GONE);}

    }

    private void signin(PhoneAuthCredential phoneAuthCredential) {
        mauth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent in=new Intent(compariolog2.this,compariousername.class);
                    in.putExtra("phonenumber","phone");
                    startActivity(in);

                }else{
                    Toast.makeText(getApplicationContext(), "signin failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}