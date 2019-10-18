package com.example.simranjeetsinghdhillon_mapd711_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarActivity extends AppCompatActivity {

    Button addInventoryData;
    String [] a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        a = new String[] {"1","2","3","4","5"};

        addInventoryData = findViewById(R.id.button);
        final ListView listView = findViewById(R.id.listview);
        listView.setVisibility(View.GONE);

        addInventoryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                Cars cars1 = new Cars(1,"Audi","A4",1999,5000000.0);
                Cars cars2 = new Cars(2,"BMW","X6",1998,6000000.0);
                Cars cars3 = new Cars(3,"RangeRover","Evoque",1997,7000000.0);
                Cars cars4 = new Cars(4,"Jaquar","Z1",1996,8000000.0);
                Cars cars5 = new Cars(5,"Honda","bhag",1995,9000000.0);


                CarManager carManager = new CarManager(getApplicationContext());
                carManager.insert(cars1);
                carManager.insert(cars2);
                carManager.insert(cars3);
                carManager.insert(cars4);
                carManager.insert(cars5);

                listView.setVisibility(View.VISIBLE);
                ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, a);

                listView.setAdapter(arrayAdapter);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CarManager carManager = new CarManager(getApplicationContext());
                Cars cars =carManager.read(position+1);
                Intent i = new Intent(CarActivity.this,Output.class);
                i.putExtra("1",String.valueOf(cars.getCarId()));
                i.putExtra("2",cars.getBrandName());
                i.putExtra("3",cars.getModel());
                i.putExtra("4",String.valueOf(cars.getYear()));
                i.putExtra("5",String.valueOf(cars.getPrice()));
                startActivity(i);

            }
        });



    }
}

