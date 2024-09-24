package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroceryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        recyclerView = findViewById(R.id.groceryList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.g1, "Nescafe Coffee", 6000));
        itemList.add(new Item(R.raw.g2, "Tomato Ketchup", 400));
        itemList.add(new Item(R.raw.g3, "Original Cardinits", 800));
        itemList.add(new Item(R.raw.g4, "Oreo", 70));
        itemList.add(new Item(R.raw.g5, "Rolled Oats", 400));
        itemList.add(new Item(R.raw.g6, "Head & Shoulder", 600));
        itemList.add(new Item(R.raw.g7, "PIzza Spice", 1500));
        itemList.add(new Item(R.raw.g8, "Drinkable Yogurt", 100));
        itemList.add(new Item(R.raw.g9, "1 Kilo Oranges", 150));
        itemList.add(new Item(R.raw.g10, "Pringles", 500));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
