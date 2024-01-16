package com.example.mycoffeeshop.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mycoffeeshop.MainActivity3;
import com.example.mycoffeeshop.R;
import com.example.mycoffeeshop.databinding.ItemListBinding;
import com.example.mycoffeeshop.model.Category;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CategoryViewHolder> {
    Context context;
    ArrayList<Category> categoryArrayList;

    public Adapter(Context context, ArrayList<Category> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
    }

    @NonNull
    @Override
    public Adapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
//        return new CategoryViewHolder(binding);
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new CategoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CategoryViewHolder holder, int position) {
//        Category category = categoryArrayList.get(position);
//        holder.binding.setCategory(category);

        Glide.with(context).load(categoryArrayList.get(position).getStrCategoryThumb()).into(holder.imageView);
        holder.textView.setText(categoryArrayList.get(position).getIdCategory());
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
       // ItemListBinding binding;
        ImageView imageView;
        TextView textView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvid);
            imageView=itemView.findViewById(R.id.image);
        }

//        public CategoryViewHolder(ItemListBinding binding) {
//            super(binding.getRoot());
//            this.binding=binding;
//
//
//            binding.getRoot().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    Category click=categoryArrayList.get(getAdapterPosition());
//                    Toast.makeText(context,"Category" +position,Toast.LENGTH_SHORT).show();
//
//                    Intent intent=new Intent(context , MainActivity3.class);
//
//                    intent.putExtra("item",click.getStrCategoryThumb());
//
//                    context.startActivity(intent);
//
//
//
//                }
//            });
//        }
    }

}
