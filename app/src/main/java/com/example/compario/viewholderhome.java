package com.example.compario;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholderhome extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView txtitemname,itemrate2,itemrate1,itembrand1,itembrand2;
    ImageView itemimage;
    private adapterhome.onItemClickListener listener;
    public viewholderhome(@NonNull View itemView, adapter.onItemClickListener listener) {
        super(itemView);
        itemimage=itemView.findViewById(R.id.itemimage);
        txtitemname=itemView.findViewById(R.id.txtitemname);
        itemrate1=itemView.findViewById(R.id.itemrate1);
        itemrate2=itemView.findViewById(R.id.itemrate2);
        itembrand1=itemView.findViewById(R.id.itembrand1);
        itembrand2=itemView.findViewById(R.id.itembrand2);
        this.listener= this.listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


    }
}
