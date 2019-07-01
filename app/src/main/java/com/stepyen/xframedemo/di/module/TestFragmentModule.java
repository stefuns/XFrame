package com.stepyen.xframedemo.di.module;

import com.stepyen.xframe.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.stepyen.xframedemo.mvp.contract.TestFragmentContract;
import com.stepyen.xframedemo.mvp.model.TestFragmentModel;


/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
@Module
public abstract class TestFragmentModule {

    @Binds
    abstract TestFragmentContract.Model bindTestFragmentModel(TestFragmentModel model);
}