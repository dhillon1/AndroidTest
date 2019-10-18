package com.example.simranjeetsinghdhillon_mapd711_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CarManager extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CarManager.db";

    public static final String TABLE_NAME = "CarManagerTable";
    public static final String COLUMN_NAME1 = "carId";
    public static final String COLUMN_NAME2 = "brandName";
    public static final String COLUMN_NAME3 = "model";
    public static final String COLUMN_NAME4 = "year";
    public static final String COLUMN_NAME5 = "price";
    SQLiteDatabase sqLiteDatabase1;
    SQLiteDatabase sqLiteDatabase4;


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME1 + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME2 + " TEXT," +
                    COLUMN_NAME3 + " TEXT," +
                    COLUMN_NAME4 + " INTEGER," +
                    COLUMN_NAME5 + " REAL" +
                    ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;




    public CarManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sqLiteDatabase1 = this.getWritableDatabase();
        sqLiteDatabase4 = this.getReadableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long insert(Cars cars){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME1, cars.getCarId());
        values.put(COLUMN_NAME2, cars.getBrandName());
        values.put(COLUMN_NAME3, cars.getModel());
        values.put(COLUMN_NAME4, cars.getYear());
        values.put(COLUMN_NAME5, cars.getPrice());

        long a =sqLiteDatabase1.insert(TABLE_NAME,null,values);
        return a;
    }

    public Cars read (int id){

        String[] projection = {
                COLUMN_NAME1,
                COLUMN_NAME2,
                COLUMN_NAME3,
                COLUMN_NAME4,
                COLUMN_NAME5
        };

        String selection = COLUMN_NAME1 + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = sqLiteDatabase4.query(
                TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        Cars cars = new Cars();
        while(cursor.moveToNext()) {

            cars.setCarId(cursor.getInt(0));
            cars.setBrandName(cursor.getString(1));
            cars.setModel(cursor.getString(2));
            cars.setYear(cursor.getInt(3));
            cars.setPrice(cursor.getDouble(4));

        }
        cursor.close();
        return cars;
    }




}
