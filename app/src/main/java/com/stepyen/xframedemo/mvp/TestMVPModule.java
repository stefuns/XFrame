package com.stepyen.xframedemo.mvp;

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
