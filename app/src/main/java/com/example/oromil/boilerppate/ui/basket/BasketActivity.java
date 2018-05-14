package com.example.oromil.boilerppate.ui.basket;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.ui.base.BaseActivity;
import com.example.oromil.boilerppate.ui.custom.CustomSpinner;

import butterknife.BindView;

public class BasketActivity extends BaseActivity<BasketPresenter> implements BasketMvpView {

    @BindView(R.id.rvFoodList)
    RecyclerView mFoodList;

    @BindView(R.id.spiner)
    CustomSpinner mSpiner;

    @BindView(R.id.dateCard)
    ViewGroup mDateCard;

    @BindView(R.id.tvDate)
    TextView mDate;
    @BindView(R.id.tvTime)
    TextView mTime;

    @BindView(R.id.btnSave)
    FloatingActionButton mSaveFab;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_basket;
    }

    @Override
    protected void onComponentCreated(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected void setupViews() {
        super.setupViews();

        mDateCard.setOnClickListener(v -> showDatePickerDialog());

        FoodAdapter adapter = new FoodAdapter();
        mPresenter.setAdapter(adapter);

        mFoodList.setLayoutManager(new LinearLayoutManager(this));
        mFoodList.setAdapter(adapter);

        mSaveFab.setOnClickListener(v -> {
            mPresenter.saveEating(mDate.getText().toString(), mTime.getText().toString());
            onBackPressed();
        });

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, BasketActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    public void updateSpinner(Food food) {
        mSpiner.addItem(food);
    }

    public void showDatePickerDialog(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            (new DatePickerDialog(this, (view, year, month, dayOfMonth) ->
            {mDate.setText(year+"."+month+"."+dayOfMonth);showTimePickerDialog();}, 2018,1,1))
                    .show();
        }
    }

    public void showTimePickerDialog(){
        (new TimePickerDialog(this, (view, hourOfDay, minute) ->
                mTime.setText(hourOfDay+":"+minute), 0, 60, true))
                .show();
    }
}
