package com.example.compario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class searchA extends AppCompatActivity implements adapter.onItemClickListener {
    EditText searchedit;
    ImageButton back;
    RecyclerView recyclerView;

     ArrayList<itemlist> item = new ArrayList<>();
    adapter recycleradapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searcha);
        searchedit = findViewById(R.id.searchedit);
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.list);
        Intent ine = getIntent();
        String phone = ine.getStringExtra("phonenumber");
        String name = ine.getStringExtra("username");
        searchedit.setMaxLines(1);
        searchedit.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        item.add(new itemlist("redmi Note 12"));
        item.add(new itemlist("redmi A1+"));
        item.add(new itemlist("redmi 11prime"));
        item.add(new itemlist("redmi 10"));
        item.add(new itemlist("redmi 12C"));
        item.add(new itemlist("vivo T2X 5g"));
        item.add(new itemlist("vivo Y16"));
        item.add(new itemlist("vivo T1 44W"));
        item.add(new itemlist("vivo V27 pro5g"));
        item.add(new itemlist("vivo T1X"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleradapter = new adapter(this, item);
        recycleradapter.setOnItemClickListener(this);
        recyclerView.setAdapter(recycleradapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


        searchedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                Filter(s.toString());
            }
        });
    }
    public void Filter(String text) {
        ArrayList<itemlist> filtitem = new ArrayList<itemlist>();
        for (itemlist it : item) {
            if (it.getPhone().toLowerCase().contains(text.toLowerCase())) {
                filtitem.add(it);
            }
        }
        recycleradapter.filterlist(filtitem);

    }

@Override
public void onItemClick(int position){
    itemlist clickedItem = item.get(position);
    Intent intent = new Intent(searchA.this, rv2.class);
    intent.putExtra("phone", clickedItem.getPhone());
    startActivity(intent);
}
}