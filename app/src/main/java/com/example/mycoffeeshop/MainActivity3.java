package com.example.mycoffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mycoffeeshop.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent= getIntent();
        String strCategoryThumb=getIntent().getStringExtra("item");

        String imgPath = "https://image.tmdb.org/t/p/w500/" + strCategoryThumb;
        Glide.with(this).load(imgPath).into(binding.strCategoryThumb);
        binding.executePendingBindings();

    }
}