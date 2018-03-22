package com.example.oromil.boilerppate.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.oromil.boilerppate.di.ActivityComponent;
import com.example.oromil.boilerppate.di.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Oromil on 13.03.2018.
 */

public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity implements MvpView {

    @Inject
    P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityComponent component = DaggerActivityComponent.create();
        onComponentCreated(component);

        setContentView(getLayoutID());
        ButterKnife.bind(this);

        mPresenter.attachView(this);
    }

    protected abstract int getLayoutID();

    protected abstract void onComponentCreated(ActivityComponent component);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
