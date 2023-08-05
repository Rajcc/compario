package com.example.compario;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtphname, rate2, rate1, brand1, brand2;
    ImageView imageph;
    private adapter.onItemClickListener listener;

    public viewholder2(@NonNull View itemView) {
        super(itemView);
        imageph = itemView.findViewById(R.id.imageph);
        txtphname = itemView.findViewById(R.id.txtphname);
        rate1 = itemView.findViewById(R.id.rate1);
        rate2 = itemView.findViewById(R.id.rate2);
        brand1 = itemView.findViewById(R.id.brand1);
        brand2 = itemView.findViewById(R.id.brand2);
        this.listener = listener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position);

            }
        }
    }
}

