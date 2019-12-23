package com.example.daoud.app_3aufa_elhor.controllers.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.controllers.Controller;
import com.example.daoud.app_3aufa_elhor.controllers.activities.model.Country;
import com.example.daoud.app_3aufa_elhor.controllers.activities.model.OnItemClickListener;

import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout of MainFragment
        View result=inflater.inflate(R.layout.fragment_main_item, container, false);

        recyclerView = result.findViewById(R.id.my_recycler_view);

        Controller controller = new Controller(this);
        controller.start();

        return result;
    }

    public void displayCountryList(List<Country> countryList) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(countryList, getContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(Country item) {
                intentExtra(item);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    public void intentExtra(Country item){
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("capital",item.getCapital() );
        intent.putExtra("population", item.getPopulation());
        intent.putExtra("region", item.getRegion());

        startActivity(intent);
    }
}

