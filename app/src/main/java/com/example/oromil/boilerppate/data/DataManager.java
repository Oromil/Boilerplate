package com.example.oromil.boilerppate.data;

import android.util.Log;

import com.example.oromil.boilerppate.data.local.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oromil on 13.03.2018.
 */

@Singleton
public class DataManager {

    private DataBaseHelper mHelper;

    @Inject
    public DataManager(DataBaseHelper helper) {
        mHelper = helper;
    }

    public void saveUserData(UserData data) {
        mHelper.saveUserData(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public Observable<UserData> getUserData() {
        return mHelper.getUserData();
    }

    public Observable<Food> addFood(Food food) {
        return mHelper.addFood(food);
    }

    public Observable<List<Food>> getFoodList() {
        return mHelper.getFoodList();
    }

    public void addDefaultData(ArrayList<Food> food) {
        mHelper.addDefaut(food);
    }

    public void saveEating(Eating data) {
        mHelper.addEating(data);
    }

    public Observable<Integer> getFoodId(Food food) {
        return mHelper.getFoodWithName(food.getName())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Function<Food, Integer>() {
                    @Override
                    public Integer apply(Food food1) throws Exception {
                        return food1.getId();
                    }
                });
    }

}
