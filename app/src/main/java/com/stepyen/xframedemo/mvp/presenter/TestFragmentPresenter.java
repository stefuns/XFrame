package com.stepyen.xframedemo.mvp.presenter;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;

import com.stepyen.xframe.integration.AppManager;
import com.stepyen.xframe.di.scope.FragmentScope;
import com.stepyen.xframe.mvp.BasePresenter;
import com.stepyen.xframe.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.stepyen.xframe.utils.RxLifecycleUtils;
import com.stepyen.xframedemo.mvp.contract.TestFragmentContract;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;

import java.util.List;


/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
@FragmentScope
public class TestFragmentPresenter extends BasePresenter<TestFragmentContract.Model, TestFragmentContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public TestFragmentPresenter(TestFragmentContract.Model model, TestFragmentContract.View rootView) {
        super(model, rootView);
    }


    public void getExpertCategory() {
        mRootView.showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mModel.getExpertCategory()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                        .subscribe(new ErrorHandleSubscriber<BaseResponse<List<ExpertCategory>>>(mErrorHandler) {
                            @Override
                            public void onNext(BaseResponse<List<ExpertCategory>> response) {
                                if (response != null && response.isSuccess()) {
                                    mRootView.showLoadSuccess();
                                    mRootView.onShowExpertCategory(response.data);
                                } else {
                                    mRootView.showLoadFailed();
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                super.onError(t);
                                mRootView.showLoadFailed();
                            }
                        })
                ;
            }
        }, 1000);

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
