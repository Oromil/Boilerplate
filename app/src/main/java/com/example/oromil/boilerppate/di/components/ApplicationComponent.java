package com.example.oromil.boilerppate.di.components;

import android.app.Application;
import android.content.Context;


import com.example.oromil.boilerppate.data.DataManager;
import com.example.oromil.boilerppate.di.ApplicationContext;
import com.example.oromil.boilerppate.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oromil on 19.12.2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

//    DatabaseHelper databaseHelper();

    DataManager dataManager();

}


