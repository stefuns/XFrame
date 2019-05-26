package com.stepyen.xframedemo.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.stepyen.xframedemo.R;
import com.stepyen.xframedemo.net.entity.ExpertCategory;
import com.stepyen.xfrema.base.SBaseActivity;
import com.stepyen.xfrema.di.component.AppComponent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class TestMVPActivity extends SBaseActivity<TestMVPPresenter> implements TestMVPContract.View {


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
