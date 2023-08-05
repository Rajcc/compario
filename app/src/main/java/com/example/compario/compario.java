package com.example.compario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class compario extends AppCompatActivity {
    ImageButton imageview1;
    Button btnstart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compario);

        btnstart = findViewById(R.id.btnstart);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencompariocreate2();
            }
        });
    }

    public void opencompariocreate2() {
        Intent r = new Intent(compario.this, compariocreate2.class);
        startActivity(r);


    }
}