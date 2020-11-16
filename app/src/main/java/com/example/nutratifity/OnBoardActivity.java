package com.example.nutratifity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.nutratifity.adapter.OnBoardSliderAdapter;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private Button learnMore;
    private Button skip;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        getSupportActionBar().hide();

        getWindow().setEnterTransition(null);
        getWindow().setExitTransition(null);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        learnMore = findViewById(R.id.learn_more);
        skip = findViewById(R.id.skip);
        logo = findViewById(R.id.logo);

        OnBoardSliderAdapter onBoardSliderAdapter = new OnBoardSliderAdapter(this);

        viewPager.setAdapter(onBoardSliderAdapter);

        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);

        learnMore.setOnClickListener(v -> {
            if (learnMore.getText() == "Continue") {
                Intent intent = new Intent(OnBoardActivity.this, InitActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        OnBoardActivity.this,
                        Pair.create(logo, "logo_image")
                );
                startActivity(intent, options.toBundle());
            }
            viewPager.arrowScroll(View.FOCUS_RIGHT);
        });

        skip.setOnClickListener(v -> {
            Intent intent = new Intent(OnBoardActivity.this, InitActivity.class);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    OnBoardActivity.this,
                    Pair.create(logo, "logo_image")
            );
            startActivity(intent, options.toBundle());
        });
    }

    private void addDots(int position) {
        TextView[] dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(HtmlCompat.fromHtml("&#8226", HtmlCompat.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(32);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(ContextCompat.getColor(this, R.color.green));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if (position == 2) {
                learnMore.setText("Continue");
                skip.setVisibility(View.GONE);
            } else {
                learnMore.setText("Learn More");
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}