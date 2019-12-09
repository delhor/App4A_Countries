package com.example.daoud.app_3aufa_elhor.controllers.activities.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.daoud.app_3aufa_elhor.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.textView);
        String capital = getIntent().getStringExtra("capital");
        textView.setText(capital);

        TextView textView2 = findViewById(R.id.textView2);
        String region = getIntent().getStringExtra("region");
        textView2.setText(region);

        TextView textView3 = findViewById(R.id.textView3);
        int population = getIntent().getIntExtra("population", 0);
        textView3.setText(Integer.toString(population));


    }
}