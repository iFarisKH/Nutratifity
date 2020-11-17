package com.example.nutratifity.fragment.progress;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutratifity.R;
import com.example.nutratifity.fragment.progress.monthly.MonthlyCurrentFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.time.LocalDate;
import java.util.ArrayList;

public class AllTimeFragment extends Fragment {

    private LineChart lineChart;
    private LineData data;
    private LineDataSet lineDataSet;
    private ArrayList<Entry> list = new ArrayList<>();
    private final int YEAR = LocalDate.now().getYear();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view =inflater.inflate(R.layout.fragment_all_time, container, false);

        lineChart = view.findViewById(R.id.all_time_chart);

        list.add(new Entry(0, 25));
        list.add(new Entry(1, 15));
        list.add(new Entry(2, 30));

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
        xAxis.setLabelCount(list.size(), true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLinesBehindData(false);
        xAxis.setLabelRotationAngle(-90);
        xAxis.setTextSize(10f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(list.size() - 1);
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
            return ((int)  value + YEAR) + "";
        }
    }
}