package com.stepyen.xframedemo.mvp.contract;

import com.stepyen.xframe.mvp.ILoadView;
import com.stepyen.xframe.mvp.IModel;
import com.stepyen.xframe.mvp.IView;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;

import java.util.List;

import io.reactivex.Observable;


/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
public interface TestFragmentContract {

    public interface View extends ILoadView {
        void onShowExpertCategory(List<ExpertCategory> data);
    }

    public interface Model extends IModel{
        Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory();
    }
}
