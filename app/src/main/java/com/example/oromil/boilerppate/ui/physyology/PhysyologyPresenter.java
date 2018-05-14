package com.example.oromil.boilerppate.ui.physyology;

import com.example.oromil.boilerppate.di.ConfigPersistent;
import com.example.oromil.boilerppate.ui.base.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class PhysyologyPresenter extends BasePresenter<PhysyologyMvpView> {

    @Inject
    public PhysyologyPresenter(){}
}
