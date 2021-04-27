package com.example.markattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AttendListener{

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(1, "name1", 2009, "cse"));
        modelClassList.add(new ModelClass(2, "name2", 2019, "cse"));

        Adapter adapter = new Adapter(this, modelClassList,this );
        recyclerview.setAdapter(adapter);
        recyclerview.setHasFixedSize(true);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttendChange(List<ModelClass> ModelClassList) {
        Toast.makeText(this,ModelClassList.toString(), Toast.LENGTH_SHORT).show();
    }
}
