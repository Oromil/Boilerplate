package com.example.oromil.boilerppate.ui.physyology;

import android.content.Context;
import android.content.Intent;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.ui.base.BaseActivity;

public class PhysyologyActivity extends BaseActivity<PhysyologyPresenter> implements PhysyologyMvpView {
    @Override
    protected int getLayoutID() {
        return R.layout.activity_physyology;
    }

    @Override
    protected void onComponentCreated(ActivityComponent component) {
        component.inject(this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, PhysyologyActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }
}
