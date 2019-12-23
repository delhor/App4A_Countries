package com.example.daoud.app_3aufa_elhor.controllers.activities.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daoud.app_3aufa_elhor.R;

public class DetailFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_detail, container, false);


        TextView textView = result.findViewById(R.id.textView);
        String capital = getArguments().getString("capital");
        textView.setText(capital);

        TextView textView2 = result.findViewById(R.id.textView2);
        String region = getArguments().getString("region");
        textView2.setText(region);

        TextView textView3 = result.findViewById(R.id.textView3);
        int population = getArguments().getInt("population");
        textView3.setText(Integer.toString(population));

        return result;

    }




}
