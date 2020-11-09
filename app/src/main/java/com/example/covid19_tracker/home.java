package com.example.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class home extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView symptoms;
    TextView precaution;
    Button covidnews;
    Button covidmaps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1= findViewById(R.id.world);
        btn2=findViewById(R.id.desh);

        symptoms= findViewById(R.id.symptoms);
        precaution= findViewById(R.id.precaution);

        covidnews= findViewById(R.id.covidnews);
        covidmaps = findViewById(R.id.covidmaps);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home.this,MainActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.covid19india.org/"));
                startActivity(j);
            }
        });
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a  =  new Intent(home.this, symptoms.class);
                startActivity(a);
            }
        });

        precaution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent precaution = new Intent(home.this,precaution.class);
                startActivity(precaution);
            }
        });
        covidnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news = new Intent(home.this,NewsActivity.class);
                startActivity(news);
            }
        });

        covidmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(home.this,MapActivity.class);
                startActivity(map);
            }
        });


    }
}