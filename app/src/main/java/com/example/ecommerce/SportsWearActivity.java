package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SportsWearActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_wear);

        recyclerView = findViewById(R.id.sportswearList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.s1, "Black Trouser", 2000));
        itemList.add(new Item(R.raw.s2, "Running Kit", 6000));
        itemList.add(new Item(R.raw.s3, "Gym Suit", 9000));
        itemList.add(new Item(R.raw.s4, "Black Hoddie", 3000));
        itemList.add(new Item(R.raw.s5, "Red Hoddie", 3500));
        itemList.add(new Item(R.raw.s6, "Grey Shirt", 2500));
        itemList.add(new Item(R.raw.s7, "Grey & Black Hoddie", 6000));
        itemList.add(new Item(R.raw.s8, "Sleeveless", 4500));
        itemList.add(new Item(R.raw.s9, "Hoddie for Boys", 5500));
        itemList.add(new Item(R.raw.s10, "Black & White Suit", 4500));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
