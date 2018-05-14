package com.example.oromil.boilerppate.ui.blank;

import com.example.oromil.boilerppate.data.DataManager;
import com.example.oromil.boilerppate.data.UserData;
import com.example.oromil.boilerppate.di.ConfigPersistent;
import com.example.oromil.boilerppate.ui.base.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class BlankPresenter extends BasePresenter<BlankMvpView> {

    private DataManager mDataManager;

    @Inject
    public BlankPresenter(DataManager dataManager){
        mDataManager = dataManager;
    }

    public void saveUserData(String surname, String name, String patronymic, String male,
                             String height, String weight, String diagmosis){

        UserData data = UserData.newBuilder()
                .surname(surname)
                .name(name)
                .patronymic(patronymic)
                .gender(male)
                .height(height)
                .diagnosis(diagmosis)
                .weight(weight)
                .build();

        mDataManager.saveUserData(data);
    }
}
