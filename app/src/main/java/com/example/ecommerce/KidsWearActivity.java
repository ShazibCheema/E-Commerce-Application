package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KidsWearActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_wear);

        recyclerView = findViewById(R.id.kidswearList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.k1, "Black & Yellow ", 5000));
        itemList.add(new Item(R.raw.k2, "Balck & Grey Kit", 6000));
        itemList.add(new Item(R.raw.k3, "Niker Shirt", 7000));
        itemList.add(new Item(R.raw.k4, "Track Suit", 4000));
        itemList.add(new Item(R.raw.k5, "Baby Niker Shirt", 3500));
        itemList.add(new Item(R.raw.k6, "Baby Frok", 2500));
        itemList.add(new Item(R.raw.k7, "Winter Dress", 5000));
        itemList.add(new Item(R.raw.k8, "Summer Dress", 2000));
        itemList.add(new Item(R.raw.k9, "New Born Kit", 5500));
        itemList.add(new Item(R.raw.k10, "Trouser Shirt", 4500));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
