package com.stepyen.xframedemo.mvp.model;

import com.stepyen.xframedemo.mvp.contract.TestMVPContract;
import com.stepyen.xframedemo.mvp.model.net.ApiManage;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;
import com.stepyen.xframe.integration.IRepositoryManager;
import com.stepyen.xframe.mvp.BaseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPModel extends BaseModel implements TestMVPContract.Model {

    @Inject
    public TestMVPModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory() {
        return mRepositoryManager.obtainRetrofitService(ApiManage.class)
                .getExpertCategory();
    }

}
