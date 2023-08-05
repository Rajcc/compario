package com.example.compario;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment implements adapterhome.onItemClickListener {
    RecyclerView recyclehome;
    private adapterhome adapterhome;
    private List<itemlisthome> itemhome = new ArrayList<itemlisthome>();


    public home() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_home,container,false);
        recyclehome=view.findViewById(R.id.recyclehome);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterhome = new adapterhome(itemhome);
        adapterhome.setOnItemClickLiatener(this);
        recyclehome.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclehome.setAdapter(adapterhome);
        itemhome.add(new itemlisthome("oppo A77s","16,499","16,499",R.drawable.oppoa77s));
        itemhome.add(new itemlisthome("oppo A17","12,499","12,400",R.drawable.oppoa17));
        itemhome.add(new itemlisthome("oppo Reno 10pro 5g","32,999","32,499",R.drawable.opporeno5g));
        itemhome.add(new itemlisthome("oppo A78 5g","18,999","18,130",R.drawable.oppoa785g));
        itemhome.add(new itemlisthome("oppo  f21 pro","19,999","20,999",R.drawable.oppof21pro));
        itemhome.add(new itemlisthome("Samsung Galaxy f13","9,499","10,999",R.drawable.samsunggalaxyf13));
        itemhome.add(new itemlisthome("Samsung Galaxy f14 5g","17,499","14,990",R.drawable.samsunggalaxyf145g));
        itemhome.add(new itemlisthome("Samsung Galaxy f23 5g","13,999","16,999",R.drawable.samsunggalaxyf235g));
        itemhome.add(new itemlisthome("Samsung Galaxy s23 ultra 5g","1,34,999","1,24,999",R.drawable.samsunggalaxys23ultra5g));
        itemhome.add(new itemlisthome("Samsung Galaxy s22 ultra 5g","94,999","87,800",R.drawable.samsunggalaxys22ultra5g));
        adapterhome.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        itemlisthome clickedItem = itemhome.get(position);
        Intent intent3 = new Intent(requireContext(),rv2.class);
        startActivity(intent3);

    }

}









