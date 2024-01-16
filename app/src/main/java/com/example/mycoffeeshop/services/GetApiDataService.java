package com.example.mycoffeeshop.services;

import com.example.mycoffeeshop.model.Food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetApiDataService {
    @GET("categories.php")
    Call<Food> getResult();
}
