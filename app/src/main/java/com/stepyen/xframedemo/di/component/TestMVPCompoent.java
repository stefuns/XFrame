package com.stepyen.xframedemo.di.component;

import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframe.di.scope.ActivityScope;
import com.stepyen.xframedemo.di.module.TestMVPModule;
import com.stepyen.xframedemo.mvp.contract.TestMVPContract;
import com.stepyen.xframedemo.mvp.ui.activity.TestMVPLoadActivity;

import dagger.BindsInstance;
import dagger.Component;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
@ActivityScope
@Component(modules = TestMVPModule.class, dependencies = AppComponent.class)
public interface TestMVPCompoent {
    void inject(TestMVPLoadActivity activity);
    @Component.Builder
    interface Builder {
        @BindsInstance
        TestMVPCompoent.Builder view(TestMVPContract.View view);
        TestMVPCompoent.Builder appComponent(AppComponent appComponent);
        TestMVPCompoent build();
    }
}
