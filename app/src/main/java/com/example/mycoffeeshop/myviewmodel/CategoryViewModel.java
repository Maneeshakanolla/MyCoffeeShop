package com.example.mycoffeeshop.myviewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mycoffeeshop.model.Category;
import com.example.mycoffeeshop.repository.Repository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    Repository repository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }
    public LiveData<List<Category>> getAllCategory(){
        return repository.getMutableLiveData();
    }


}
