package com.example.oromil.boilerppate.ui.custom;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.data.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSpinner extends ConstraintLayout {
    private SpinnerAdapter mAdapter = new SpinnerAdapter();

    @BindView(R.id.header)
    ViewGroup mHeader;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.imgArrow)
    AppCompatImageView mArrow;

    public CustomSpinner(Context context) {
        this(context, null);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {

        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.custom_spinner, this);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mAdapter);

        mHeader.setOnClickListener(v -> {
            if (mRecyclerView.getVisibility() == GONE) {
                mRecyclerView.setVisibility(VISIBLE);
                mArrow.setImageResource(R.drawable.ic_arrow_up);
            } else {
                mRecyclerView.setVisibility(GONE);
                mArrow.setImageResource(R.drawable.ic_arrow_down);
            }
        });
    }

    public void setItems(ArrayList<Food> items) {
        mAdapter.update(items);
    }

    public void addItem(Food item) {
        mAdapter.addItem(item);
    }
}
