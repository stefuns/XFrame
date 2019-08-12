package com.stepyen.xframedemo.di.module;

import com.stepyen.xframe.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.stepyen.xframedemo.mvp.contract.TestReuseContract;
import com.stepyen.xframedemo.mvp.model.TestReuseModel;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
@Module
public class TestReuseModule {
    private TestReuseContract.View mView;

    public TestReuseModule(TestReuseContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    TestReuseContract.View provideTestReuseView() {
        return mView;
    }
    @ActivityScope
    @Provides
    TestReuseContract.Model provideTestReuseModel(TestReuseModel model) {
        return model;
    }
}