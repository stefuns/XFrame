package com.stepyen.xframedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stepyen.xframedemo.mvp.TestMVPActivity;

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
