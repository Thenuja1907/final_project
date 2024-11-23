package com.example.fabulous_feasts.User;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.example.fabulous_feasts.Adapter.BannerAdapter;
import com.example.fabulous_feasts.Adapter.PromationAdapter;
import com.example.fabulous_feasts.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UserPromoPage extends AppCompatActivity {
    BannerAdapter bannerAdapter;
    PromationAdapter promationAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_promo_page);

        RecyclerView recyclerViewBanner = findViewById(R.id.recyclerViewBanner);
        RecyclerView recyclerViewPromation = findViewById(R.id.recyclerViewPromation);

        // Initialize ArrayLists
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> place = new ArrayList<>();
        ArrayList<String> offerCondition = new ArrayList<>();
        ArrayList<String> offer = new ArrayList<>();
        ArrayList<String> promocode = new ArrayList<>();
        ArrayList<Integer> image = new ArrayList<>();

        ArrayList<String> offerConditionPromation = new ArrayList<>();
        ArrayList<String> offerPromation = new ArrayList<>();

        // Populate ArrayLists with data
        image.add(R.drawable.ic_milkshake);
        image.add(R.drawable.ic_pizzza);
        image.add(R.drawable.ic_noodles);
        image.add(R.drawable.ic_cake);

        date.add("Rs 300 OFF");
        date.add("2024-07-02");
        date.add("2024-07-03");
        date.add("2024-07-04");

        place.add("Store A");
        place.add("Store B");
        place.add("Store C");
        place.add("Store D");

        offerCondition.add("Minimum purchase of $50");
        offerCondition.add("Buy one get one free");
        offerCondition.add("20% off on weekends");
        offerCondition.add("Free delivery");

        offer.add("10% off for MilkShake");
        offer.add("15% off For Veg Pizza");
        offer.add("20% off For Thai Noodles");
        offer.add("20% Off For Cheesecake");

        promocode.add("PROMO10");
        promocode.add("PROMO15");
        promocode.add("PROMO20");
        promocode.add("PROMO25");

        offerConditionPromation.add("Use by Aug 01,2024, Rs.1400 Minimum order & Breakfast items not eligible");
        offerConditionPromation.add("Use by Jul 30,2024, Rs.2500 Minimum order & Dinner items not eligible");
        offerConditionPromation.add("Use by Aug 20, 2024 Rs.500 Minimum order, Offer valid between 4PM to 8PM");
        offerConditionPromation.add("Use by Jul 25,2024, Rs.5000 Minimum Order");

        offerPromation.add("LKR 1400 OFF");
        offerPromation.add("LKR 2500 OFF");
        offerPromation.add("LKR 500 OFF");
        offerPromation.add("LKR 5000 OFF");

        bannerAdapter = new BannerAdapter(this, date, place, offerCondition, offer, promocode, image);
        recyclerViewBanner.setAdapter(bannerAdapter);
        recyclerViewBanner.setLayoutManager(new LinearLayoutManager(UserPromoPage.this, LinearLayoutManager.HORIZONTAL, false));

        promationAdapter = new PromationAdapter(this, offerPromation, offerConditionPromation);
        recyclerViewPromation.setAdapter(promationAdapter);
        recyclerViewPromation.setLayoutManager(new LinearLayoutManager(UserPromoPage.this));
    }
}
