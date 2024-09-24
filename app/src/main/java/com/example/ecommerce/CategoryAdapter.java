package com.example.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.databinding.ItemCategoriesBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<CategoryModel> categories;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categories){
        this.context = context;
        this.categories= categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_categories, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel category = categories.get(position);
        holder.binding.label.setText(category.getName());
        Glide.with(context)//to load images form internet
                .load(category.getIcon())
                .into(holder.binding.img);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (category.getName()) {
                    case "Man Wear":
                        intent = new Intent(context, ManWearActivity.class);
                        break;
                    case "Woman Wear":
                        intent = new Intent(context, WomanWearActivity.class);
                        break;
                    case "Kids Wear":
                        intent = new Intent(context, KidsWearActivity.class);
                        break;
                    case "Sports & Outdoors":
                        intent = new Intent(context, SportsWearActivity.class);
                        break;
                    case "Groceries":
                        intent = new Intent(context, GroceryActivity.class);
                        break;
                    case "Electronics":
                        intent = new Intent(context, ElectronicsActivity.class);
                        break;
                }
                if (intent != null) {
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ItemCategoriesBinding binding;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCategoriesBinding.bind(itemView);
        }
    }
}
