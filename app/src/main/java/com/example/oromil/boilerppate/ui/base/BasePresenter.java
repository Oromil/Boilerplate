package com.example.oromil.boilerppate.ui.base;

/**
 * Created by Oromil on 13.03.2018.
 */

public abstract class BasePresenter<V extends MvpView> implements Presenter<V>{

    protected V mView;

    @Override
    public void attachView(V view) {
        mView = view;
        onViewAttached();
    }

    @Override
    public void detachView() {
        mView = null;
    }

    protected void onViewAttached(){}
}
