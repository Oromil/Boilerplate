package com.example.oromil.boilerppate.ui.blank;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.di.components.ActivityComponent;
import com.example.oromil.boilerppate.ui.base.BaseActivity;
import com.example.oromil.boilerppate.utils.StringUtils;

import butterknife.BindView;

public class BlankActivity extends BaseActivity<BlankPresenter> implements BlankMvpView {

    @BindView(R.id.etName)
    EditText mEtName;
    @BindView(R.id.etSurname)
    EditText mEtSurname;
    @BindView(R.id.etHeight)
    EditText mEtHeight;
    @BindView(R.id.etWeight)
    EditText mEtWeight;
    @BindView(R.id.etPatronymic)
    EditText mEtPatronymic;
    @BindView(R.id.etDiagnosis)
    EditText mEtDiagnosis;

    @BindView(R.id.fabSave)
    FloatingActionButton mFab;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_blank;
    }

    @Override
    protected void onComponentCreated(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected void setupViews() {
        super.setupViews();

        mFab.setOnClickListener(v -> {
            mPresenter.saveUserData(StringUtils.getStringFromEditText(mEtSurname),
                    StringUtils.getStringFromEditText(mEtName),
                    StringUtils.getStringFromEditText(mEtPatronymic),
                    "male",
                    StringUtils.getStringFromEditText(mEtHeight),
                    StringUtils.getStringFromEditText(mEtWeight),
                    StringUtils.getStringFromEditText(mEtDiagnosis));
            onBackPressed();
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, BlankActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }
}
