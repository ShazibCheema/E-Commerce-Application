package com.example.ecommerce;

import static com.example.ecommerce.CartActivity.cartsItemList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.ecommerce.databinding.ActivityDetailBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        productModel = (ProductModel) intent.getSerializableExtra("model");

        binding.title.setText(productModel.getTitle());
        binding.description.setText(productModel.getDescription());
        binding.price.setText(productModel.getPrice());

        Glide.with(binding.getRoot())
                .load(productModel.getImage())
                .into(binding.image);

        binding.addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(0);
            }
        });

        binding.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(1);
            }
        });



    }

    private void showBottomSheet(int i) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(DetailActivity.this)
                .inflate(R.layout.bottom_layout,(LinearLayout)findViewById(R.id.mainLayout),
                false);
        bottomSheetDialog.setContentView(view);

        TextView qty = view.findViewById(R.id.quantity);
        Button btn = view.findViewById(R.id.checkout);

        ImageView incr = view.findViewById(R.id.incr);
        ImageView decr = view.findViewById(R.id.decr);

        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQty = Integer.parseInt(qty.getText().toString());
                currentQty++;
                qty.setText(String.valueOf(currentQty));
            }
        });

        decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQty = Integer.parseInt(qty.getText().toString());
                if (currentQty > 1) {  // Ensure qty doesn't go below 1
                    currentQty--;
                    qty.setText(String.valueOf(currentQty));
                }
            }
        });

        bottomSheetDialog.show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = qty.getText().toString();
                if (i==0) {
                    //add to cart
                    addtoCart(quantity);
                    bottomSheetDialog.cancel();
                } else if (i==1) {
                    CartModel cartModel = new CartModel(null,productModel.getTitle(),productModel.getImage(),productModel.getPrice(),
                            quantity,FirebaseAuth.getInstance().getUid(), null);
                    cartsItemList = new ArrayList<>();
                    cartsItemList.add(cartModel);
                    startActivity(new Intent(DetailActivity.this, OrderActivity.class));
                    bottomSheetDialog.cancel();

                }
            }
        });

    }

    private void addtoCart(String qty) {

        String id = UUID.randomUUID().toString();
        CartModel cartModel = new CartModel(id,productModel.getTitle(),productModel.getImage(),productModel.getPrice()
                ,qty, FirebaseAuth.getInstance().getUid(),null);

        FirebaseFirestore.getInstance()
                .collection("cart")
                .document(id)
                .set(cartModel);
        Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();

    }
}