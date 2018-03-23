package com.example.oromil.boilerppate.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.oromil.boilerppate.data.network.Api;
import com.example.oromil.boilerppate.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Oromil on 19.12.2017.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Api provideApi() {
        return Api.Creator.createApi();
    }

}
