package com.example.fabulous_feasts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.Models.UserProductModel;
import com.example.fabulous_feasts.R;

import java.util.List;

public class UserProductAdapter extends RecyclerView.Adapter<UserProductAdapter.ProductViewHolder> {
    Context context;
    List<UserProductModel> productsList;

    public UserProductAdapter(Context context, List<UserProductModel> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_product_detail_list, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        UserProductModel userProduct = productsList.get(position);

        holder.productImage.setImageResource(userProduct.getImageUrl());
        holder.productName.setText(userProduct.getProductName());
        holder.productDes.setText(userProduct.getProductAbout());
        holder.productQty.setText(userProduct.getProductQty());
        holder.productPrice.setText(userProduct.getProductPrice());

        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productDes, productQty, productPrice;
        Button btnAddCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage1);
            productName = itemView.findViewById(R.id.productName1);
            productDes = itemView.findViewById(R.id.productDescript1);
            productQty = itemView.findViewById(R.id.productQuantity1);
            productPrice = itemView.findViewById(R.id.productPrice1);
            btnAddCart = itemView.findViewById(R.id.btnCart);
        }
    }
}
