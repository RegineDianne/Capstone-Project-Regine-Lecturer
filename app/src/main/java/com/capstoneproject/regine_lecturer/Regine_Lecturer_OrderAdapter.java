package com.capstoneproject.regine_lecturer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.capstoneproject.regine_lecturer.R;

import java.util.ArrayList;

public class Regine_Lecturer_OrderAdapter extends RecyclerView.Adapter<Regine_Lecturer_OrderAdapter.MyViewHolder> {
    private static final String TAG = "CuisineAdapter";
    Context context;
    ArrayList<Regine_Lecturer_Cuisine>cuisines;

    public Regine_Lecturer_OrderAdapter(Context context, ArrayList<Regine_Lecturer_Cuisine> cuisines) {
        this.context = context;
        this.cuisines = cuisines;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regine_lecturer_cuisine_item, parent, false);
        Regine_Lecturer_OrderAdapter.MyViewHolder holder = new Regine_Lecturer_OrderAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cuisine.setText(cuisines.get(position).getName());
        holder.cuisine_price.setText(cuisines.get(position).getPrice());
        Glide.with(context).load(cuisines.get(position).getImage_url()).placeholder(R.drawable.placeholder).placeholder(R.drawable.loader).into(holder.cuisine_img);
        holder.cuisine_img.setVisibility(View.VISIBLE);
        holder.progress_img.setVisibility(View.GONE);
        holder.cuisine_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image: " + cuisines.get(position).getName());
                Intent intent = new Intent(context, Regine_Lecturer_OrderDetail.class);
                intent.putExtra("dish_name",cuisines.get(position).getName());
                intent.putExtra("image_url",cuisines.get(position).getImage_url());
                intent.putExtra("description",cuisines.get(position).getDescription());
                intent.putExtra("price",cuisines.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cuisines.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView cuisine_img;
        TextView cuisine,cuisine_price;
        ProgressBar progress_img;
        public MyViewHolder(View itemView) {
            super(itemView);
            cuisine_img = itemView.findViewById(R.id.img_cuisine);
            cuisine = itemView.findViewById(R.id.cuisine);
            cuisine_price = itemView.findViewById(R.id.cuisine_price);
            progress_img = itemView.findViewById(R.id.progress_img);
        }
    }
}
