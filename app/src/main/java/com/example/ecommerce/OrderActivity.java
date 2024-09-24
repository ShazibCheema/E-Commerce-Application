package com.example.ecommerce;

import static android.content.ContentValues.TAG;
import static com.example.ecommerce.CartActivity.cartsItemList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecommerce.databinding.ActivityOrderBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    int mainTotal = 0;
    private String name, number, address, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        binding.placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.name.getText().toString();
                number = binding.number.getText().toString();
                address = binding.address.getText().toString();
                city = binding.city.getText().toString();
                placeOrder();

            }
        });

    }

    private void placeOrder() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Order Placing");
        progressDialog.setMessage("Pending");
        progressDialog.show();
        String orderNumber = String.valueOf(getRandomNumber(100000, 999999));
        OrderModel orderModel = new OrderModel(orderNumber, name, number, city, address, String.valueOf(mainTotal),
                "220", null, "Tcs", String.valueOf(Calendar.getInstance().getTimeInMillis()),
                "Pending", FirebaseAuth.getInstance().getUid());

        FirebaseFirestore.getInstance()
                .collection("orders")
                .document(orderNumber)
                .set(orderModel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        for (int i = 0; i < cartsItemList.size(); i++) {
                            CartModel cartModel = cartsItemList.get(i);
                            cartModel.setOrderNumber(orderNumber);

                            String id = UUID.randomUUID().toString();
                            cartModel.setCartId(id);

                            FirebaseFirestore.getInstance()
                                    .collection("orderProducts")
                                    .document(id)
                                    .set(cartModel);


                        }
                        finish();
                        progressDialog.cancel();
                        Toast.makeText(OrderActivity.this, "Order Placed Successfully ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(OrderActivity.this, DashboardActivity.class));

                    }
                });


    }

    public static int getRandomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (int i = 0; i < cartsItemList.size(); i++) {
            CartModel cartModel = cartsItemList.get(i);
            int price = Integer.parseInt(cartModel.getProductPrice());
            int qty = Integer.parseInt(cartModel.getProductQTY());
            int total = price * qty;
            mainTotal += total;

        }
        binding.expense.setText(String.valueOf(mainTotal));
        binding.delivery.setText("220");
        binding.totalPayable.setText(String.valueOf(mainTotal + 220));
    }




}