package com.zxg.mvparmsdemo.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.zxg.mvparmsdemo.mvp.contract.MainContract;
import com.zxg.mvparmsdemo.mvp.model.api.cache.CommonCache;
import com.zxg.mvparmsdemo.mvp.model.api.service.ApiService;
import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    public static final int COUNT = 10;
    private Gson mGson;
    private Application mApplication;


    @Inject
    public MainModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }
  /*  @Override
    public Observable<BookBean> getSearchBook(String name, String tag, int start) {
        Observable<BookBean> observable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getSearchBook(name, tag, start, COUNT);

        return mRepositoryManager.obtainCacheService(CommonCache.class)
                .getSearchBook(observable, new DynamicKey(name),  new EvictDynamicKey(true))
                .flatMap(bookBeanReply -> Observable.just(bookBeanReply.getData()));
    }*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}