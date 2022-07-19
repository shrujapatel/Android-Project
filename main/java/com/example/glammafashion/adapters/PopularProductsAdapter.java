package com.example.glammafashion.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.glammafashion.R;
import com.example.glammafashion.activities.DetailedActivity;
import com.example.glammafashion.models.PopularProductsModel;

import java.util.List;

public class PopularProductsAdapter extends RecyclerView.Adapter<PopularProductsAdapter.PopularProductsViewHolder> {

    private final Context context;
    private final List<PopularProductsModel> popularProductsModellist;

    public PopularProductsAdapter(Context context, List<PopularProductsModel> popularProductsModellist) {
        this.context = context;
        this.popularProductsModellist = popularProductsModellist;
    }

    @NonNull
    @Override
    public PopularProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PopularProductsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_items, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull PopularProductsViewHolder holder, int position) {

        final PopularProductsModel item = popularProductsModellist.get(position);
        Glide.with(context).load(item.getImg_url()).into(holder.imageView);
        holder.name.setText(item.getName());
        holder.price.setText(String.valueOf(item.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed", item);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return popularProductsModellist.size();
    }

    public class PopularProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price;

        public PopularProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.all_img);
            name = itemView.findViewById(R.id.all_product_name);
            price = itemView.findViewById(R.id.all_price);
        }

    }
}

