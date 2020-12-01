package com.example.nutratifity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddMealActivity extends AppCompatActivity {

    private CardView cardView;
    private EditText editText;
    private FloatingActionButton fabMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        cardView = findViewById(R.id.egg);
        editText = findViewById(R.id.search_field);
        fabMeal = findViewById(R.id.fab_add_meal);

        editText.addTextChangedListener(textWatcher);

        fabMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMealActivity.this, ReviewMealActivity.class));
            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (editText.getText().toString().equalsIgnoreCase("egg")) {
                cardView.setVisibility(View.VISIBLE);
            } else {
                cardView.setVisibility(View.INVISIBLE);
            }
        }
    };
}