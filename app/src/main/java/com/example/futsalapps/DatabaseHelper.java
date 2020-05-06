package com.example.futsalapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.view.Display;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constant.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constant.TABLE_NAME);
        onCreate(db);

    }

    public long insertInfo (String name, String date, String time, String period, String add_timestamp){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constant.C_NAME, name);
        values.put(Constant.C_DATE, date);
        values.put(Constant.C_TIME, time);
        values.put(Constant.C_PERIOD, period);
        values.put(Constant.C_ADD_TIMESTAMP, add_timestamp);

        long id = db.insert(Constant.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public ArrayList<Model> getAllData(String orderby){

        ArrayList<Model> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+Constant.TABLE_NAME+" ORDER BY "+orderby;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToNext()){
            do {
                Model model = new Model(
                        ""+cursor.getInt(cursor.getColumnIndex(Constant.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(Constant.C_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex(Constant.C_DATE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constant.C_TIME)),
                        ""+cursor.getString(cursor.getColumnIndex(Constant.C_PERIOD)),
                        ""+cursor.getString(cursor.getColumnIndex(Constant.C_ADD_TIMESTAMP))
                );

                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}
