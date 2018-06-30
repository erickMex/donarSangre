package com.example.donasangre.donasangre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

public class database extends SQLiteOpenHelper {

    public static final String database_name = "donaSangre.db";
    public database(Context context) {
        super(context, database_name , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user" +
        "(id integer primary key, name text, pass text, phone text, mail text, birthday text)");

        sqLiteDatabase.execSQL("create table activity" +
                "(id_activity integer primary key, donate_day text, ltDonated double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS activity");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);
    }

    public boolean insertUser(String name, String pass, String phone, String mail, String birthday) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        contentValues.put("phone", phone);
        contentValues.put("mail", mail);
        contentValues.put("birthday", birthday);
        db.insert("user", null, contentValues);
        return true;
    }

    public boolean insertActivity(String donate_day, double ltDonated) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("donate_day", donate_day);
        contentValues.put("ltDonated", ltDonated);
        db.insert("activity", null, contentValues);
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

    public int numberOfDonatedRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "activity");
        return numRows;
    }

    public boolean getUser(String mail, String password) {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from user where pass like '"+password+"' AND mail like '"+ mail+"'", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        if (array_list.size() > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ArrayList> getAllDonations() {
        ArrayList<ArrayList> array_list = new ArrayList<ArrayList>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from activity", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            ArrayList<String> array_aux = new ArrayList<String>();
            array_aux.add(res.getString(res.getColumnIndex("donate_day")));
            array_aux.add(res.getString(res.getColumnIndex("ltDonated")));
            array_list.add(array_aux);
            res.moveToNext();
        }
        return array_list;
    }
}
