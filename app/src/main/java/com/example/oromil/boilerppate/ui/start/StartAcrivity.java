package com.example.oromil.boilerppate.ui.start;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.ui.base.BaseActivity;
import com.example.oromil.boilerppate.ui.basket.BasketActivity;
import com.example.oromil.boilerppate.ui.blank.BlankActivity;
import com.example.oromil.boilerppate.ui.physyology.PhysyologyActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class StartAcrivity extends BaseActivity<StartActivityPresenter> implements StartActivityMvpView, NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.fab2)
    FloatingActionButton mBasketFab;
    @BindView(R.id.fab1)
    FloatingActionButton mCalibrationFab;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onComponentCreated(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adddefaultdata();
    }

    @Override
    protected void setupViews() {
        super.setupViews();

        setSupportActionBar(mToolbar);

        mBasketFab.setOnClickListener(v -> BasketActivity.start(StartAcrivity.this));

        mCalibrationFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mFab.setOnClickListener(view -> {
            if (mBasketFab.getVisibility()==View.GONE){
                showFabMenu(View.VISIBLE);
            }else showFabMenu(View.GONE);
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_blank) {
            BlankActivity.start(this);
        } else if (id == R.id.nav_physyology) {
            PhysyologyActivity.start(this);
        } else if (id == R.id.nav_statistic) {

        } else if (id == R.id.nav_consumables_changing) {

        } else if (id == R.id.nav_start) {

        } else if (id == R.id.nav_settings) {

        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // TODO: 08.05.2018
    private void adddefaultdata(){
        ArrayList<Food> food = new ArrayList<>();
        food.add(new Food("Хлеб", "100"));
        food.add(new Food("Мясо", "100"));
        food.add(new Food("Овощи", "100"));
        food.add(new Food("Каша", "100"));

        mPresenter.addDefaultData(food);
    }

    private void showFabMenu(int visibility){
        mBasketFab.setVisibility(visibility);
        mCalibrationFab.setVisibility(visibility);
    }

}
