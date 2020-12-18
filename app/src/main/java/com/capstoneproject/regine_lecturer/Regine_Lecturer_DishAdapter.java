package com.capstoneproject.regine_lecturer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.capstoneproject.regine_lecturer.R;

import java.util.ArrayList;

public class Regine_Lecturer_DishAdapter extends RecyclerView.Adapter<Regine_Lecturer_DishAdapter.MyViewHolder> {
    Context context;
    ArrayList<Regine_Lecturer_Restaurant>restaurants;

    public Regine_Lecturer_DishAdapter(Context context, ArrayList<Regine_Lecturer_Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public Regine_Lecturer_DishAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regine_lecturer_restaurant_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.restaurant.setText(restaurants.get(position).getName());
        holder.rest_description.setText(restaurants.get(position).getDescription());
        Glide.with(context).load(restaurants.get(position).getImg_url()).placeholder(R.drawable.placeholder).into(holder.image);
        holder.layoutRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Regine_Lecturer_OrderActivity.class);
                intent.putExtra("restaurant_id",restaurants.get(position).getId());
                intent.putExtra("res_name",restaurants.get(position).getName());
                intent.putExtra("image_url",restaurants.get(position).getImg_url());
                intent.putExtra("description",restaurants.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView restaurant,rest_description;
        RelativeLayout layoutRestaurant;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_restaurant);
            restaurant = itemView.findViewById(R.id.restaurant);
            rest_description = itemView.findViewById(R.id.rest_description);
            layoutRestaurant = itemView.findViewById(R.id.layoutRestaurant);
        }
    }
}
