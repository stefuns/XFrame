package com.stepyen.xfrema.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.billy.android.loading.Gloading;
import com.stepyen.xfrema.mvp.IPresenter;
import com.stepyen.xfrema.widget.actionbar.TitleBar;
import com.stepyen.xfrema.widget.actionbar.TitleUtils;

/**
 * date：2019/5/24
 * author：stepyen
 * description：
 */
public abstract class SBaseActivity<P extends IPresenter> extends BaseActivity<P> {
    protected View mContentView;
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ViewGroup contentParent = findViewById(android.R.id.content);
        mContentView = contentParent.getChildAt(0);
        TitleBar titleBar = initTitleBar();
        if (titleBar != null) {
            contentParent.addView(titleBar, 0);
        }

    }
    protected TitleBar initTitleBar() {
        return TitleUtils.initTitleBarDynamic(this,getTitle(), v -> {
            finish();
        });
    }

    protected Gloading.Holder mHolder;

    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(mContentView).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }

    protected void onLoadRetry() {
        // override this method in subclass to do retry task
    }

    public void showLoading() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoading();
    }

    public void showLoadSuccess() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadSuccess();
    }

    public void showLoadFailed() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadFailed();
    }

    public void showEmpty() {
        initLoadingStatusViewIfNeed();
        mHolder.showEmpty();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHolder != null) {
            mHolder = null;
        }
    }
}
