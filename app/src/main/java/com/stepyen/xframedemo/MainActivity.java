package com.stepyen.xframedemo;

import android.content.Intent;

import com.stepyen.xframedemo.mvp.ui.activity.TestMVPActivity;

public class MainActivity extends BaseTestActivity {

    @Override
    public void initView() {
        addView("示范加载视图，特殊的错误页面", v->{
            startActivity(new Intent(this, SimpleActivity.class));
        });

        addView("测试MVP", v->{
            startActivity(new Intent(this, TestMVPActivity.class));
        });
    }
}
