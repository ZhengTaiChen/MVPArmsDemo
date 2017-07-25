package com.zxg.mvparmsdemo.mvp.model.api.service;

import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/20.
 */

public interface ApiService {
    @GET("book/search")
    Observable<BookBean> getSearchBook(@Query("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);

}
