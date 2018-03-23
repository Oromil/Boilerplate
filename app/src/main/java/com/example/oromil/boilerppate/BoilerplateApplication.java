package com.example.oromil.boilerppate;

import android.app.Application;
import android.content.Context;

import com.example.oromil.boilerppate.di.components.ApplicationComponent;
import com.example.oromil.boilerppate.di.components.DaggerApplicationComponent;
import com.example.oromil.boilerppate.di.modules.ApplicationModule;

/**
 * Created by Oromil on 13.03.2018.
 */

public class BoilerplateApplication extends Application {

    private static ApplicationComponent mComponent;

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
}
