package com.example.simranjeetsinghdhillon_mapd711_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Output extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView output = findViewById(R.id.output);

        Intent i = getIntent();
        String a = i.getStringExtra("1");
        String b = i.getStringExtra("2");
        String c = i.getStringExtra("3");
        String d = i.getStringExtra("4");
        String e = i.getStringExtra("5");

        output.setText("Car Id: "+a+ "\n"+"Car Brand: "+b+"\n"+"Car Model: "+c+"\n"+"Year: "+d+"\n"+"Price: "+e);




     }
}
