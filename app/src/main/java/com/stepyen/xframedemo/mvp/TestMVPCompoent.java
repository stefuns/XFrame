package com.stepyen.xframedemo.mvp;

import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframe.di.scope.ActivityScope;

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
    void inject(TestMVPActivity activity);
    @Component.Builder
    interface Builder {
        @BindsInstance
        TestMVPCompoent.Builder view(TestMVPContract.View view);
        TestMVPCompoent.Builder appComponent(AppComponent appComponent);
        TestMVPCompoent build();
    }
}
