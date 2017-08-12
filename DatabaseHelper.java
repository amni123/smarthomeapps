package com.example.nur.smarthome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nur on 8/11/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public  DatabaseHelper(Context context)
    {
        super(context ,"lock.db",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE user (Password varchar(100))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("Drop Table IF Exist user");
        onCreate(db);
    }

    public boolean insert(String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Password " ,pass);
        db.insert("user",null,values);
        db.close();
        return false;
    }

    public Cursor password(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * from user WHERE Password = ?", null);
        return result;
    }
}
