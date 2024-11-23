package com.example.fabulous_feasts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.R;

import java.util.ArrayList;

public class PromationAdapter extends RecyclerView.Adapter<PromationAdapter.myViewHolder> {

    Context context;
    ArrayList offerCondition,offer;

    public PromationAdapter(Context context, ArrayList offerCondition, ArrayList offer){
        this.context=context;
        this.offerCondition=offerCondition;
        this.offer=offer;

    }
    @NonNull
    @Override
    public PromationAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.card_promation,parent,false);
        return new PromationAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromationAdapter.myViewHolder holder, int position) {
        holder.offer.setText(String.valueOf(offer.get(position)));
        holder.offerCondition.setText(String.valueOf(offerCondition.get(position)));

    }

    @Override
    public int getItemCount() {
        return offer.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView offer,offerCondition;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            offerCondition=itemView.findViewById(R.id.lblOffer);
            offer=itemView.findViewById(R.id.lblOfferCondition);
        }
    }

}
