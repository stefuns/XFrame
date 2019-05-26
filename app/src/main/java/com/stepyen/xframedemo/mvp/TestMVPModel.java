package com.stepyen.xframedemo.mvp;

import com.stepyen.xframedemo.net.ApiManage;
import com.stepyen.xframedemo.net.BaseResponse;
import com.stepyen.xframedemo.net.ExpertBaseRespoen;
import com.stepyen.xframedemo.net.entity.ExpertCategory;
import com.stepyen.xfrema.integration.IRepositoryManager;
import com.stepyen.xfrema.mvp.BaseModel;

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
