package com.example.fabulous_feasts.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabulous_feasts.Models.OrderedItemsModel;
import com.example.fabulous_feasts.User.UserPromoPage;
import com.example.fabulous_feasts.Adapter.UserCategoryAdapter;
import com.example.fabulous_feasts.Adapter.UserProductAdapter;
import com.example.fabulous_feasts.Models.UserCategoryModel;
import com.example.fabulous_feasts.Models.UserProductModel;
import com.example.fabulous_feasts.R;

import java.util.ArrayList;
import java.util.List;

public class UserHomePage extends AppCompatActivity {
    RecyclerView categoryRecyclerView, productRecyclerView;
    TextView textViewTitle1;
    ImageButton imgBtnPromo;
    ImageView imageProfile,imageHome,imageCart,imageOrderList;
    UserCategoryAdapter categoryAdapter;
    UserProductAdapter productAdapter;
    List<OrderedItemsModel> ordereditemsList;
    List<UserCategoryModel> categoryList;
    List<UserProductModel> productsList;
    int selectedCategoryId = 1;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);


        textViewTitle1 = findViewById(R.id.textViewTitle1);
        String userName = getIntent().getStringExtra("userName");
        if (userName != null) {
            textViewTitle1.setText("Hi " + userName);
        } else {
            textViewTitle1.setText("Hi");
        }
        imgBtnPromo = findViewById(R.id.imgBtnPromoBanner);
        imgBtnPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserPromoPage.class);
                startActivity(intent);
            }
        });
        imageProfile =findViewById(R.id.imageViewProfile);
        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserProfilePage.class);
                startActivity(intent);
            }
        });
        imageCart =findViewById(R.id.imageViewCart);
        imageCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyCartPage.class);
                startActivity(intent);
            }
        });
        imageHome =findViewById(R.id.imageViewHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                startActivity(intent);
            }
        });
        imageOrderList =findViewById(R.id.imageMyOrderList);
        imageOrderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                startActivity(intent);
            }
        });

        categoryRecyclerView = findViewById(R.id.userCategoryRecycler);
        productRecyclerView = findViewById(R.id.userProductRecycler);

        // Initialize category list
        categoryList = new ArrayList<>();
        categoryList.add(new UserCategoryModel(1,R.drawable.dosa,"Breakfast"));
        categoryList.add(new UserCategoryModel(2, R.drawable.fried_rice,"Lunch"));
        categoryList.add(new UserCategoryModel(3, R.drawable.pad_thai,"Dinner"));
        categoryList.add(new UserCategoryModel(4, R.drawable.bread,"Shorteats"));
        categoryList.add(new UserCategoryModel(5, R.drawable.dessert__2_,"Desserts"));
        categoryList.add(new UserCategoryModel(6, R.drawable.ice_cream,"Drinks"));

        // Set category recycler view
        setUserCategoryRecycler(categoryList);

        // Initialize product list
        productsList = new ArrayList<>();
        // category Breakfast
        productsList.add(new UserProductModel(1, 1, "Milk Rice", "white Rice, Coconut Milk, Spicy Coconut Sambal", "02", "Rs.180.00", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients));
        productsList.add(new UserProductModel(2, 1, "Pol Rotti", "Wheat Flour Rotti, Spicy Onion Sambal", "02", "Rs.200.00", R.drawable.polrotti));
        productsList.add(new UserProductModel(3, 1, "White String Hoppers", "White Flour Hoppers, Coconut Milk, Coconut Sambal", "05", "Rs.300.00", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients));
        productsList.add(new UserProductModel(4, 1, "Red String Hoppers", "Red Rice Flour Hoppers,Dhal Curry,Sambar,Coconut Sambal", "05", "Rs.250.00", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients));
        productsList.add(new UserProductModel(5, 1, "Dosa", "Dosa,Dhal Curry,Sambar,Coconut Sambal", "01", "Rs.160.00", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients));
        productsList.add(new UserProductModel(6, 1, "Idli", "Idli, Sambar, Spicy Coconut Sambal", "02", "Rs.180.00", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients));
        // category Lunch
        productsList.add(new UserProductModel(1, 2, "Veg Rice & Curry", "Basmati Rice,Dhal,Green Leaves and vegetables", "01", "Rs.300.00", R.drawable.rice2));
        productsList.add(new UserProductModel(2, 2, "Chicken Rice & Curry", "Basmati Rice,Chicken Curry,Dhal,Green Leaves and vegetables", "01", "Rs.350.00", R.drawable.rice2));
        productsList.add(new UserProductModel(3, 2, "Chicken Fried Rice", "white rice, Chicken Fry, Vegetables", "01", "Rs.400.00", R.drawable.rice2));
        productsList.add(new UserProductModel(4, 2, "Egg Fried Rice", "white rice, Eggs, Vegetables", "01", "Rs.450.00", R.drawable.rice2));
        productsList.add(new UserProductModel(5, 2, "Chicken Biryani", "Briyani with Mushroom Stir Fry", "01", "Rs.650.00", R.drawable.rice2));
        productsList.add(new UserProductModel(6, 2, "Paneer Biryani", "Briyani with Paneer Stir Fry", "01", "Rs.600.00", R.drawable.rice2));
        // category Dinner
        productsList.add(new UserProductModel(1, 3, "Veg Noodles", "Chinese noodles with vegetables", "01", "Rs.900.00", R.drawable.c_noodles));
        productsList.add(new UserProductModel(2, 3, "Chicken Noodles", "Chinese noodles with chicken devil & vegetables", "01", "Rs.950.00", R.drawable.c_noodles));
        productsList.add(new UserProductModel(3, 3, "Sea food Noodles", "Chinese noodles with cuttle fish,fish and prawn fries & vegetables", "01", "Rs.950.00", R.drawable.c_noodles));
        productsList.add(new UserProductModel(4, 3, "Pasta", "creamy chicken pasta", "01", "Rs.1050.00", R.drawable.c_noodles));
        productsList.add(new UserProductModel(5, 3, "Chicken Koththu", "chicken curry koththu", "01", "Rs.750.00", R.drawable.c_noodles));
        productsList.add(new UserProductModel(6, 3, "Veg Koththu", "Veg koththu", "01", "Rs.650.00", R.drawable.c_noodles));
        // category Short Eats
        productsList.add(new UserProductModel(1, 4, "Samosa", "potato curry stuffed somosa", "02", "Rs.150.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        productsList.add(new UserProductModel(2, 4, "Chicken Rolls", "chicken and potato curry stuffed rolls", "02", "Rs.180.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        productsList.add(new UserProductModel(3, 4, "Veg Rolls", "potato curry stuffed rolls", "02", "Rs.150.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        productsList.add(new UserProductModel(4, 4, "Fish Rolls", "fish and potato curry stuffed rolls", "02", "Rs.170.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        productsList.add(new UserProductModel(5, 4, "Ulunthu Vada", "ulunthu vada, red sambol, green sambol", "02", "Rs.200.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        productsList.add(new UserProductModel(6, 4, "Curry Rotti", "potato curry stuffed Rotti", "02", "Rs.210.00", R.drawable.sri_lankan_fish_patties__fish_empanadas_));
        // category Desserts
        productsList.add(new UserProductModel(1, 5, "Chocolate cake slice", "chocolate cake with chocolate cream frosting", "02", "Rs.300.00", R.drawable.tres_leches));
        productsList.add(new UserProductModel(2, 5, "Pudding", "Home made egg milk caramel pudding", "02", "Rs.520.00", R.drawable.tres_leches));
        productsList.add(new UserProductModel(3, 5, "Carrot Halwa", "carrot, milkmaid halwa", "01", "Rs.320.00", R.drawable.tres_leches));
        productsList.add(new UserProductModel(4, 5, "Kesari", "rava kesari", "02", "Rs.120.00", R.drawable.tres_leches));
        productsList.add(new UserProductModel(5, 5, "Gulabjamun", "sugar syrup dipped gulabjamun", "02", "Rs.220.00", R.drawable.tres_leches));
        productsList.add(new UserProductModel(6, 5, "Payasam", "Pal payasam", "01", "Rs.120.00", R.drawable.tres_leches));
        // category Drinks
        productsList.add(new UserProductModel(1, 6, "Chocolate Milk Shake", "Chocolate ice cream, milk and milo sprinkle syrup", "01", "Rs.600.00", R.drawable.chocolateshake));
        productsList.add(new UserProductModel(2, 6, "Strawberry Milk Shake", "Strawberry ice cream, milk and strawberry syrup", "01", "Rs.550.00", R.drawable.chocolateshake));
        productsList.add(new UserProductModel(3, 6, "Pineapple Juice", "fresh pineapple juice", "01", "Rs.400.00", R.drawable.chocolateshake));
        productsList.add(new UserProductModel(4, 6, "Mango Juice", "fresh Mango juice", "01", "Rs.400.00", R.drawable.chocolateshake));
        productsList.add(new UserProductModel(5, 6, "Avocado Juice", "fresh Avocado juice", "01", "Rs.450.00", R.drawable.chocolateshake));
        productsList.add(new UserProductModel(6, 6, "Water Melon Juice", "fresh Water Melon juice", "01", "Rs.300.00", R.drawable.chocolateshake));
        // Set product recycler view initially to GONE
        setUserProductRecycler(productsList);
        productRecyclerView.setVisibility(View.GONE);
    }

    private void setUserCategoryRecycler(List<UserCategoryModel> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new UserCategoryAdapter(this, dataList, new UserCategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(UserCategoryModel userCategory) {
                selectedCategoryId = userCategory.getCategoryId();
                setUserProductRecycler(productsList);
                productRecyclerView.setVisibility(View.VISIBLE);
            }
        });
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setUserProductRecycler(List<UserProductModel> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(layoutManager);

        // Filter the products list based on the selected category
        List<UserProductModel> filteredProductList = new ArrayList<>();
        for (UserProductModel product : productList) {
            if (product.getCategoryId() == selectedCategoryId) {
                filteredProductList.add(product);
            }
        }

        productAdapter = new UserProductAdapter(this, filteredProductList);
        productRecyclerView.setAdapter(productAdapter);
    }
}
