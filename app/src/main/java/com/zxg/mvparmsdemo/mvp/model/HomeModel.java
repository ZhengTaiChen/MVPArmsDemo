package com.zxg.mvparmsdemo.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.zxg.mvparmsdemo.mvp.contract.HomeContract;
import com.zxg.mvparmsdemo.mvp.model.api.service.ApiService;
import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class HomeModel extends BaseModel implements HomeContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<BookBean> getSearchBook(String name, String tag, int start) {
        Observable<BookBean> observable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getSearchBook(name,tag,start,10);
        return observable;
    }
}