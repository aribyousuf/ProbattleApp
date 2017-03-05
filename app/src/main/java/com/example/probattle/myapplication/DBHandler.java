package com.example.probattle.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by probattle on 3/4/2017.
 */
public class DBHandler extends SQLiteOpenHelper {

    public  SQLiteDatabase db;

    private static final String DB = "Stock.db";
    private static final int version = 1;

    ArrayList<String> array ;

    private static final String Table = "Stock";

    private static final String  id = "Id";
    private static final String  companyName = "CompanyName";
    private static final String  stockPrice = "StockPrice";
    private static final String  timeStamp = "TimeStamp";

    public  static  final String Query = "CREATE TABLE  " + Table + " ( " +id+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + companyName + " TEXT , " + stockPrice + " TEXT, " +  timeStamp + " TEXT ) ";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB, factory, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //"create table Stock ( Id INTEGER PRIMARY KEY AUTO INCREMENT, Company_Name TEXT  )";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        db.execSQL(Query);

    }

    public void Insert(String name, String price, String time)
    {
        ContentValues cv = new ContentValues();
        cv.put(companyName, name);
        cv.put(stockPrice, price);
        cv.put(timeStamp, time);
        this.getWritableDatabase().insertOrThrow(Table,null,cv);

    }

    public void View(String name){
        Cursor cr  =this.getReadableDatabase().rawQuery("SELECT * FROM " + Table + " WHERE " + companyName + " = " + name, null);
        array = new ArrayList<>();
        while (cr.moveToNext()){
             array.add(cr.getString(0));
            array.add(cr.getString(1));
            array.add(cr.getString(2));
        }
    }

    public ArrayList<String> getVal(String name){
      ArrayList<String> my = new ArrayList<>();
       String q = "SELECT " + stockPrice + " FROM " + Table + " WHERE " + companyName + " = '" + name + "' ORDER BY " + id + " DESC LIMIT 2";
        Cursor cr = this.getReadableDatabase().rawQuery(q,null);
        while (cr.moveToNext()){
            my.add(cr.getString(0));
        }
        return  my;

    }

}
