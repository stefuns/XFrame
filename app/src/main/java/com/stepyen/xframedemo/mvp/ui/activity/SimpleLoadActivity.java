package com.stepyen.xframedemo.mvp.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.billy.android.loading.Gloading;
import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframe.utils.XFrameUtils;
import com.stepyen.xframe.widget.actionbar.TitleBar;
import com.stepyen.xframedemo.adapter.OtherGloadingAdapter;
import com.stepyen.xframedemo.R;

/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public class SimpleLoadActivity extends BaseLoadActivity {
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }


    @Override
    protected View initTitleBar() {
        TitleBar titleBar = (TitleBar) super.initTitleBar();
        titleBar.addAction(TitleBar.Action.newBuilder()
                .text("放进我的店")
                .build());
        titleBar.addAction(TitleBar.Action.newBuilder()
                .text("分享")
                .textColor(R.color.red)
                .textSize(R.dimen.text_size_small)
                .drawable(R.drawable.ic_share)
                .padding(5)
                .clickListener(v->{
                    XFrameUtils.makeText("分享");
                })
                .build());
          return titleBar;
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
        }, 1000);
    }

    @Override
    public void onLoad() {

    }


    @Override
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

    @Override
    protected void onLoadRetry() {
        showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoadSuccess();
            }
        }, 1000);
    }
}
