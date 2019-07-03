package com.stepyen.xframedemo.mvp.ui.fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepyen.xframe.base.BaseLoadFragment;
import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframedemo.R;
import com.stepyen.xframedemo.di.component.DaggerTestFragmentComponent;
import com.stepyen.xframedemo.mvp.contract.TestFragmentContract;
import com.stepyen.xframedemo.mvp.model.net.entity.ExpertCategory;
import com.stepyen.xframedemo.mvp.presenter.TestFragmentPresenter;
import java.util.List;
import butterknife.BindView;
/**
 * date：07/01/2019
 * author：stepyen
 * description：
 */
public class TestFragmentFragment extends BaseLoadFragment<TestFragmentPresenter> implements TestFragmentContract.View {

    @BindView(R.id.tv_mvp)
    TextView mTvMvp;

    public static TestFragmentFragment newInstance() {
        TestFragmentFragment fragment = new TestFragmentFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerTestFragmentComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    protected String getTitle() {
        return "测试MVPFragemnt";
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
       super.initData(savedInstanceState);
    }

    @Override
    public void onLoad() {
        mPresenter.getExpertCategory();
    }

    @Override
    public void setData(@Nullable Object data) {

    }


    @Override
    public void onShowExpertCategory(List<ExpertCategory> data) {
        if (data != null) {
            StringBuilder sb = new StringBuilder();
            for (ExpertCategory bean : data
            ) {
                sb.append(bean.getCatName());
                sb.append("\n");
            }
            mTvMvp.setText(sb.toString());
        }
    }
}
