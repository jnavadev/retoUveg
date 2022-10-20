package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class RestauranteActivity extends AppCompatActivity {

    List<ListElementRestaurante> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElementRestaurante("#775447", "Restaurante A"));
        elements.add(new ListElementRestaurante("#775447", "Restaurante B"));
        elements.add(new ListElementRestaurante("#775447", "Restaurante C"));
        elements.add(new ListElementRestaurante("#775447", "Restaurante D"));

        ListAdapterRest listAdapter = new ListAdapterRest(elements, this, new ListAdapterRest.OnItemClickListener() {
            @Override
            public void onItemClick(ListElementRestaurante item) {
                moveToDescription(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }


    public void moveToDescription(ListElementRestaurante item) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
    }
}