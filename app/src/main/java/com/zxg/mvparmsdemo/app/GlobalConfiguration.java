package com.zxg.mvparmsdemo.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.jess.arms.base.App;
import com.jess.arms.base.delegate.AppDelegate;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.jess.arms.integration.IRepositoryManager;
import com.zxg.mvparmsdemo.mvp.model.api.Api;
import com.zxg.mvparmsdemo.mvp.model.api.cache.CommonCache;
import com.zxg.mvparmsdemo.mvp.model.api.service.ApiService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */

public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        builder.baseurl(Api.APP_DOMAIN);


    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {
        repositoryManager.injectCacheService(CommonCache.class);
        repositoryManager.injectRetrofitService(ApiService.class);
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppDelegate.Lifecycle> lifecycles) {
        lifecycles.add(new AppDelegate.Lifecycle() {
            @Override
            public void onCreate(Application application) {


//                ((App)application).getAppComponent().extras().put()
            }

            @Override
            public void onTerminate(Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        lifecycles.add(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {


    }
}
