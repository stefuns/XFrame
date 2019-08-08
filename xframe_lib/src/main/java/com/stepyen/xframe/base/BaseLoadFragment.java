package com.stepyen.xframe.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.billy.android.loading.Gloading;
import com.stepyen.xframe.mvp.ILoadView;
import com.stepyen.xframe.mvp.IPresenter;
import com.stepyen.xframe.widget.actionbar.TitleUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date：2019/7/1
 * author：stepyen
 * description：
 */
public abstract class BaseLoadFragment<P extends IPresenter> extends BaseFragment<P> implements ILoadView {

    protected Gloading.Holder mHolder;
    private View mView;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = initView(inflater, container, savedInstanceState);

        View titleBar = initTitleBar();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        if (titleBar != null) {
            linearLayout.addView(titleBar);
        }

        if (mView != null) {
            linearLayout.addView(mView);
        }

        mUnbinder = ButterKnife.bind(this, linearLayout);

        return linearLayout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        onLoad();
    }

    /**
     * 一开始加载的数据放在这个方法，便于重试时，再次调用
     */
    public abstract void onLoad();


    protected View initTitleBar() {
        return TitleUtils.initTitleBarDynamic(getContext(), getTitle(), v -> {
            getActivity().finish();
        });
    }

    protected String getTitle() {
        return "";
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
        showLoadFailed();
        onLoad();
    }
    @Override
    public void showLoading() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoading();
    }
    @Override
    public void showLoadSuccess() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadSuccess();
    }
    @Override
    public void showLoadFailed() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadFailed();
    }
    @Override
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
