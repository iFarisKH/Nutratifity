package com.example.nutratifity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.nutratifity.R;


public class ProfileFragment extends Fragment {

    private ImageView returnIc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        returnIc = view.findViewById(R.id.return_ic);

        returnIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(
                        R.id.fragment_container,
                        new MoreFragment()
                ).commit();
            }
        });

        return view;
    }
}