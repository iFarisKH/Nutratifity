package com.example.nutratifity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class ReviewMealActivity extends AppCompatActivity {

    private PieChart pieChart;
    private TextView timePick;
    private int h, m;
    private SwitchCompat switchCompat;
    private TextInputLayout textInputLayout;
    private Button confirm, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_meal);

        pieChart = findViewById(R.id.chart);
        timePick = findViewById(R.id.time_pick);
        switchCompat = findViewById(R.id.switch_state);
        textInputLayout = findViewById(R.id.creted_meal_name);
        confirm = findViewById(R.id.confirm);
        cancel = findViewById(R.id.cancel);

        initChart();

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) textInputLayout.setVisibility(View.VISIBLE);
                else textInputLayout.setVisibility(View.INVISIBLE);
            }
        });

        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        ReviewMealActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                h = hourOfDay;
                                m = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, h, m);
                                timePick.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReviewMealActivity.this, MainActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReviewMealActivity.this, AddMealActivity.class));
            }
        });
    }

    private void initChart() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(30.24f, "Protein"));
        pieEntries.add(new PieEntry(2.52f, "Carb"));
        pieEntries.add(new PieEntry(25.2f, "Fat"));
        pieEntries.add(new PieEntry(302.04f, "Other"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        int[] colors = {
                Color.parseColor("#E13F3F"),
                Color.parseColor("#909D41"),
                Color.parseColor("#8197E5"),
                Color.parseColor("#62901B")
        };

        pieDataSet.setColors(colors);
        pieDataSet.setDrawValues(false);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        pieChart.setDrawEntryLabels(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Total 155\nCalories");
        pieChart.animate();

    }
}