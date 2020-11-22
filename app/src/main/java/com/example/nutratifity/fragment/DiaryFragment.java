package com.example.nutratifity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nutratifity.R;

public class DiaryFragment extends Fragment {
    private View yesterdayBtn;
    private View tomorrowBtn;
    private View lunch;
    private View water;
    private TextView diaryDate;
    private ProgressBar diaryCal;
    private ProgressBar diaryFatBar;
    private ProgressBar diaryCarbBar;
    private ProgressBar diaryProtBar;
    private TextView diaryFatTxt;
    private TextView diaryCarbTxt;
    private TextView diaryProtTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        yesterdayBtn = view.findViewById(R.id.yesterday);
        tomorrowBtn = view.findViewById(R.id.tomorrow);
        lunch = view.findViewById(R.id.lunch_burger);
        water = view.findViewById(R.id.water_bottle);
        diaryDate = (TextView)view.findViewById(R.id.diary_date);
        diaryCal = (ProgressBar) view.findViewById(R.id.diary_cal);
        diaryFatBar = (ProgressBar) view.findViewById(R.id.diary_fat);
        diaryCarbBar = (ProgressBar) view.findViewById(R.id.diary_carb);
        diaryProtBar = (ProgressBar) view.findViewById(R.id.diary_protien);
        diaryFatTxt = (TextView) view.findViewById(R.id.diary_fat_txt);
        diaryCarbTxt = (TextView) view.findViewById(R.id.diary_carb_txt);
        diaryProtTxt = (TextView) view.findViewById(R.id.diary_protien_txt);

        yesterdayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lunch.setVisibility(View.VISIBLE);
                water.setVisibility(View.VISIBLE);
                diaryDate.setText("Yesterday");
                diaryFatTxt.setText("8g left");
                diaryCarbTxt.setText("210.9g left");
                diaryProtTxt.setText("72g left");
                diaryCal.setProgress(50);
                diaryFatBar.setProgress(90);
                diaryCarbBar.setProgress(15);
                diaryProtBar.setProgress(30);
                yesterdayBtn.setVisibility(View.GONE);

                tomorrowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lunch.setVisibility(View.GONE);
                        water.setVisibility(View.GONE);
                        diaryDate.setText("Today");
                        diaryFatTxt.setText("47g left");
                        diaryCarbTxt.setText("271.9g left");
                        diaryProtTxt.setText("112g left");
                        diaryCal.setProgress(20);
                        diaryFatBar.setProgress(10);
                        diaryCarbBar.setProgress(5);
                        diaryProtBar.setProgress(20);
                        yesterdayBtn.setVisibility(View.VISIBLE);
                    }
                });

            }
        });


        return view;
    }
}