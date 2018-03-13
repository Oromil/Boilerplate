package com.example.oromil.boilerppate.ui.base;

/**
 * Created by Oromil on 13.03.2018.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V view);
    void detachView();
}
