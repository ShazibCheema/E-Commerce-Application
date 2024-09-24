package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        recyclerView = findViewById(R.id.electronicsList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);


        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.e1, "Watch", 5000));
        itemList.add(new Item(R.raw.e2, "Camera", 25000));
        itemList.add(new Item(R.raw.e3, "Juicer Blender", 7000));
        itemList.add(new Item(R.raw.e4, "Air fryer", 15000));
        itemList.add(new Item(R.raw.e5, "Fridge", 55000));
        itemList.add(new Item(R.raw.e6, "Electric Stock", 2500));
        itemList.add(new Item(R.raw.e7, "Juicer Kit", 9000));
        itemList.add(new Item(R.raw.e8, "House Appliances", 40000));
        itemList.add(new Item(R.raw.e9, "Microwave Oven", 8000));
        itemList.add(new Item(R.raw.e10, "Air Conditioner", 75000));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
