package com.example.ecommerce;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WomanWearActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_wear);

        recyclerView = findViewById(R.id.womanwearList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.raw.witem1, "Lehnga Kurti", 5000));
        itemList.add(new Item(R.raw.witem2, "Frok", 4000));
        itemList.add(new Item(R.raw.witem3, "Sky Blue Print Frok", 5500));
        itemList.add(new Item(R.raw.witem4, "3 Pieces Suit", 7000));
        itemList.add(new Item(R.raw.witem5, "Frok Blue", 8000));
        itemList.add(new Item(R.raw.witem6, "Frok Blue & Yellow", 9000));
        itemList.add(new Item(R.raw.witem7, "Shalwar Kameez", 5000));
        itemList.add(new Item(R.raw.witem8, "Shalwar Kameez", 6000));
        itemList.add(new Item(R.raw.witem9, "Fancy Sharara Kurti", 9500));
        itemList.add(new Item(R.raw.witem10, "3 Piece Suit", 10000));

        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
    }
}
