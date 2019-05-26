package com.stepyen.xframedemo.net;

import com.stepyen.xframedemo.net.entity.ExpertCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;


/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public interface ApiManage {


    @POST("app/expert/getexpertcat")
    Observable<BaseResponse<List<ExpertCategory>>> getExpertCategory();



}
