package com.example.nutratifity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nutratifity.R;

public class DiaryFragment extends Fragment {

    private ImageView tomorrowView, yesterdayView;
    private LinearLayout breakfastBox;
    private TextView pageTitle, diaryFatText, diaryCarbText, diaryProtienText;
    private ProgressBar diaryCal, diaryFat, diaryCarb, diaryProtien;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        diaryCal = view.findViewById(R.id.diary_cal);
        diaryFat = view.findViewById(R.id.diary_fat);
        diaryCarb = view.findViewById(R.id.diary_carb);
        diaryProtien = view.findViewById(R.id.diary_protien);
        tomorrowView = view.findViewById(R.id.tomorrow);
        yesterdayView = view.findViewById(R.id.yesterday);
        breakfastBox = view.findViewById(R.id.breakfast_box);
        pageTitle = view.findViewById(R.id.diary_date);
        diaryFatText = view.findViewById(R.id.diary_fat_text);
        diaryCarbText = view.findViewById(R.id.diary_carb_text);
        diaryProtienText = view.findViewById(R.id.diary_protien_text);

        diaryCal.setProgress(25);
        diaryFat.setProgress(15);
        diaryCarb.setProgress(10);
        diaryProtien.setProgress(30);

        tomorrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageTitle.getText().toString().equalsIgnoreCase("Today")) {
                    pageTitle.setText("Tomorrow");
                    diaryCal.setProgress(0);
                    diaryFat.setProgress(0);
                    diaryCarb.setProgress(0);
                    diaryProtien.setProgress(0);
                    diaryFatText.setText("58g left");
                    diaryCarbText.setText("273g left");
                    diaryProtienText.setText("125g left");
                    breakfastBox.setVisibility(View.GONE);
                    tomorrowView.setVisibility(View.INVISIBLE);
                }
            }
        });

        yesterdayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageTitle.getText().toString().equalsIgnoreCase("Tomorrow")) {
                    pageTitle.setText("Today");
                    diaryCal.setProgress(25);
                    diaryFat.setProgress(15);
                    diaryCarb.setProgress(10);
                    diaryProtien.setProgress(30);
                    diaryFatText.setText("47g left");
                    diaryCarbText.setText("271.9 left");
                    diaryProtienText.setText("112 left");
                    breakfastBox.setVisibility(View.VISIBLE);
                    tomorrowView.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}