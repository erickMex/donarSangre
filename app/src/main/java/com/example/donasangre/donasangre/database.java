package com.example.donasangre.donasangre;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class database extends SQLiteOpenHelper {

    public static final String database_name = "donaSangre.db";
    public database(Context context) {
        super(context, database_name , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user" +
        "(id integer primary key, name text, pass text, phone text, mail text, birthday date)");

        sqLiteDatabase.execSQL("create table activity" +
                "(id_activity integer primary key, donate_day Date, idUser int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS activity");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);
    }

    public boolean insertUser(String name, String pass, String phone, String mail, Date birthday) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        contentValues.put("phone", phone);
        contentValues.put("mail", mail);
        contentValues.put("birthday", String.valueOf(birthday));
        db.insert("user", null, contentValues);
        return true;
    }

    public boolean insertActivity(Date donate_day, int idUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("donate_day", String.valueOf(donate_day));
        contentValues.put("idUser", idUser);
        db.insert("Activity", null, contentValues);
        return true;
    }

    public boolean updateUser (Integer id, String name, String pass, String phone, String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        contentValues.put("phone", phone);
        contentValues.put("mail", mail);
        db.update("user", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }
}
