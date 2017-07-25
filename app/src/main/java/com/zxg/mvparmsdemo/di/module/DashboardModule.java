package com.zxg.mvparmsdemo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.zxg.mvparmsdemo.mvp.contract.DashboardContract;
import com.zxg.mvparmsdemo.mvp.model.DashboardModel;


@Module
public class DashboardModule {
    private DashboardContract.View view;

    /**
     * 构建DashboardModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DashboardModule(DashboardContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DashboardContract.View provideDashboardView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DashboardContract.Model provideDashboardModel(DashboardModel model) {
        return model;
    }
}