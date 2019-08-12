package com.stepyen.xframedemo.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframedemo.di.module.ReuseModule;
import com.stepyen.xframedemo.di.module.TestReuseModule;
import com.stepyen.xframedemo.mvp.contract.TestReuseContract;

import com.stepyen.xframe.di.scope.ActivityScope;
import com.stepyen.xframedemo.mvp.ui.activity.TestReuseActivity;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
@ActivityScope
@Component(modules = {TestReuseModule.class, ReuseModule.class} , dependencies = AppComponent.class)
public interface TestReuseComponent {
    void inject(TestReuseActivity activity);

}