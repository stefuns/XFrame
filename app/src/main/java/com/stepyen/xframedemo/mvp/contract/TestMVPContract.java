package com.stepyen.xframedemo.mvp.contract;

import com.stepyen.xframe.mvp.ILoadView;
import com.stepyen.xframe.mvp.IView;
import com.stepyen.xframedemo.mvp.model.net.BaseResponse;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;
import com.stepyen.xframe.mvp.IModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPContract {
    public interface View extends ILoadView {
       void onShowExpertCategory(List<ExpertCategory> data);
    }

    public interface Model extends IModel{
        Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory();
    }
}
