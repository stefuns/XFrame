package com.stepyen.xframedemo.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.billy.android.loading.Gloading;
import com.stepyen.xframedemo.BuildConfig;
import com.stepyen.xframedemo.GlobalAdapter;
import com.stepyen.xframe.base.delegate.AppLifecycles;

/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(@NonNull Context base) {

    }

    @Override
    public void onCreate(@NonNull Application application) {
        Gloading.debug(BuildConfig.DEBUG);
        Gloading.initDefault(new GlobalAdapter());
    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }
}
