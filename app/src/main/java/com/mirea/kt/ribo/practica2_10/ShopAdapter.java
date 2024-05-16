package com.mirea.kt.ribo.practica2_10;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private ArrayList<Shop> shops;

    public ShopAdapter(ArrayList<Shop> shops){
        this.shops=shops;
    }

    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder holder, int position) {
        Shop shop=shops.get(position);
        holder.bind(shop);
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, addressTextView, openingTimeTextView, closingTimeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.tvShopName);
            addressTextView=itemView.findViewById(R.id.tvShopAdd);
            openingTimeTextView = itemView.findViewById(R.id.tvShopTimes);
            closingTimeTextView = itemView.findViewById(R.id.tvShopTimec);
        }

        public void bind(Shop shop) {
            nameTextView.setText(shop.getName());
            addressTextView.setText(shop.getAddress());
            openingTimeTextView.setText(shop.getTimeS());
            closingTimeTextView.setText(shop.getTimeC());
        }
    }
}

