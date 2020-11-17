package com.example.nutratifity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nutratifity.R;
import com.example.nutratifity.adapter.HomeAdapter;
import com.example.nutratifity.helper.HomeHelper;

import java.time.LocalDate;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private final LocalDate LOCAL_DATE = LocalDate.now();
    private TextView todayDate;
    private RecyclerView homeRecycle;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        todayDate = view.findViewById(R.id.today_date);
        homeRecycle = view.findViewById(R.id.recycle_home);

        setTodayDate();
        homeRecycle();

        return view;
    }

    private void homeRecycle() {

        homeRecycle.setHasFixedSize(true);
        homeRecycle.setLayoutManager(
                new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );

        ArrayList<HomeHelper> homeHelpers = new ArrayList<>();

        homeHelpers.add(new HomeHelper(
                "BREAKFAST",
                "Egg",
                "155 cal",
                "9:00 AM"
        ));

        homeHelpers.add(new HomeHelper(
                "BREAKFAST",
                "Egg",
                "155 cal",
                "9:00 AM"
        ));

        homeHelpers.add(new HomeHelper(
                "BREAKFAST",
                "Egg",
                "155 cal",
                "9:00 AM"
        ));

        adapter = new HomeAdapter(homeHelpers);

        homeRecycle.setAdapter(adapter);

    }

    private void setTodayDate() {
        String day = LOCAL_DATE.getDayOfWeek().toString().substring(0, 3);
        String date = LOCAL_DATE.getDayOfMonth() + "";
        String month = LOCAL_DATE.getMonth().toString();
        todayDate.setText(day + ", " + date + " " + month);
    }


}