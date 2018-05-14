package com.example.oromil.boilerppate.data.local;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.example.oromil.boilerppate.EatingTableEntity;
import com.example.oromil.boilerppate.data.Eating;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.data.UserData;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DataBaseHelper {

    public static final String SPECIALITIES_QUERY = "SELECT*FROM " +
            Database.USER_DATA_TABLE_NAME;
    public static final String FOOD_QUERY = "SELECT*FROM " + Database.FOOD_TABLE_NAME;
    public static final String EATING_QUERY = "SELECT*FROM " + Database.EATING_TABLE_NAME;

    private final BriteDatabase mDb;

    @Inject
    public DataBaseHelper(DbOpenHelper dbOpenHelper) {
        this(dbOpenHelper, Schedulers.io());
    }

    public DataBaseHelper(DbOpenHelper dbOpenHelper, Scheduler scheduler) {
        SqlBrite.Builder briteBuilder = new SqlBrite.Builder();


        mDb = briteBuilder.build().wrapDatabaseHelper(dbOpenHelper, scheduler);
    }

    public Observable<UserData> getUserData() {
        return mDb.createQuery(Database.USER_DATA_TABLE_NAME, SPECIALITIES_QUERY)
                .mapToOne(Database.UserDataTable::parseCursor);
    }

    //
    public Observable<UserData> saveUserData(UserData data) {

        return Observable.create(e -> {
            BriteDatabase.Transaction transaction = mDb.newTransaction();

            try {

                // TODO: 07.05.2018 change to db.update()
                mDb.delete(Database.USER_DATA_TABLE_NAME, null);
                mDb.insert(Database.USER_DATA_TABLE_NAME, Database.UserDataTable.toContentValues(data));
                e.onNext(data);
                transaction.markSuccessful();
                e.onComplete();
            } finally {
                transaction.end();
            }
        });
    }

    public Observable<List<Food>> getFoodList() {
        return mDb.createQuery(Database.FOOD_TABLE_NAME, FOOD_QUERY)
                .mapToList(Database.FoodTable::parseCursor);
    }

    public Observable<Food> addFood(Food food) {
        return Observable.create(e -> {
            BriteDatabase.Transaction transaction = mDb.newTransaction();
            try {
                mDb.insert(Database.FOOD_TABLE_NAME, Database.FoodTable.toContentValues(food));
                e.onNext(food);
                transaction.markSuccessful();
                e.onComplete();
            } finally {
                transaction.end();
            }
        });
    }

    @SuppressLint("CheckResult")
    public void addDefaut(ArrayList<Food> food) {
        try {
            // TODO: 11.05.2018 add dispose
            getFoodList().observeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io())
                    .subscribe(foods -> {
                        if (foods == null || foods.isEmpty()) {
                            BriteDatabase.Transaction transaction = mDb.newTransaction();
                            for (Food f : food) {
                                mDb.insert(Database.FOOD_TABLE_NAME, Database.FoodTable.toContentValues(f));
                            }
                            transaction.markSuccessful();
                            transaction.end();
                        }
                    });
        } catch (Exception exxe) {
            exxe.printStackTrace();
        }
    }

    public void addEating(Eating data) {
        Observable.create((ObservableOnSubscribe<Void>) e -> {
            BriteDatabase.Transaction transaction = mDb.newTransaction();
            try {

                for (int id : data.getFoodId()) {
                    mDb.insert(Database.EATING_TABLE_NAME, Database.EatingTable.toContentValues(
                            new EatingTableEntity(data.getDate(), data.getTime(), "100", "100")
                    ));
                }
                transaction.markSuccessful();
                e.onComplete();
            } finally {
                transaction.end();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public Observable<Food> getFoodWithName(String name) {
        try {

            return mDb.createQuery(Database.FOOD_TABLE_NAME, FOOD_QUERY +
                    " WHERE " + Database.FoodTable.COLUMN_NAME +
                    " = '" + name + "'").mapToOne(new Function<Cursor, Food>() {
                @Override
                public Food apply(Cursor cursor) throws Exception {
                    return Database.FoodTable.parseCursor(cursor);
                }
            });
        } catch (Error exeption) {
            exeption.printStackTrace();
            return null;
        }
    }
}