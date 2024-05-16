package com.mirea.kt.ribo.practica2_10;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper){
        this.sqLiteHelper=sqLiteOpenHelper;
    }

    public boolean saveShopToDatabase(Shop shop){
        SQLiteDatabase db=this.sqLiteHelper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name", shop.getName());
        cv.put("Address", shop.getAddress());
        cv.put("TimeStart", shop.getTimeS());
        cv.put("TimeClose", shop.getTimeC());
        long rowID=db.insert("TABLE_SHOP",null,cv);
        cv.clear();
        db.close();
        return rowID!=-1;
    }
    public ArrayList<Shop> loadAllShopsFromDatabase(){
        ArrayList<Shop> shops=new ArrayList<>();
        SQLiteDatabase db=this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor=db.query("TABLE_SHOP",null,null,
                null, null,null,null);
        if(dbCursor.moveToFirst()){
            do{
                String name=dbCursor.getString(dbCursor.getColumnIndexOrThrow("Name"));
                String add=dbCursor.getString(dbCursor.getColumnIndexOrThrow("Address"));
                String ts=dbCursor.getString(dbCursor.getColumnIndexOrThrow("TimeStart"));
                String tc=dbCursor.getString(dbCursor.getColumnIndexOrThrow("TimeClose"));
                shops.add(new Shop(name,add,ts,tc));
            }while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return shops;
    }


}

