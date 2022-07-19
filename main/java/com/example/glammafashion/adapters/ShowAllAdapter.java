package com.example.glammafashion.adapters;

import android.annotation.SuppressLint;
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
import com.example.glammafashion.activities.ShowAllActivity;
import com.example.glammafashion.models.ShowAllModel;

import java.util.List;

public class ShowAllAdapter extends RecyclerView.Adapter<ShowAllAdapter.ShowAllViewHolder> {

    private Context context;
    private List<ShowAllModel> list;

    public ShowAllAdapter(ShowAllActivity showAllActivity, List<ShowAllModel> showAllModelList) {
        context = showAllActivity;
        list = showAllModelList;
    }

    @NonNull
    @Override
    public ShowAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowAllViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAllViewHolder holder, int position) {
    final ShowAllModel item= list.get(position);
        Glide.with(context).load(item.getImg_url()).into(holder.mItemImage);
        holder.mCost.setText("₹"+item.getPrice());
        holder.mName.setText(item.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed", item);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ShowAllViewHolder extends RecyclerView.ViewHolder {

        private ImageView mItemImage;
        private TextView mCost;
        private TextView mName;

        public ShowAllViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemImage=itemView.findViewById(R.id.item_image);
            mCost=itemView.findViewById(R.id.item_cost);
            mName=itemView.findViewById(R.id.item_nam);
        }
    }
}
