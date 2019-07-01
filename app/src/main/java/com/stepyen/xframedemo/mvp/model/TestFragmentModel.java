package com.stepyen.xframedemo.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.stepyen.xframe.integration.IRepositoryManager;
import com.stepyen.xframe.mvp.BaseModel;

import com.stepyen.xframe.di.scope.FragmentScope;

import javax.inject.Inject;

import com.stepyen.xframedemo.mvp.contract.TestFragmentContract;
import com.stepyen.xframedemo.mvp.model.net.ApiManage;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;

import java.util.List;

import io.reactivex.Observable;


/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
@FragmentScope
public class TestFragmentModel extends BaseModel implements TestFragmentContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TestFragmentModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory() {
        return mRepositoryManager.obtainRetrofitService(ApiManage.class)
                .getExpertCategory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}