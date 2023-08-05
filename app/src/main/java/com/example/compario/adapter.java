package com.example.compario;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<viewholder> {
    Context context;
    List<itemlist> item;
    public interface onItemClickListener{
        void onItemClick(int position);
    }
    private onItemClickListener listener;
    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener=listener;
    }
    public adapter(Context context, List<itemlist> item) {
        this.context = context;
        this.item = item;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.itemview, parent, false);
        return new viewholder(itemview,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.textitem.setText(item.get(position).getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    int position= holder.getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return item.size();
    }

    public void filterlist(ArrayList<itemlist> filtitem) {
        item = filtitem;
        notifyDataSetChanged();
    }

}





