package com.example.nutratifity.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nutratifity.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.Slider;

public class MoreFragment extends Fragment {
    private TextView dateFormat, dateFormatValue, language, languageValue, time;
    private int dateFormatChecked = 0, languageChecked = 0;
    private Button profile;
    private Slider slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        dateFormat = view.findViewById(R.id.date_format);
        dateFormatValue = view.findViewById(R.id.date_format_value);
        language = view.findViewById(R.id.language);
        languageValue = view.findViewById(R.id.language_value);
        profile = view.findViewById(R.id.profile);
        time = view.findViewById(R.id.time);
        slider = view.findViewById(R.id.slider);

        slider.addOnSliderTouchListener(touchListener);

        dateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date[] = {"Gregorian", "Hijri"};
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
                builder.setTitle("Date Format");
                builder.setSingleChoiceItems(date, dateFormatChecked, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dateFormatValue.setText(date[which]);
                        dateFormatChecked = which;
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ln[] = {"EN - English", "AR - Arabic"};
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
                builder.setTitle("Language");
                builder.setSingleChoiceItems(ln, languageChecked, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        languageValue.setText(ln[which]);
                        languageChecked = which;
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(
                        R.id.fragment_container,
                        new ProfileFragment()
                ).commit();
            }
        });

        return view;
    }

    private final Slider.OnSliderTouchListener touchListener = new Slider.OnSliderTouchListener() {
        @Override
        public void onStartTrackingTouch(@NonNull Slider slider) {

        }

        @Override
        public void onStopTrackingTouch(@NonNull Slider slider) {
            time.setText((int) slider.getValue() + " MIN");
        }
    };
}