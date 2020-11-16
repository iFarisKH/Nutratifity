package com.example.nutratifity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private final int DELAY = 3000;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setExitTransition(null);

        logo = findViewById(R.id.logo);

        new Handler(Looper.getMainLooper()).postDelayed(this::run, DELAY);
    }

    private void run() {
        Intent intent = new Intent(SplashActivity.this, OnBoardActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, Pair.create(logo, "logo_image"));
        startActivity(intent, options.toBundle());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, DELAY);
    }
}