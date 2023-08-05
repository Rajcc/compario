package com.example.compario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class compariocreate2 extends AppCompatActivity {
    Button btnotp;
    EditText Textphone;
    CountryCodePicker contryp;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compariocreate2);
        btnotp= findViewById(R.id.btnotp);
        Textphone = findViewById(R.id.editTextPhone);
        contryp=findViewById(R.id.contryp);
        contryp.registerCarrierNumberEditText(Textphone);

        btnotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!contryp.isValidFullNumber()){
                    Toast.makeText(getApplicationContext(), "invalid phone number", Toast.LENGTH_SHORT).show();
                    return;


                } else {
                    Intent i=new Intent(compariocreate2.this,compariolog2.class);
                    i.putExtra("phone", contryp.getFullNumberWithPlus());
                    startActivity(i);

                }

            }
        });

    }
}