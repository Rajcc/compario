package com.example.compario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rv2 extends AppCompatActivity {
RecyclerView recycle2;
ImageButton back2;
adapter2 recycleradapter2;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String CLICKED_PHONE_KEY = "clickedPhone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv2);
        recycle2=findViewById(R.id.recycle2);
        back2=findViewById(R.id.back2);
        Intent itt=getIntent();
        String filteredPhone = getIntent().getStringExtra("filteredPhone");
        List<itemlist2> item2= new ArrayList<itemlist2>();
        item2.add(new itemlist2("redmi Note 12","16,999","13,999",R.drawable.redminote12));
        item2.add(new itemlist2("redmi A1+","6,299","6,599",R.drawable.redmia1plus));
        item2.add(new itemlist2("redmi 11prime","12,999","10,749",R.drawable.redmi11prime));
        item2.add(new itemlist2("redmi 10","12,499","10,999",R.drawable.redmi10));
        item2.add(new itemlist2("redmi 12C","8,499","8,870",R.drawable.redmi12c));
        item2.add(new itemlist2("vivo T2X 5g","12,999","13,999",R.drawable.vivot2x5g));
        item2.add(new itemlist2("vivo Y16","12,999","10,499",R.drawable.vivoy16));
        item2.add(new itemlist2("vivo T1 44W","16,899","14,499",R.drawable.vivot144w));
        item2.add(new itemlist2("vivo V27 pro5g","37,990","42,999",R.drawable.vivov27pro5g));
        item2.add(new itemlist2("vivo T1X","11,999","14,999",R.drawable.vivot1x));
        Intent intent = getIntent();
        String clickedPhone = intent.getStringExtra("phone");
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CLICKED_PHONE_KEY, clickedPhone);
        editor.apply();
        Collections.sort(item2, new Comparator<itemlist2>() {
            @Override
            public int compare(itemlist2 item1, itemlist2 item2) {
                    String storedPhone = preferences.getString(CLICKED_PHONE_KEY, "");
                    if (item1.getPhone2().equals(storedPhone)) {
                        return -1;
                    } else if (item2.getPhone2().equals(storedPhone)) {
                        return 1;
                    }
                    return 0;
                }
            });

recycle2.setLayoutManager(new LinearLayoutManager(this));
        recycleradapter2=new adapter2(getApplicationContext(),item2);
        recycle2.setAdapter(recycleradapter2);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }

        });

        }
    }
