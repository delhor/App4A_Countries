package com.example.daoud.app_3aufa_elhor.controllers.activities.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.fragments.MainFragment;

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