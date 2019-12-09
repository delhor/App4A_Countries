package com.example.daoud.app_3aufa_elhor.controllers.activities.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.fragments.MainFragment;
import com.example.daoud.app_3aufa_elhor.controllers.activities.retrofitgerrit.Controller;
import com.example.daoud.app_3aufa_elhor.controllers.activities.retrofitgerrit.Country;
import com.example.daoud.app_3aufa_elhor.controllers.activities.retrofitgerrit.OnItemClickListener;

import java.util.List;

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