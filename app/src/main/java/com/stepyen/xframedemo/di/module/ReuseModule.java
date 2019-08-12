package com.stepyen.xframedemo.di.module;

import com.stepyen.xframe.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.stepyen.xframedemo.mvp.contract.ReuseContract;
import com.stepyen.xframedemo.mvp.contract.TestReuseContract;
import com.stepyen.xframedemo.mvp.model.ReuseModel;
import com.stepyen.xframedemo.mvp.model.TestReuseModel;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
@Module
public class ReuseModule {

    private ReuseContract.View mView;

    public ReuseModule(ReuseContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    ReuseContract.View provideReuseView() {
        return mView;
    }

    @ActivityScope
    @Provides
    ReuseContract.Model provideReuseModel(ReuseModel model) {
        return model;
    }
}