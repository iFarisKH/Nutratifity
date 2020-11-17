package com.example.nutratifity.helper;

public class HomeHelper {

    private String  mealType, mealName, mealCal, mealTime;

    public HomeHelper(){

    }

    public HomeHelper(String mealType, String mealName, String mealCal, String mealTime) {
        this.mealType = mealType;
        this.mealName = mealName;
        this.mealCal = mealCal;
        this.mealTime = mealTime;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealCal() {
        return mealCal;
    }

    public void setMealCal(String mealCal) {
        this.mealCal = mealCal;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
}
