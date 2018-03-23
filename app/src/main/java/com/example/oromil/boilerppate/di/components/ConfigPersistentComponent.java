package com.example.oromil.boilerppate.di.components;


import com.example.oromil.boilerppate.di.ConfigPersistent;
import com.example.oromil.boilerppate.di.modules.ActivityModule;

import dagger.Component;

@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}