package com.stepyen.xframedemo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframe.di.component.AppComponent;

import com.stepyen.xframe.widget.actionbar.TitleBar;
import com.stepyen.xframedemo.di.component.DaggerTestReuseComponent;
import com.stepyen.xframedemo.di.module.ReuseModule;
import com.stepyen.xframedemo.di.module.TestReuseModule;
import com.stepyen.xframedemo.mvp.contract.TestReuseContract;
import com.stepyen.xframedemo.mvp.presenter.ReusePresenter;
import com.stepyen.xframedemo.mvp.presenter.TestReusePresenter;

import com.stepyen.xframedemo.R;

import javax.inject.Inject;


/**
 * date：08/12/2019
 * author：stepyen
 * description：测试复用Presenter
 */
public class TestReuseActivity extends BaseLoadActivity<TestReusePresenter> implements TestReuseContract.View {

    @Inject
    ReusePresenter mReusePresenter;
    
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerTestReuseComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .testReuseModule(new TestReuseModule(this))
                .reuseModule(new ReuseModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initTitleBar() {
        TitleBar titleBar = (TitleBar) super.initTitleBar();
        return titleBar;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_reuse;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);

        findViewById(R.id.btn_rease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReusePresenter != null) {
                    mReusePresenter.test();
                }
            }
        });
    }

    @Override
    public void onLoad() {

    }


    @Override
    public void showTest() {
        Toast.makeText(this, "成功调用ReusePresenter的方法", Toast.LENGTH_SHORT).show();
    }
}
