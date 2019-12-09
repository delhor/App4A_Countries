package com.example.daoud.app_3aufa_elhor.controllers.activities.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.fragments.DetailFragment;
import com.example.daoud.app_3aufa_elhor.controllers.activities.fragments.MainFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Fragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("capital", getIntent().getStringExtra("capital"));
        bundle.putString("region", getIntent().getStringExtra("region"));
        bundle.putInt("population",getIntent().getIntExtra("population", 0));
        fragment.setArguments(bundle);



        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment2_container, fragment)
                .commit();

    }
}
