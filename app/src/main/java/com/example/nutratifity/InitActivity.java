package com.example.nutratifity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

public class InitActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {

    private TabLayout tabLayout;
    private TextInputLayout weight;
    private TextInputLayout height;
    private TextInputLayout goal;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        getSupportActionBar().hide();

        tabLayout = findViewById(R.id.tab_init);
        weight = findViewById(R.id.weight_init);
        height = findViewById(R.id.height_init);
        goal = findViewById(R.id.goal_init);
        done = findViewById(R.id.done_init);

        weight.getEditText().addTextChangedListener(textWatcher);
        height.getEditText().addTextChangedListener(textWatcher);
        goal.getEditText().addTextChangedListener(textWatcher);
        tabLayout.addOnTabSelectedListener(this);
        done.setOnClickListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                weight.setSuffixText("KG");
                height.setSuffixText("CM");
                goal.setSuffixText("KG");
                break;
            case 1:
                weight.setSuffixText("LBS");
                height.setSuffixText("FEET");
                goal.setSuffixText("LBS");
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {

    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String w = weight.getEditText().getText().toString().trim();
            String h = height.getEditText().getText().toString().trim();
            String g = goal.getEditText().getText().toString().trim();
            if(w.isEmpty() || h.isEmpty() || g.isEmpty()){
                done.setVisibility(View.GONE);
            }else{
                done.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}