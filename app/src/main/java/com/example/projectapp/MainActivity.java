package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView lakeRecyclerView;
    private LakeAdapter adapter;
    private ArrayList<Lake> lakeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String JSON_URL = "https://mobprog.webug.se/json-api?login=a20fanma";
        new JsonTask(this).execute(JSON_URL);

        lakeRecyclerView = findViewById(R.id.recycler_view);
        lakeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LakeAdapter(this, lakeArrayList);
        lakeRecyclerView.setAdapter(adapter);
        lakeRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        final Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });


    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Lake>>() {}.getType();
        List<Lake> listOfLakes = gson.fromJson(json, type);
        adapter.notifyDataSetChanged();

    }
}