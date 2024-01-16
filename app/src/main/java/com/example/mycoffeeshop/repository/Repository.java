package com.example.mycoffeeshop.repository;

import android.app.Application;
import android.content.Context;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.mycoffeeshop.model.Category;
import com.example.mycoffeeshop.model.Food;
import com.example.mycoffeeshop.services.GetApiDataService;
import com.example.mycoffeeshop.services.RetrofitInstance;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    Context context;
    private ArrayList<Category> categoryArrayList;
    private MutableLiveData<List<Category>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Category>> getMutableLiveData(){

        GetApiDataService getApiDataService= RetrofitInstance.getService();

        Call<Food> call = getApiDataService.getResult();

        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {

                Food result = response.body();

                Log.d("checkData",result.toString());
                if (result != null && result.getCategories() !=null){
                    categoryArrayList = (ArrayList<Category>) result.getCategories();
                    mutableLiveData.setValue(categoryArrayList);
                }

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
             t.printStackTrace();
             Log.e("NoData",t.toString());

            }
        });

        return mutableLiveData;
    }
}
