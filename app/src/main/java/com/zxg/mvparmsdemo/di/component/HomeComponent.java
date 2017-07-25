package com.zxg.mvparmsdemo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.zxg.mvparmsdemo.di.module.HomeModule;

import com.zxg.mvparmsdemo.mvp.ui.fragment.HomeFragment;

@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
}