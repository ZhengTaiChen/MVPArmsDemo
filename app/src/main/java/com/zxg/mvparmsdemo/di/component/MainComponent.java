package com.zxg.mvparmsdemo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.zxg.mvparmsdemo.di.module.MainModule;
import com.zxg.mvparmsdemo.mvp.ui.activity.MainActivity;


@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}