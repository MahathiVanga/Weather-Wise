package com.example.weatherwise.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwise.Adapters.FutureAdapters;
import com.example.weatherwise.Domains.FutureDomain;
import com.example.weatherwise.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
        private RecyclerView.Adapter adapterTommorow;
        public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FutureActivity.this,MainActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Sat","wind","windy",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",24,16));
        items.add(new FutureDomain("Mon","storm","storm",26,10));
        items.add(new FutureDomain("Tues","rainy","rainy",23,12));
        items.add(new FutureDomain("Wed","cloudy_sunny","Cloudy Sunny",22,13));
        items.add(new FutureDomain("Thr","sun","Sunny",28,11));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new FutureAdapters(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}