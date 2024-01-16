package com.example.mycoffeeshop.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;


import com.bumptech.glide.Glide;
import com.example.mycoffeeshop.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Category extends BaseObservable {

    @SerializedName("idCategory")
    @Expose
    private String idCategory;
    @SerializedName("strCategory")
    @Expose
    private String strCategory;
    @SerializedName("strCategoryThumb")
    @Expose
    private String strCategoryThumb;

//    @BindingAdapter({"strCategoryThumb"})
//    public static void loadImage(ImageView imageView, String imgUrl) {
//
//        String imgPath = "https://image.tmdb.org/t/p/w500/" + imgUrl;
//
//        Glide.with(imageView.getContext()).load(imgPath).into(imageView);
//    }
    @SerializedName("strCategoryDescription")
    @Expose
    private String strCategoryDescription;
     @Bindable
    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
   @Bindable
    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    @Bindable
    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }
    @Bindable
    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
        notifyPropertyChanged(BR.strCategoryThumb);
    }
    @Bindable
    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;

    }

}