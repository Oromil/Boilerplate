package com.example.oromil.boilerppate.ui.basket;

import android.util.Log;

import com.example.oromil.boilerppate.data.DataManager;
import com.example.oromil.boilerppate.data.Eating;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.ui.ItemClickListener;
import com.example.oromil.boilerppate.ui.base.BasePresenter;
import com.example.oromil.boilerppate.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.schedulers.Schedulers;

public class BasketPresenter extends BasePresenter<BasketMvpView> {

    private DataManager mDataManager;
    private Disposable mDisposable;
    private FoodAdapter mAdapter;

    private List<Food> selectFood = new ArrayList<>();

    private ItemClickListener mCallback = new ItemClickListener() {
        @Override
        public void onClick(Food food) {
            selectFood.add(food);
            mView.updateSpinner(food);
        }
    };

    @Inject
    public BasketPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    protected void onViewAttached() {
        mDisposable = mDataManager.getFoodList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(foods -> {
                    if (mAdapter != null)
                        mAdapter.update(foods);
                });
    }

    @Override
    public void detachView() {
        RxUtils.dispose(mDisposable);
        super.detachView();
    }


    public void setAdapter(FoodAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListenerCallback(mCallback);
    }

    public void saveEating(String date, String time) {
        Eating eating = new Eating(date, time, getfoodIdList(mAdapter.getFoodList()));
        mDataManager.saveEating(eating);
    }

    private List<Integer> getfoodIdList(List<Food> foodList) {
        ArrayList<Integer> idList = new ArrayList<>();
        for (Food food : foodList) {
            idList.add(food.getId());
        }

        return idList;
    }
}
