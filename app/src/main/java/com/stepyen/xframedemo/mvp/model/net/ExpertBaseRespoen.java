package com.stepyen.xframedemo.mvp.model.net;

import android.text.TextUtils;

import java.util.List;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class ExpertBaseRespoen<T> {

    public String succeed;

    public List<T> data;


    public boolean isSucceed() {

        if (TextUtils.isEmpty(succeed)) {
            return false;
        }

        return "true".equals(succeed);
    }
}
