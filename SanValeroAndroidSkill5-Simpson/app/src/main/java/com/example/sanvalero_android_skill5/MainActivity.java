package com.example.sanvalero_android_skill5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Simpson> listSimpson;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager
                (this,LinearLayoutManager.VERTICAL,false));
        listSimpson = new ArrayList<Simpson>();

        llenarPersonajes();

        AdapterPersonajes adapter = new AdapterPersonajes(listSimpson);
        recycler.setAdapter(adapter);


    }

    private void llenarPersonajes() {
        listSimpson.add(new Simpson("Krusty", "", R.drawable.krusti));
        listSimpson.add(new Simpson("Homer", "", R.drawable.homero));
        listSimpson.add(new Simpson("Marge", "", R.drawable.marge));
        listSimpson.add(new Simpson("Bart", "", R.drawable.bart));
        listSimpson.add(new Simpson("Lisa", "", R.drawable.lisa));
        listSimpson.add(new Simpson("Magie", "", R.drawable.magie));
        listSimpson.add(new Simpson("Flanders", "", R.drawable.flanders));
        listSimpson.add(new Simpson("Milhouse", "", R.drawable.milhouse));
        listSimpson.add(new Simpson("Mr. Burns", "", R.drawable.burns));
    }
}