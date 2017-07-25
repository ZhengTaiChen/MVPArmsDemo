package com.zxg.mvparmsdemo.app;

import com.jess.arms.base.BaseApplication;

/**
 * Created by Administrator on 2017/7/20.
 */

public class MyApplication extends BaseApplication {
    private static MyApplication myApplication = new MyApplication();

    public MyApplication() {
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
