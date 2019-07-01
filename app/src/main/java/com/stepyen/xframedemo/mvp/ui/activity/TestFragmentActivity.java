package com.stepyen.xframedemo.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stepyen.xframe.base.App;
import com.stepyen.xframedemo.R;
import com.stepyen.xframedemo.mvp.ui.fragment.TestFragmentFragment;

/**
 * date：2019/7/1
 * author：stepyen
 * description：
 */
public class TestFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fy_test_fragment, TestFragmentFragment.newInstance())
                .commit();


    }
}
