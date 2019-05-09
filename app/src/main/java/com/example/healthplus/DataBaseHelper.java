package com.example.healthplus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.IDN;
import java.util.Random;

public class DataBaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_PATH = "/data/data/com.example.healthplus/databases/";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HealthDB";
    private static final String TABLE_NAME = "HealthTable";


    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY, FirstName VARCHAR(30), LastName VARCHAR(30), Age VARCHAR(30), Diagnosis VARCHAR(30), Treatment VARCHAR(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public void Insert(String FirstName, String LastName, String Age, String Diagnosis, String Treatment) {
        ContentValues cvalues = new ContentValues();

        cvalues.put("FirstName", FirstName);
        cvalues.put("LastName", LastName);
        cvalues.put("Age", Age);
        cvalues.put("Diagnosis", Diagnosis);
        cvalues.put("Treatment", Treatment);


        db.insert(TABLE_NAME, null, cvalues);
    }

    private SQLiteDatabase openDataBase() {
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }
}
