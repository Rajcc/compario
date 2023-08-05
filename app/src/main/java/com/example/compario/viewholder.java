package com.example.compario;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textitem;
    private adapter.onItemClickListener listener;
    public viewholder(@NonNull View itemView, adapter.onItemClickListener listener) {
        super(itemView);
        textitem = itemView.findViewById(R.id.txtitem);
        this.listener= listener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            int position=getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position);
            }
        }
    }
}
