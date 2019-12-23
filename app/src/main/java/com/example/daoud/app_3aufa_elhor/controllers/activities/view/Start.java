package com.example.daoud.app_3aufa_elhor.controllers.activities.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.view.MainActivity;


public class Start extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start2);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            };

            new Handler().postDelayed(runnable, 3000);

        }
}
