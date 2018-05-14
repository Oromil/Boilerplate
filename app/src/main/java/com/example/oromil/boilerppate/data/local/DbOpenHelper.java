package com.example.oromil.boilerppate.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.oromil.boilerppate.di.ApplicationContext;

import javax.inject.Inject;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "InsulinPump.db";
    public static final int DATABASE_VERSION = 1;

    @Inject
    public DbOpenHelper(@ApplicationContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.execSQL("PRAGMA foregin_keys = 1");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.beginTransaction();
        try {
            sqLiteDatabase.execSQL(Database.UserDataTable.CREATE);
            sqLiteDatabase.execSQL(Database.FoodTable.CREATE);
            sqLiteDatabase.execSQL(Database.EatingTable.CREATE);
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
