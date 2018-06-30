package com.example.donasangre.donasangre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class donations extends AppCompatActivity {
    database db = new database(this);
    ArrayList<ArrayList> donations;
    TextView dateDonated;
    TextView amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations);
        donations = db.getAllDonations();
        TextView DonationsLength = (TextView) findViewById(R.id.idDonations);
        DonationsLength.setText(""+donations.size());
        amount = (TextView) findViewById(R.id.idAmount);
        dateDonated = (TextView) findViewById(R.id.idDateDonated);
        showData();
        Toast.makeText(donations.this, "cantidad: "+ donations.get(0).get(0), Toast.LENGTH_LONG).show();
        Button btnAddDonation = (Button) findViewById(R.id.btnNvaDonation);
        btnAddDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addDonationView = new Intent (view.getContext(), addDonation.class);
                startActivityForResult(addDonationView, 0);
            }
        });
    }

    public void showData () {
        for (int i = 0; !donations.isEmpty() && i < donations.size(); i++) {
            dateDonated.setText(donations.get(i).get(0).toString());
            amount.setText(donations.get(i).get(1).toString());
        }
    }
}
