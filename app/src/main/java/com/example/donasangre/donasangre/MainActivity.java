package com.example.donasangre.donasangre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    database db;
    // AlertDialog alertDialog = new AlertDialog.Builder(this).create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new database(this);
        final EditText txtUser = (EditText) findViewById(R.id.txtUser);
        final EditText txtPass = (EditText) findViewById(R.id.txtPass);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent (view.getContext(), register.class);
                startActivityForResult(intentRegister, 0);
            }
        });

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean login = db.getUser(txtUser.getText().toString(), txtPass.getText().toString());
                if (login) {
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                    Intent userView = new Intent(view.getContext(), userView.class);
                    startActivityForResult(userView, 0);
                } else {
                    Toast.makeText(MainActivity.this, "¡Ooops! Usuario no registrado", Toast.LENGTH_LONG).show();
                }
                /* alertDialog.setTitle("Alert");
                alertDialog.setMessage("Alert message to be shown");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show(); */
                //if (txtUser.getText().equals("user") && txtPass.getText().toString().equals("admin")) {
                    /* Intent userView = new Intent(view.getContext(), userView.class);
                    startActivityForResult(userView, 0); */
                //}
            }
        });
    }
}
