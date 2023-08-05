package com.example.compario;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class account extends Fragment {
    TextView accuser, contact;
    public account() {
    }

    public static account newInstance(String username) {
        account accountFragment = new account();
        Bundle args = new Bundle();
        args.putString("username", username);
        accountFragment.setArguments(args);
        return accountFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        accuser = view.findViewById(R.id.accuser);
        contact = view.findViewById(R.id.contact);
        Bundle args = getArguments();
        if (args != null) {
            String username = args.getString("username");
            accuser.setText(username);
        } else {
            accuser.setText("NOUsername");
        }

        return view;
    }
}
