package com.stepyen.xframedemo.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframe.di.component.AppComponent;
import com.stepyen.xframe.http.imageloader.ImageLoader;
import com.stepyen.xframe.http.imageloader.glide.ImageConfigImpl;
import com.stepyen.xframe.utils.ArmsUtils;
import com.stepyen.xframedemo.Constant;
import com.stepyen.xframedemo.R;

import butterknife.BindView;

/**
 * date：2019/6/21
 * author：stepyen
 * description：测试图片glide
 */
public class TestImageLoadActivity extends BaseLoadActivity {

    @BindView(R.id.iv_glide_original)
    ImageView mIvGlideOriginal;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_image;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        AppComponent appComponent = ArmsUtils.obtainAppComponentFromContext(this);
        ImageLoader imageLoader = appComponent.imageLoader();

        ImageConfigImpl imageConfig = ImageConfigImpl
                .builder()
                .url(Constant.IMAGE_URL)
                .imageView(mIvGlideOriginal)
                .build();
        imageLoader.loadImage(this,imageConfig);
    }

    @Override
    public void onViewClick(View view) {

    }

}
