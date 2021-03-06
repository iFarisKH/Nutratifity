package com.example.nutratifity.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutratifity.R;
import com.example.nutratifity.fragment.progress.AllTimeFragment;
import com.example.nutratifity.fragment.progress.MonthlyFragment;
import com.example.nutratifity.fragment.progress.WeeklyFragment;
import com.google.android.material.tabs.TabLayout;

public class ProgressFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().beginTransaction().replace(
                R.id.container_time,
                new WeeklyFragment()
        ).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        tabLayout = view.findViewById(R.id.tab_main_progress);

        tabLayout.addOnTabSelectedListener(this);

        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment selectFragment = null;
        switch (tab.getPosition()) {
            case 0:
                selectFragment = new WeeklyFragment();
                break;
            case 1:
                selectFragment = new MonthlyFragment();
                break;
            case 2:
                selectFragment = new AllTimeFragment();
                break;
        }
        getChildFragmentManager().beginTransaction().replace(
                R.id.container_time,
                selectFragment
        ).commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}