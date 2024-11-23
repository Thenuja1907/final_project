package com.example.fabulous_feasts.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.R;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViiewHolder> {

    Context context;
    ArrayList date,place,offerCondition,offer,promocode,imaage;

    public BannerAdapter(Context context, ArrayList date, ArrayList place, ArrayList offerCondition, ArrayList offer, ArrayList promocode, ArrayList image){
        this.context=context;
        this.date=date;
        this.place=place;
        this.offerCondition=offerCondition;
        this.offer=offer;
        this.promocode=promocode;
        this.imaage=image;

    }
    @NonNull
    @Override
    public BannerAdapter.ViiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.card_banner,parent,false);
        return new ViiewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.ViiewHolder holder, int position) {
        holder.promocode.setText(String.valueOf(promocode.get(position)));
        holder.offer.setText(String.valueOf(offer.get(position)));
        holder.imageViewFood.setImageResource((Integer) imaage.get(position));


    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class ViiewHolder extends RecyclerView.ViewHolder {
        TextView offer,promocode;
        ImageView imageViewFood;
        public ViiewHolder(@NonNull View itemView) {
            super(itemView);
            offer=itemView.findViewById(R.id.lblOffer);
            promocode=itemView.findViewById(R.id.txtPromocode);
            imageViewFood=itemView.findViewById(R.id.imageViewFood);
        }
    }
}
