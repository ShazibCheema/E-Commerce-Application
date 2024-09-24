package com.example.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.ecommerce.databinding.ActivityDashboardBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mancj.materialsearchbar.MaterialSearchBar;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    ArrayList<CategoryModel> categories;
    private ProductAdapter productAdapter;
    private List<ProductModel> allProducts = new ArrayList<>(); // List to hold all products

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.myToolbar);
        productAdapter = new ProductAdapter(this);
        binding.productRecycler.setAdapter(productAdapter);
        binding.productRecycler.setLayoutManager(new GridLayoutManager(this, 2));

        getProducts();
        initSlider();
        initCategories();

        binding.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, CartActivity.class));
            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
            }
        });

        setupSearchBar(); // Setup search bar
    }

    private void initSlider() {
        binding.carousel.addData(new CarouselItem("https://www.shutterstock.com/image-vector/big-sale-75-off-poster-260nw-1111675793.jpg"));
        binding.carousel.addData(new CarouselItem("https://www.easypromosapp.com/blog/wp-content/uploads/xxss-promo-codes-all-you-need-to-know.png"));
        binding.carousel.addData(new CarouselItem("https://www.shutterstock.com/image-vector/colorful-discount-sale-podium-special-600nw-2055955985.jpg"));
    }

    private void getProducts() {
        FirebaseFirestore.getInstance()
                .collection("products")
                .whereEqualTo("show", true)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds : dsList) {
                            ProductModel productModel = ds.toObject(ProductModel.class);
                            allProducts.add(productModel); // Add to all products list
                            productAdapter.addProduct(productModel);
                        }
                    }
                });
    }

    private void setupSearchBar() {
        binding.searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No action needed
            }
        });
    }

    private void filterProducts(String query) {
        List<ProductModel> filteredProducts = new ArrayList<>();
        for (ProductModel product : allProducts) {
            if (product.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        productAdapter.setProducts(filteredProducts); // Update adapter with filtered list
    }

    void initCategories() {
        categories = new ArrayList<>();
        categories.add(new CategoryModel("Man Wear", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShRWB8ByneVPT2Tmob7gIvqBjNQx30QHx-FQ&s", "some description",1));
        categories.add(new CategoryModel("Woman Wear", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuG5SvGv8d4aD5ljABJXTXpzRE3aM-f_35GQ&s", "some description",1));
        categories.add(new CategoryModel("Kids Wear", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEVtBB8XbU2jQgjiA1YPQcrkDHFZwfkNpZIg&s", "some description",1));
        categories.add(new CategoryModel("Sports & Outdoors", "https://cdn-icons-png.flaticon.com/512/857/857455.png", "some description",1));
        categories.add(new CategoryModel("Groceries", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR--O7Iu0_8PO-Dt-vZf9HXtbdG2gWiwX6HbA&s", "some description",1));
        categories.add(new CategoryModel("Electronics", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS48Pjbldl7ccSptNCcW-yZckTUyrPIKN9jw&s", "some description",1));
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
    }
}
