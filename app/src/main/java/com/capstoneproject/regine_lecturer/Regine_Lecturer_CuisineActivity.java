package com.capstoneproject.regine_lecturer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.capstoneproject.regine_lecturer.R;

import java.util.ArrayList;

public class Regine_Lecturer_CuisineActivity extends AppCompatActivity {
    private RecyclerView recyclerView,cuisine_list;
    private ArrayList<Regine_Lecturer_Restaurant>restaurants;
    private ArrayList<Regine_Lecturer_Cuisine>cuisines;
    private Regine_Lecturer_CuisineAdapter restaurantAdapter;
    private Regine_Lecturer_OrderAdapter cuisineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swiperefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regine_lecturer_cuisine_activity);
        recyclerView = findViewById(R.id.restaurant_list);
        cuisine_list = findViewById(R.id.cuisine_list);
        swiperefresh = findViewById(R.id.swiperefresh);

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
            }
        });

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initViews();
    }
    private void pojoData(){
        restaurants = new ArrayList<>();
        cuisines = new ArrayList<>();
        restaurants.add(new Regine_Lecturer_Restaurant(1,"Rwandan","Fresh african,american,Asia Dishes","https://im1.dineout.co.in/images/uploads/restaurant/sharpen/7/d/p/p71017-15739034725dcfdc70bef47.jpg?tr=tr:n-large"));
        restaurants.add(new Regine_Lecturer_Restaurant(2,"African","Fresh african,american,Asia Dishes","https://media-cdn.tripadvisor.com/media/photo-s/19/27/0e/32/photo4jpg.jpg"));
        restaurants.add(new Regine_Lecturer_Restaurant(3,"American","Fresh african,american,Asia Dishes","https://media-cdn.tripadvisor.com/media/photo-s/0e/d9/96/54/dining-terrace-room.jpg"));
        restaurants.add(new Regine_Lecturer_Restaurant(4,"European","Fresh african,american,Asia Dishes","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png"));

        cuisines.add(new Regine_Lecturer_Cuisine(1,1,"Eggs","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
        cuisines.add(new Regine_Lecturer_Cuisine(2,1,"Chicken Fry","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Rice African"));
        cuisines.add(new Regine_Lecturer_Cuisine(3,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
        cuisines.add(new Regine_Lecturer_Cuisine(4,1,"Meat","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Rice African"));
    }
    private void initViews(){
        pojoData();
        restaurantAdapter = new Regine_Lecturer_CuisineAdapter(Regine_Lecturer_CuisineActivity.this,restaurants);
        cuisineAdapter = new Regine_Lecturer_OrderAdapter(Regine_Lecturer_CuisineActivity.this,cuisines);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(restaurantAdapter);
        LinearLayoutManager lManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cuisine_list.setLayoutManager(lManager);
        cuisine_list.setAdapter(cuisineAdapter);
        if(swiperefresh.isRefreshing()){
            swiperefresh.setRefreshing(false);
        }
    }
}