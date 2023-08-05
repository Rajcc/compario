package com.example.compario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.compario.model.usermodel;
import com.example.compario.util.firebaseutil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;

public class compariousername extends AppCompatActivity {
    EditText edittextuser;
    Button btnuser;
    String mobile,username;
    usermodel usermodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compariousername);
        edittextuser = findViewById(R.id.edittextuser);
        btnuser = findViewById(R.id.btnuser);
        Intent in=getIntent();
        String phonenumber = in.getStringExtra("phone");
        getusername();

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUsername();
            }

            void setUsername() {
                String name = edittextuser.getText().toString();
                if (name.isEmpty() || name.length() < 4) {
                    edittextuser.setError("username cannot less than 4 letters");
                    return;
                }
                if (usermodel != null) {
                    usermodel.setUsername(name);
                } else {
                    usermodel = new usermodel(mobile, name, Timestamp.now());
                }
                firebaseutil.currentUserDetails().set(usermodel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent tt=new Intent(compariousername.this,compario3.class);
                             tt.putExtra("username","name");
                            tt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                            startActivity(tt);
                        }
                    }
                });
            }

        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",edittextuser.getText().toString()); // "name" is the username entered by the user
        editor.apply();
    }
  public  void getusername() {
        firebaseutil.currentUserDetails().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                usermodel=  task.getResult().toObject(usermodel.class);
               if(usermodel!=null){
                   edittextuser.setText(usermodel.getUsername());
               }
                }
            }
        });
    }
}