package com.example.nutratifity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutratifity.R;
import com.example.nutratifity.helper.HomeHelper;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeHelper> list;

    public HomeAdapter(ArrayList<HomeHelper> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.home_card_design,
                parent,
                false
        );
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeHelper homeHelper = list.get(position);

        holder.mealType.setText(homeHelper.getMealType());
        holder.mealName.setText(homeHelper.getMealName());
        holder.mealCal.setText(homeHelper.getMealCal());
        holder.mealTime.setText(homeHelper.getMealTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView mealType, mealName, mealCal, mealTime;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            mealType = itemView.findViewById(R.id.meal_type);
            mealName = itemView.findViewById(R.id.meal_name);
            mealCal = itemView.findViewById(R.id.meal_cal);
            mealTime = itemView.findViewById(R.id.meal_time);

        }
    }
}
