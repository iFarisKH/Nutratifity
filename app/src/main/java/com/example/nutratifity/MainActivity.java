package com.example.nutratifity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nutratifity.fragment.DiaryFragment;
import com.example.nutratifity.fragment.HomeFragment;
import com.example.nutratifity.fragment.MoreFragment;
import com.example.nutratifity.fragment.ProgressFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private CardView appBar;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        appBar = findViewById(R.id.action_bar);
        title = appBar.findViewById(R.id.action_bar_title);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container,
                new HomeFragment()
        ).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectFragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectFragment = new HomeFragment();
                title.setText("Home");
                break;
            case R.id.nav_diary:
                selectFragment = new DiaryFragment();
                title.setText("Diary");
                break;
            case R.id.nav_progress:
                selectFragment = new ProgressFragment();
                title.setText("Progress");
                break;
            case R.id.nav_more:
                selectFragment = new MoreFragment();
                title.setText("Setting");
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container,
                selectFragment
        ).commit();
        return true;
    }
}