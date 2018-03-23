package com.example.oromil.boilerppate.ui.start;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.ui.base.BaseActivity;

import javax.inject.Inject;

public class StartAcrivity extends BaseActivity<StartActivityPresenter> implements StartActivityMvpView{

    @Inject
    StartActivityPresenter presenter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_start_acrivity;
    }

    @Override
    protected void onComponentCreated(ActivityComponent component) {
        component.inject(this);
    }
}
