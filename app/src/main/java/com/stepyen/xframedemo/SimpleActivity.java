package com.stepyen.xframedemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.billy.android.loading.Gloading;
import com.stepyen.xfrema.base.BaseActivity;
import com.stepyen.xfrema.base.BaseLoadActivity;
import com.stepyen.xfrema.base.SBaseActivity;
import com.stepyen.xfrema.di.component.AppComponent;
/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public class SimpleActivity extends SBaseActivity {
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_simple;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoadFailed();
            }
        }, 2000);
    }

    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.from(new OtherGloadingAdapter()).wrap(mContentView).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }
}
