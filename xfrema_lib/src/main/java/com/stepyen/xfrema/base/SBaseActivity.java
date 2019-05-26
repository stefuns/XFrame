package com.stepyen.xfrema.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
            contentParent.removeAllViews();

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(titleBar);
            linearLayout.addView(mContentView);

            contentParent.addView(linearLayout);
        }

    }

    protected TitleBar initTitleBar() {
        return TitleUtils.initTitleBarDynamic(this, getTitle(), v -> {
            finish();
        });
    }

    public void showMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
