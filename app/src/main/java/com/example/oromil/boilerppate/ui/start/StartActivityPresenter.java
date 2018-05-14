package com.example.oromil.boilerppate.ui.start;

import android.util.Log;

import com.example.oromil.boilerppate.data.DataManager;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.di.ConfigPersistent;
import com.example.oromil.boilerppate.ui.base.BasePresenter;
import com.example.oromil.boilerppate.ui.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oromil on 13.03.2018.
 */

@ConfigPersistent
public class StartActivityPresenter extends BasePresenter<StartActivityMvpView> {

    private DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public StartActivityPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    // TODO: 08.05.2018
    public void addDefaultData(ArrayList<Food> foods) {

        mDataManager.addDefaultData(foods);
    }
}
