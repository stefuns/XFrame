package com.stepyen.xframedemo.mvp;

import com.stepyen.xframedemo.net.BaseResponse;
import com.stepyen.xframedemo.net.entity.ExpertCategory;
import com.stepyen.xframe.mvp.ILoadView;
import com.stepyen.xframe.mvp.IModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPContract {
    public interface View extends ILoadView{
       void onShowExpertCategory(List<ExpertCategory> data);
    }

    public interface Model extends IModel{
        Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory();
    }
}
