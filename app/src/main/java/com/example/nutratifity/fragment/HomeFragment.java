package com.example.nutratifity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nutratifity.R;

import java.time.LocalDate;

public class HomeFragment extends Fragment {

    private final LocalDate LOCAL_DATE = LocalDate.now();
    private TextView todayDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        todayDate = view.findViewById(R.id.today_date);

        setTodayDate();

        return view;
    }

    private void setTodayDate() {
        String day = LOCAL_DATE.getDayOfWeek().toString().substring(0, 3);
        String date = LOCAL_DATE.getDayOfMonth() + "";
        String month = LOCAL_DATE.getMonth().toString();
        todayDate.setText(day + ", " + date + " " + month);
    }


}