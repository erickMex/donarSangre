package com.example.donasangre.donasangre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;


public class addDonation extends AppCompatActivity {

    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        final EditText ltDonated = (EditText) findViewById(R.id.txtLtDonated);
        Button addLtDonated = (Button) findViewById(R.id.btnAddDonation);
        db = new database(this);

        addLtDonated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean donated = db.insertActivity(new Date().toLocaleString(), Double.parseDouble(ltDonated.getText().toString()));
                if (donated) {
                    Toast.makeText(addDonation.this, "Success" , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(addDonation.this, "¡Ooops! Usuario no registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
