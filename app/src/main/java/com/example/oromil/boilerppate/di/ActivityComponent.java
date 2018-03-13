package com.example.oromil.boilerppate.di;

import com.example.oromil.boilerppate.ui.start.StartAcrivity;
import com.example.oromil.boilerppate.ui.start.StartActivityPresenter;

import dagger.Component;

/**
 * Created by Oromil on 13.03.2018.
 */

@Component
public interface ActivityComponent {

//    StartActivityPresenter getPresenter();

    void inject(StartAcrivity activity);
}
