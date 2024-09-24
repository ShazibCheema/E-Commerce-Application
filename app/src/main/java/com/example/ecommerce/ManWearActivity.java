package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ManWearActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_wear);

        recyclerView = findViewById(R.id.manwearList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.mitem1, "Shalwar Kameez", 5000));
        itemList.add(new Item(R.raw.mitem2, "Shalwar Kameez", 7000));
        itemList.add(new Item(R.raw.mitem3, "Formal Dress", 6000));
        itemList.add(new Item(R.raw.mitem4, "Pent Coat", 10000));
        itemList.add(new Item(R.raw.mitem5, "Classic Coat", 8000));
        itemList.add(new Item(R.raw.mitem6, "Grey Coat", 9000));
        itemList.add(new Item(R.raw.mitem7, "Classic Pent Shirt", 5000));
        itemList.add(new Item(R.raw.mitem8, "Wedding Dress", 3000));
        itemList.add(new Item(R.raw.mitem9, "Waise Coat", 5500));
        itemList.add(new Item(R.raw.mitem10, "Fancy Wedding Coat",10000));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
