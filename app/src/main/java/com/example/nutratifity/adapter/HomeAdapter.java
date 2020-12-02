package com.example.nutratifity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutratifity.R;
import com.example.nutratifity.helper.HomeHelper;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeHelper> list;
    private ProgressBar protein, carb, fat, cal;
    private TextView calLeft;

    public HomeAdapter(ArrayList<HomeHelper> list, ProgressBar protein, ProgressBar carb,
                       ProgressBar fat, ProgressBar cal, TextView calLeft) {
        this.list = list;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.cal = cal;
        this.calLeft = calLeft;
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
        holder.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.done.setImageResource(R.drawable.ic_verified);
                protein.setProgress(protein.getProgress() + 13, true);
                carb.setProgress(carb.getProgress() + 20, true);
                fat.setProgress(fat.getProgress() + 11, true);

                int calText = Integer.parseInt(calLeft.getText().toString().split("\n")[0]);
                int calMeal = Integer.parseInt(holder.mealCal.getText().toString().split(" ")[0]);
                cal.setProgress(cal.getProgress() + calMeal, true);
                calLeft.setText((calText - calMeal) + "\nCalories Left");
                holder.done.setClickable(false);
                holder.done.setFocusable(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView mealType, mealName, mealCal, mealTime;
        ImageView done;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            mealType = itemView.findViewById(R.id.meal_type);
            mealName = itemView.findViewById(R.id.meal_name);
            mealCal = itemView.findViewById(R.id.meal_cal);
            mealTime = itemView.findViewById(R.id.meal_time);
            done = itemView.findViewById(R.id.meal_done);

        }
    }
}
