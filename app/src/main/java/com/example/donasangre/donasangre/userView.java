package com.example.donasangre.donasangre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        Button btnMaps =(Button) findViewById(R.id.btnMaps);
        Button btnInfo =(Button) findViewById(R.id.btnInfo);
        Button btnGoals =(Button) findViewById(R.id.btnGoals);
        Button btnConfig =(Button) findViewById(R.id.btnConfig);
        Button btnCalendar =(Button) findViewById(R.id.btnCalendar);
        Button btnDonation =(Button) findViewById(R.id.btnDonations);
        Button btnAddDonation =(Button) findViewById(R.id.btnAddDonation);

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapsView = new Intent(view.getContext(), maps.class);
                startActivityForResult(mapsView, 0);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoView = new Intent (view.getContext(), information.class);
                startActivityForResult(infoView, 0);
            }
        });
        btnGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goalsView = new Intent (view.getContext(), goals.class);
                startActivityForResult(goalsView, 0);
            }
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent configView = new Intent (view.getContext(), configuration.class);
                startActivityForResult(configView, 0);
            }
        });
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendarView = new Intent (view.getContext(), calendar.class);
                startActivityForResult(calendarView, 0);
            }
        });
        btnDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donationView = new Intent (view.getContext(), donations.class);
                startActivityForResult(donationView, 0);
            }
        });
    }
}
