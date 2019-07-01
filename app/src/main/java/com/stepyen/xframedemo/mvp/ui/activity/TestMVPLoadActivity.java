package com.stepyen.xframedemo.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframedemo.R;
import com.stepyen.xframedemo.di.component.DaggerTestMVPCompoent;
import com.stepyen.xframedemo.mvp.presenter.TestMVPPresenter;
import com.stepyen.xframedemo.mvp.contract.TestMVPContract;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;
import com.stepyen.xframe.di.component.AppComponent;

import java.util.List;

import butterknife.BindView;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPLoadActivity extends BaseLoadActivity<TestMVPPresenter> implements TestMVPContract.View {


    @BindView(R.id.tv_mvp)
    TextView mTvMvp;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerTestMVPCompoent.builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_mvp;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
    }

    @Override
    public void onViewClick(View view) {

    }

    @Override
    public void onShowExpertCategory(List<ExpertCategory> data) {
        if (data != null) {
            StringBuilder sb = new StringBuilder();
            for (ExpertCategory bean:data
                 ) {
                sb.append(bean.getCatName());
                sb.append("\n");
            }
            mTvMvp.setText(sb.toString());
        }
    }

}
