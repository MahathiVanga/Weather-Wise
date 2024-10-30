package com.example.weatherwise.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwise.Adapters.HourlyAdapters;
import com.example.weatherwise.Domains.Hourly;
import com.example.weatherwise.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterHourly;
private  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn= findViewById(R.id.nextbtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,FutureActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("10 pm",29,"sun"));
        items.add(new Hourly("11 pm",30,"wind"));
        items.add(new Hourly("12 am",29,"rainy"));
        items.add(new Hourly("2 am",28,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
}