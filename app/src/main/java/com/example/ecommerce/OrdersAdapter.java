package com.example.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    private Context context;
    private List<OrderModel> productModelList;

    public OrdersAdapter(Context context) {
        this.context = context;
        productModelList = new ArrayList<>();
    }


    public void addProduct(OrderModel productModel){
        productModelList.add(productModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderModel orderModel = productModelList.get(position);
        holder.name.setText(orderModel.getCustomerName());
        holder.address.setText(orderModel.getCustomerAddress());
        holder.number.setText(orderModel.getCustomerNumber());
        holder.cityName.setText(orderModel.getCustomerCity());
        holder.orderNo.setText(orderModel.getOrderNo());
        if (orderModel.getOrderTrackingNumber()!=null){
            holder.trackingNumber.setText(orderModel.getOrderTrackingNumber());
        }
        holder.status.setText(orderModel.getOrderStatus());

        int cod = Integer.parseInt(orderModel.getItemExpense()) + Integer.parseInt(orderModel.getDeliverCharges());
        holder.codAmount.setText(String.valueOf(cod));

        CartAdapter cartAdapter = new CartAdapter(context);
        holder.productRecycler.setAdapter(cartAdapter);
        holder.productRecycler.setLayoutManager(new LinearLayoutManager(context));

        FirebaseFirestore.getInstance()
                .collection("orderProducts")
                .whereEqualTo("orderNumber", orderModel.getOrderNo())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds:dsList){
                            CartModel cartModel = ds.toObject(CartModel.class);
                            cartAdapter.addProduct(cartModel);
                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name, address, number, cityName, codAmount, orderNo, status, trackingNumber;
        private RecyclerView productRecycler;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            address = itemView.findViewById(R.id.address);
            cityName = itemView.findViewById(R.id.cityName);
            codAmount = itemView.findViewById(R.id.codAmount);
            orderNo = itemView.findViewById(R.id.orderNo);
            productRecycler = itemView.findViewById(R.id.orderProductsRecycler);
            status = itemView.findViewById(R.id.orderStatus);
            trackingNumber = itemView.findViewById(R.id.trackingNumber);

        }
    }
}

