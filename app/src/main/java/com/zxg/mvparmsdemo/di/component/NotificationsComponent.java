package com.zxg.mvparmsdemo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.zxg.mvparmsdemo.di.module.NotificationsModule;

import com.zxg.mvparmsdemo.mvp.ui.fragment.NotificationsFragment;

@ActivityScope
@Component(modules = NotificationsModule.class, dependencies = AppComponent.class)
public interface NotificationsComponent {
    void inject(NotificationsFragment fragment);
}