package com.stepyen.xframedemo.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepyen.xframedemo.net.Api;
import com.stepyen.xframe.base.delegate.AppLifecycles;
import com.stepyen.xframe.di.module.GlobalConfigModule;

import com.stepyen.xframe.integration.ConfigModule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import me.jessyan.progressmanager.ProgressManager;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlobalConfigModule.Builder builder) {
//        if (!BuildConfig.LOG_DEBUG) { //Release 时, 让框架不再打印 Http 请求和响应的信息
//            builder.printHttpLogLevel(RequestInterceptor.Level.NONE);
//        }

        builder
                .baseurl(Api.EXPERT_BASE_URL)

                .okhttpConfiguration((context1, okhttpBuilder) -> {//这里可以自己自定义配置 Okhttp 的参数
//                    okhttpBuilder.sslSocketFactory(); //支持 Https, 详情请百度
                    okhttpBuilder.writeTimeout(10, TimeUnit.SECONDS);
                    //使用一行代码监听 Retrofit／Okhttp 上传下载进度监听,以及 Glide 加载进度监听, 详细使用方法请查看 https://github.com/JessYanCoding/ProgressManager
                    ProgressManager.getInstance().with(okhttpBuilder);
                    //让 Retrofit 同时支持多个 BaseUrl 以及动态改变 BaseUrl, 详细使用方法请查看 https://github.com/JessYanCoding/RetrofitUrlManager
                    RetrofitUrlManager.getInstance().with(okhttpBuilder);
                });

    }

    @Override
    public void injectAppLifecycle(@NonNull Context context, @NonNull List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecyclesImpl());
    }

    @Override
    public void injectActivityLifecycle(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}
