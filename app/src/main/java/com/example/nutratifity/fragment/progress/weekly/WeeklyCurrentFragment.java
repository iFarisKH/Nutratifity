package com.example.nutratifity.fragment.progress.weekly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.nutratifity.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class WeeklyCurrentFragment extends Fragment {

    private LineChart lineChart;
    private LineData data;
    private LineDataSet lineDataSet;
    private ArrayList<Entry> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_current, container, false);

        lineChart = view.findViewById(R.id.current_week_chart);

        list.add(new Entry(0, 20));
        list.add(new Entry(1, 25));
        list.add(new Entry(2, 15));
        list.add(new Entry(4, 30));

        initLineDataSet();

        data = new LineData(lineDataSet);

        initLineChart();

        lineChart.setData(data);
        lineChart.invalidate();

        return view;
    }

    private void initLineChart() {

        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setTextColor(ContextCompat.getColor(getContext(), R.color.green));
        lineChart.setDescription(null);
        lineChart.getLegend().setEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setNoDataText("No Data Found");
        lineChart.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bacground_progress));

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setLabelCount(7, true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLinesBehindData(false);
        xAxis.setTextSize(10f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(6f);
        xAxis.setValueFormatter(new XaxisFormatter());

    }

    private void initLineDataSet() {

        lineDataSet = new LineDataSet(list, "Past Week");
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setCircleRadius(5.0f);
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setValueTextSize(0f);
        lineDataSet.setCircleColor(ContextCompat.getColor(getContext(), R.color.green));
        lineDataSet.setColor(ContextCompat.getColor(getContext(), R.color.green));

    }

    private class XaxisFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            String[] days = {"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"};
            return days[(int) value];
        }
    }
}