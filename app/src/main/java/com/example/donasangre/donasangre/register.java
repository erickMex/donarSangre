package com.example.donasangre.donasangre;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity{

    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText name = (EditText)findViewById(R.id.txtName);
        final EditText pass1 = (EditText) findViewById(R.id.txtPass1);
        final EditText pass2 = (EditText) findViewById(R.id.txtPass2);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);
        final EditText mail = (EditText) findViewById(R.id.txtMail);
        final EditText birthday = (EditText) findViewById(R.id.txtBirthday);
        db = new database(this);

        Button btnRegist = (Button) findViewById(R.id.btnRegist);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pass1.getText().toString().equals(pass2.getText().toString())) {
                    boolean result = db.insertUser(name.getText().toString(),
                            pass1.getText().toString(), phone.getText().toString(), mail.getText().toString(),
                            birthday.getText().toString());
                    if (result) {
                        Toast.makeText(register.this, "Usuario creado exitosamente", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(register.this, "¡Oops! hubo un error", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(register.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
