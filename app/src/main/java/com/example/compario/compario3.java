package com.example.compario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Scroller;
import android.widget.SearchView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputLayout;

public class compario3 extends AppCompatActivity {
    EditText txtin;
    String user, p;
    BottomNavigationView btnnav;
    home homefragment;
    TextView txthome;
    ImageButton searchst;

    account accountfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compario3);
        homefragment = new home();
        accountfragment = new account();
        btnnav = findViewById(R.id.btnnav);
        searchst = findViewById(R.id.searchst);
        txthome = findViewById(R.id.txthome);
        Intent tt = getIntent();
        String username = tt.getStringExtra("name");
        btnnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homefragment).commit();

                }
                if (item.getItemId() == R.id.account) {
                    account accountFragment = account.newInstance(username);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, accountfragment).commit();
                }
                return true;
            }
        });
        btnnav.setSelectedItemId(R.id.home);
        searchst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ine = new Intent(compario3.this, searchA.class);
                startActivity(ine);
            }
        });
    }
}
