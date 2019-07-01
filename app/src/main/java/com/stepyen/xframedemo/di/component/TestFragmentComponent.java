package com.stepyen.xframedemo.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframedemo.di.module.TestFragmentModule;
import com.stepyen.xframedemo.mvp.contract.TestFragmentContract;

import com.stepyen.xframe.di.scope.FragmentScope;
import com.stepyen.xframedemo.mvp.ui.fragment.TestFragmentFragment;


/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
@FragmentScope
@Component(modules = TestFragmentModule.class, dependencies = AppComponent.class)
public interface TestFragmentComponent {
    void inject(TestFragmentFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TestFragmentComponent.Builder view(TestFragmentContract.View view);

        TestFragmentComponent.Builder appComponent(AppComponent appComponent);

        TestFragmentComponent build();
    }
}