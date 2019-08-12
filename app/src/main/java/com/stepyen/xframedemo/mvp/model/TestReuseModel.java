package com.stepyen.xframedemo.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.stepyen.xframe.integration.IRepositoryManager;
import com.stepyen.xframe.mvp.BaseModel;

import com.stepyen.xframe.di.scope.ActivityScope;

import javax.inject.Inject;

import com.stepyen.xframedemo.mvp.contract.TestReuseContract;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
@ActivityScope
public class TestReuseModel extends BaseModel implements TestReuseContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TestReuseModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}