package com.example.daoud.app_3aufa_elhor.controllers.activities.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.daoud.app_3aufa_elhor.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new MainFragment())
                .commit();
    }

}