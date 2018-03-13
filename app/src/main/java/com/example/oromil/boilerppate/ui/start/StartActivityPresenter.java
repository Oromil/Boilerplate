package com.example.oromil.boilerppate.ui.start;

import android.util.Log;

import com.example.oromil.boilerppate.ui.base.BasePresenter;
import com.example.oromil.boilerppate.ui.base.Presenter;

import javax.inject.Inject;

/**
 * Created by Oromil on 13.03.2018.
 */

public class StartActivityPresenter extends BasePresenter<StartActivityMvpView>{

    @Inject
    public StartActivityPresenter(){

    }

    @Override
    protected void onViewAttached() {
        start();
    }

    public void start(){
        Log.d("test", "Hello, World!");
    }
}
