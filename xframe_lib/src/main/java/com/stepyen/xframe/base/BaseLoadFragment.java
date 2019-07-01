package com.stepyen.xframe.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.billy.android.loading.Gloading;
import com.stepyen.xframe.mvp.IPresenter;
import com.stepyen.xframe.widget.actionbar.TitleBar;
import com.stepyen.xframe.widget.actionbar.TitleUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date：2019/7/1
 * author：stepyen
 * description：
 */
public abstract class BaseLoadFragment<P extends IPresenter> extends BaseFragment<P> {

    protected Gloading.Holder mHolder;
    private View mView;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = initView(inflater, container, savedInstanceState);

        TitleBar titleBar = initTitleBar();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        if (titleBar != null) {
            linearLayout.addView(titleBar);
        }

        linearLayout.addView(mView);

        mUnbinder = ButterKnife.bind(this, linearLayout);
        return linearLayout;
    }

    protected TitleBar initTitleBar() {
        return TitleUtils.initTitleBarDynamic(getContext(), getTitle(), v -> {
            getActivity().finish();
        });
    }

    protected String getTitle() {
        return "";
    }

    @Override
    public void onViewClick(View view) {

    }
    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(mView).withRetry(new Runnable() {
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
    public void onDestroy() {
        super.onDestroy();
        if (mHolder != null) {
            mHolder = null;
        }

        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
    }
}
