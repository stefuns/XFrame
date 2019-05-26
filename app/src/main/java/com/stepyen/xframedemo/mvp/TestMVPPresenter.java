package com.stepyen.xframedemo.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.stepyen.xframedemo.net.BaseResponse;
import com.stepyen.xframedemo.net.ExpertBaseRespoen;
import com.stepyen.xframedemo.net.entity.ExpertCategory;
import com.stepyen.xfrema.mvp.BasePresenter;
import com.stepyen.xfrema.mvp.IModel;
import com.stepyen.xfrema.utils.RxLifecycleUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPPresenter extends BasePresenter<TestMVPContract.Model, TestMVPContract.View> {

    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    public TestMVPPresenter(TestMVPContract.Model model, TestMVPContract.View view) {
        super(model,view);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        getExpertCategory();
    }

    public void getExpertCategory() {

        mModel.getExpertCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<List<ExpertCategory>>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<List<ExpertCategory>> response) {
                        if (response != null && response.isSuccess()) {
                            mRootView.onShowExpertCategory(response.data);
                        }else{
                            mRootView.showLoadFailed();
                        }
                    }
                })

        ;


    }
}
