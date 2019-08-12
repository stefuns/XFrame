package com.stepyen.xframedemo.mvp.ui.activity;

import android.content.Intent;

import com.stepyen.xframedemo.BaseTestActivity;

public class MainActivity extends BaseTestActivity {

    @Override
    public void initView() {


        addView("简单页面", v->{
            startActivity(new Intent(this, TestMVPLoadActivity.class));
        });
        addView("嵌入Fragment", v->{
            startActivity(new Intent(this, TestFragmentActivity.class));
        });

        addView("页面指定错误页面", v->{
            startActivity(new Intent(this, SimpleLoadActivity.class));
        });
        addView("测试图片框架Glide", v->{
            startActivity(new Intent(this, TestImageLoadActivity.class));
        });
        addView("复用Presenter", v->{
            startActivity(new Intent(this, TestReuseActivity.class));
        });

    }
}
