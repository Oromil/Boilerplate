package com.example.oromil.boilerppate.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;

import com.example.oromil.boilerppate.BoilerplateApplication;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.di.components.ConfigPersistentComponent;
import com.example.oromil.boilerppate.di.components.DaggerConfigPersistentComponent;
import com.example.oromil.boilerppate.di.modules.ActivityModule;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Oromil on 13.03.2018.
 */

public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity implements MvpView {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private long mActivityId;
    private static final LongSparseArray<ConfigPersistentComponent>
            sComponentsMap = new LongSparseArray<>();

    private ActivityComponent mActivityComponent;

    @Inject
    P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

        ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mActivityId, null);
        if (configPersistentComponent == null) {
            configPersistentComponent = createComponent();
            sComponentsMap.put(mActivityId, configPersistentComponent);
        }
        mActivityComponent = configPersistentComponent.activityComponent(new ActivityModule(this));

//        ActivityComponent component = DaggerActivityComponent.create();
        onComponentCreated(mActivityComponent);

        setContentView(getLayoutID());
        ButterKnife.bind(this);

        mPresenter.attachView(this);
    }

    protected abstract int getLayoutID();

    protected ConfigPersistentComponent createComponent(){

        return DaggerConfigPersistentComponent.builder()
                .applicationComponent(BoilerplateApplication.get(this).getComponent())
                .build();
    }

    protected abstract void onComponentCreated(ActivityComponent component);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
