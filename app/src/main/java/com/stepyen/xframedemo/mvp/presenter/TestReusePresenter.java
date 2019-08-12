package com.stepyen.xframedemo.mvp.presenter;

import android.app.Application;

import com.stepyen.xframe.integration.AppManager;
import com.stepyen.xframe.di.scope.ActivityScope;
import com.stepyen.xframe.mvp.BasePresenter;
import com.stepyen.xframe.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.stepyen.xframedemo.mvp.contract.TestReuseContract;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
@ActivityScope
public class TestReusePresenter extends BasePresenter<TestReuseContract.Model, TestReuseContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public TestReusePresenter(TestReuseContract.Model model, TestReuseContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
