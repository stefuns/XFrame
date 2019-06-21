package com.stepyen.xframedemo.mvp.ui.activity;

import android.content.Intent;

import com.stepyen.xframedemo.BaseTestActivity;

public class MainActivity extends BaseTestActivity {

    @Override
    public void initView() {
        addView("示范加载视图，特殊的错误页面", v->{
            startActivity(new Intent(this, SimpleActivity.class));
        });

        addView("测试MVP", v->{
            startActivity(new Intent(this, TestMVPActivity.class));
        });

        addView("测试图片框架Glide", v->{
            startActivity(new Intent(this, TestImageActivity.class));
        });
    }
}
