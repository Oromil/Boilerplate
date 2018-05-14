package com.example.oromil.boilerppate.ui.basket;

import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.ui.base.MvpView;

public interface BasketMvpView extends MvpView {
    void updateSpinner(Food food);
}
