package com.example.nutratifity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        getSupportActionBar().hide();

        getWindow().setEnterTransition(null);
    }
}