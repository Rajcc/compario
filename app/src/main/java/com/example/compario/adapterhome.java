package com.example.compario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterhome extends RecyclerView.Adapter<viewholderhome> {
    Context context;
    List<itemlisthome> itemhome;



    public interface onItemClickListener extends adapter.onItemClickListener {
        void onItemClick(int position);
    }
    private onItemClickListener listener;
    public void setOnItemClickLiatener(onItemClickListener listener) {
        this.listener=listener;
    }
    public adapterhome(List<itemlisthome> itemhome) {
        this.itemhome = itemhome;
    }

    @NonNull
    @Override
    public viewholderhome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemviewhome = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemviewhome, parent, false);
        return new viewholderhome(itemviewhome, (adapterhome.onItemClickListener) listener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderhome holder, int position) {
        holder.itemrate1.setText(itemhome.get(position).rate1home);
        holder.itemrate2.setText(itemhome.get(position).rate2home);
        holder.txtitemname.setText(itemhome.get(position).itemhome);
        holder.itemimage.setImageResource(itemhome.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    int position=holder.getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }

            }
        });


    }

    @Override
    public int getItemCount() {

        return itemhome.size();
    }



}