package com.example.nutratifity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.nutratifity.fragment.DiaryFragment;
import com.example.nutratifity.fragment.HomeFragment;
import com.example.nutratifity.fragment.MoreFragment;
import com.example.nutratifity.fragment.ProgressFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private TextView title;
    private FloatingActionButton fabAdd, fabFood, fabScale, fabWater;
    private boolean clicked = false;

    private Animation rotateOpen;
    private Animation rotateClose;
    private Animation fromBottom;
    private Animation toBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        title = findViewById(R.id.container).findViewById(R.id.action_bar).findViewById(R.id.action_bar_title);
        fabAdd = findViewById(R.id.fab_add);
        fabFood = findViewById(R.id.container).findViewById(R.id.fab_food);
        fabScale = findViewById(R.id.container).findViewById(R.id.fab_scale);
        fabWater = findViewById(R.id.container).findViewById(R.id.fab_water);

        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotete_open_anim);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anime);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container,
                new HomeFragment()
        ).commit();


        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClicked();
            }
        });

        fabFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
                View bottomView = LayoutInflater.from(
                        getApplicationContext()
                ).inflate(
                        R.layout.bottom_meal,
                        (LinearLayout) findViewById(R.id.bottom_meal_container)
                );
                dialog.setContentView(bottomView);
                dialog.show();
            }
        });

        fabScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDate localDate = LocalDate.now();
                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
                View bottomView = LayoutInflater.from(
                        getApplicationContext()
                ).inflate(
                        R.layout.bottom_weight,
                        (LinearLayout) findViewById(R.id.bottom_weight_container)
                );
                TextView date = bottomView.findViewById(R.id.date);
                date.setText(
                        localDate.getDayOfWeek().name().substring(0, 3) + ", " + localDate.getDayOfMonth() + " " + localDate.getMonth().name()
                );
                dialog.setContentView(bottomView);
                dialog.show();
            }
        });
    }

    private void onAddButtonClicked() {
        setVisibility(clicked);
        setAnimation(clicked);
        clicked = !clicked;
    }

    private void setVisibility(boolean clicked) {
        if (!clicked) {
            fabFood.setVisibility(View.VISIBLE);
            fabScale.setVisibility(View.VISIBLE);
            fabWater.setVisibility(View.VISIBLE);
        } else {
            fabFood.setVisibility(View.GONE);
            fabScale.setVisibility(View.GONE);
            fabWater.setVisibility(View.GONE);
        }
    }

    private void setAnimation(boolean clicked) {
        if (!clicked) {
            fabAdd.startAnimation(rotateOpen);
            fabFood.startAnimation(fromBottom);
            fabScale.startAnimation(fromBottom);
            fabWater.startAnimation(fromBottom);
        } else {
            fabAdd.startAnimation(rotateClose);
            fabFood.startAnimation(toBottom);
            fabScale.startAnimation(toBottom);
            fabWater.startAnimation(toBottom);
        }
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