package com.example.oromil.boilerppate.di.components;

import com.example.oromil.boilerppate.di.PerActivity;
import com.example.oromil.boilerppate.di.modules.ActivityModule;
import com.example.oromil.boilerppate.ui.start.StartAcrivity;
import com.example.oromil.boilerppate.ui.start.StartActivityPresenter;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Oromil on 13.03.2018.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

//    StartActivityPresenter getPresenter();

    void inject(StartAcrivity activity);
}
