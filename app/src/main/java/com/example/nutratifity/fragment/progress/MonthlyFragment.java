package com.example.nutratifity.fragment.progress;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutratifity.R;
import com.example.nutratifity.fragment.progress.monthly.MonthlyCurrentFragment;
import com.example.nutratifity.fragment.progress.monthly.MonthlyPastFragment;
import com.example.nutratifity.fragment.progress.weekly.WeeklyCurrentFragment;
import com.example.nutratifity.fragment.progress.weekly.WeeklyPastFragment;
import com.google.android.material.tabs.TabLayout;

public class MonthlyFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().beginTransaction().replace(
                R.id.container_monthly_progress,
                new MonthlyPastFragment()
        ).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monthly, container, false);

        tabLayout = view.findViewById(R.id.tab_monthly_progress);
        tabLayout.addOnTabSelectedListener(this);

        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment selectFragment = null;
        switch (tab.getPosition()) {
            case 0:
                selectFragment = new MonthlyPastFragment();
                break;
            case 1:
                selectFragment = new MonthlyCurrentFragment();
                break;
        }
        getChildFragmentManager().beginTransaction().replace(
                R.id.container_monthly_progress,
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