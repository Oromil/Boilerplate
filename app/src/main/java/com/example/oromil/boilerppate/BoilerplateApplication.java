package com.example.oromil.boilerppate;

import android.app.Application;
import android.content.Context;

import com.example.oromil.boilerppate.di.components.ApplicationComponent;
import com.example.oromil.boilerppate.di.components.DaggerApplicationComponent;
import com.example.oromil.boilerppate.di.modules.ApplicationModule;
import com.facebook.stetho.Stetho;

/**
 * Created by Oromil on 13.03.2018.
 */

public class BoilerplateApplication extends Application {

    private static ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    public static BoilerplateApplication get(Context context){
        return (BoilerplateApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mComponent == null) {
            mComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mComponent;
    }

    private void initStetho() {
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }
}
