package com.stepyen.xframedemo.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;

import com.stepyen.xframedemo.mvp.contract.TestMVPContract;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;
import com.stepyen.xframe.mvp.BasePresenter;
import com.stepyen.xframe.utils.RxLifecycleUtils;

import java.util.List;

import javax.inject.Inject;

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

                                }else{
                                    mRootView.showLoadFailed();
                                }
                            }
                        })
                ;
            }
        }, 1000);
    }
}
