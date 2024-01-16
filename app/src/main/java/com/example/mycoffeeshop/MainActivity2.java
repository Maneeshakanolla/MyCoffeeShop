package com.example.mycoffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mycoffeeshop.databinding.ActivityMain2Binding;
import com.example.mycoffeeshop.databinding.ActivityMain3Binding;
import com.example.mycoffeeshop.model.Category;
import com.example.mycoffeeshop.myviewmodel.CategoryViewModel;
import com.example.mycoffeeshop.view.Adapter;
import com.example.mycoffeeshop.view.HomeFragment;
import com.example.mycoffeeshop.view.NotificationFragment;
import com.example.mycoffeeshop.view.SliderAdapter;
import com.example.mycoffeeshop.view.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RecyclerView recyclerView;
    ActivityMain2Binding activityMain2Binding;
    Adapter adapter;
    ArrayList<Category> categoryArrayList;
    CategoryViewModel viewModel;
    Spinner spinner;

    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    private int[] images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.four};
    private int currentPage = 0;

    String[] spinData = {"Cold Coffee", "Coffee", "Coffee1", "Coffee2", "Coffee3", "Coffee4"};

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        spinner=findViewById(R.id.spinner);


        viewPager = findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(this, images);
        viewPager.setAdapter(sliderAdapter);


        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);


        //Spinner
        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_item, spinData);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spino.setAdapter(ad);

        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        getCategory();


    }



    private void getCategory() {

        viewModel.getAllCategory().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categoriesFromLiveData) {
                categoryArrayList = (ArrayList<Category>) categoriesFromLiveData;
                displayMovieInRecyclerView();
            }
        });
    }

    private void displayMovieInRecyclerView() {

        recyclerView = activityMain2Binding.recyclerview1;

        adapter = new Adapter(this , categoryArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),spinData[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

