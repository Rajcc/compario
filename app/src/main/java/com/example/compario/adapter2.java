package com.example.compario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter2 extends RecyclerView.Adapter<viewholder2> {
    Context context;
    List<itemlist2> item2;

    public adapter2(Context context, List<itemlist2> item2) {
        this.context = context;
        this.item2 = item2;
    }

    @NonNull
    @Override
    public viewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview2 = LayoutInflater.from(context).inflate(R.layout.itemview2, parent, false);
        return new viewholder2(itemview2);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder2 holder, int position) {
        holder.txtphname.setText(item2.get(position).getPhone2());
        holder.rate1.setText(item2.get(position).rate1);
        holder.rate2.setText(item2.get(position).rate2);
        holder.imageph.setImageResource(item2.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    String clickedPhone = item2.get(holder.getAdapterPosition()).getPhone2();

                    moveItemToTop(clickedPosition);

                    // Notify the adapter that the data has changed and the list should be updated
                    notifyDataSetChanged();
                }
            }

            private void moveItemToTop(int clickedPosition) {
                if (clickedPosition > 0 && clickedPosition < item2.size()) {
                    itemlist2 clickedItem = item2.get(clickedPosition);
                    item2.remove(clickedPosition);
                    item2.add(0, clickedItem);
                }

            }
        });
    }

        @Override
        public int getItemCount () {

            return item2.size();
        }
    }


