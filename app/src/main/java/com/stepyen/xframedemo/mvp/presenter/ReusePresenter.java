package com.stepyen.xframedemo.mvp.presenter;

import android.app.Application;
import android.widget.Toast;

import com.stepyen.xframe.integration.AppManager;
import com.stepyen.xframe.di.scope.ActivityScope;
import com.stepyen.xframe.mvp.BasePresenter;
import com.stepyen.xframe.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.stepyen.xframedemo.mvp.contract.ReuseContract;


/**
 * date：08/12/2019
 * author：stepyen
 * description：复用的Present
 *
 * 复用Presenter
 * https://github.com/JessYanCoding/MVPArms/issues/181
 *
 */
@ActivityScope
public class ReusePresenter extends BasePresenter<ReuseContract.Model, ReuseContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public ReusePresenter(ReuseContract.Model model, ReuseContract.View rootView) {
        super(model, rootView);
    }

    public void test() {
        mRootView.showTest();
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
