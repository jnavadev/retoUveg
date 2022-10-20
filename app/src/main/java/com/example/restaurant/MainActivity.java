package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElementComida> elements;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



    }

    public void init(){
        elements = new ArrayList<>();
        Button btn;
        elements.add(new ListElementComida("#775447","Comida A","99.00","Disponible"));
        elements.add(new ListElementComida("#607d8b","Comida B","150.00","Disponible"));
        elements.add(new ListElementComida("#03a9f4","Comida C","20.00","Agotado"));
        elements.add(new ListElementComida("#f44336","Comida D","50.00","Disponible"));
        elements.add(new ListElementComida("#775447","Comida E","99.00","Disponible"));
        elements.add(new ListElementComida("#607d8b","Comida F","150.00","Disponible"));
        elements.add(new ListElementComida("#607d8b","Comida G","130.00","Agotado"));
        elements.add(new ListElementComida("#03a9f4","Comida H","80.00","Agotado"));


        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElementComida item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }

    public void moveToDescription(ListElementComida item){
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
    }


    public void onClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RestauranteActivity.class);
                startActivity(intent);
            }
        });

    }
}