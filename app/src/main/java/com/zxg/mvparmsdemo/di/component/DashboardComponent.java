package com.zxg.mvparmsdemo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.zxg.mvparmsdemo.di.module.DashboardModule;

import com.zxg.mvparmsdemo.mvp.ui.fragment.DashboardFragment;

@ActivityScope
@Component(modules = DashboardModule.class, dependencies = AppComponent.class)
public interface DashboardComponent {
    void inject(DashboardFragment fragment);
}