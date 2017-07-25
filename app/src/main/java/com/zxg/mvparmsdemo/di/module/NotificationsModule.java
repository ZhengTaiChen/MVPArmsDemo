package com.zxg.mvparmsdemo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.zxg.mvparmsdemo.mvp.contract.NotificationsContract;
import com.zxg.mvparmsdemo.mvp.model.NotificationsModel;


@Module
public class NotificationsModule {
    private NotificationsContract.View view;

    /**
     * 构建NotificationsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NotificationsModule(NotificationsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    NotificationsContract.View provideNotificationsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    NotificationsContract.Model provideNotificationsModel(NotificationsModel model) {
        return model;
    }
}