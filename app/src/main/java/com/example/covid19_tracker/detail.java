package com.example.covid19_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry,tvCases,tvRecorded,tvCritical,tvActive,tvDeaths,tvTotalCases,tvTodayDeaths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);



        getSupportActionBar().setTitle("Details of" +Affect_Countries.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        tvCountry = findViewById(R.id.tvCountryName);
        tvCases = findViewById(R.id.tvCases);
        tvRecorded = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvDeaths = findViewById(R.id.tvDeaths);
       // tvTodayDeaths = findViewById(R.id.tvTodayDeath);
        //tvTotalCases = findViewById(R.id.tvAaj);

        tvCountry.setText(Affect_Countries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(Affect_Countries.countryModelList.get(positionCountry).getCases());
        tvRecorded.setText(Affect_Countries.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(Affect_Countries.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(Affect_Countries.countryModelList.get(positionCountry).getActive());
        tvDeaths.setText(Affect_Countries.countryModelList.get(positionCountry).getDeaths());

        //tvTodayDeaths.setText(Affect_Countries.countryModelList.get(positionCountry).get());
        //tvTotalCases.setText(Affect_Countries.countryModelList.get(positionCountry).get());





    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
