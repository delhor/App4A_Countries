package com.example.daoud.app_3aufa_elhor.controllers.activities.controllers;

import com.example.daoud.app_3aufa_elhor.controllers.activities.view.MainFragment;
import com.example.daoud.app_3aufa_elhor.controllers.activities.model.Country;
import com.example.daoud.app_3aufa_elhor.controllers.activities.model.GerritAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Country>> {

    static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private final MainFragment view;


    public Controller(MainFragment view) {
        this.view = view;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<List<Country>> call = gerritAPI.loadChanges("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        if(response.isSuccessful()) {
            List<Country> countryList = response.body();
            view.displayCountryList(countryList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Country>> call, Throwable t) {
        t.printStackTrace();
    }
}