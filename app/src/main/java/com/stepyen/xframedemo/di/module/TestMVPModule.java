package com.stepyen.xframedemo.di.module;

import com.stepyen.xframedemo.mvp.contract.TestMVPContract;
import com.stepyen.xframedemo.mvp.model.TestMVPModel;

import dagger.Binds;
import dagger.Module;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
@Module
public abstract class TestMVPModule {

    @Binds
    abstract TestMVPContract.Model bindTestMVPModel(TestMVPModel model);

}
