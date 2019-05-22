package com.stepyen.xfrema.base;

import com.billy.android.loading.Gloading;
import com.stepyen.xfrema.mvp.IPresenter;

/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public abstract class BaseLoadActivity<P extends IPresenter> extends BaseActivity<P> {

    protected Gloading.Holder mHolder;

    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(mRootView).withRetry(new Runnable() {
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

