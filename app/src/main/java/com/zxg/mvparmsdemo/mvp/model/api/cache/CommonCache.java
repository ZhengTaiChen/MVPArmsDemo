package com.zxg.mvparmsdemo.mvp.model.api.cache;

import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import retrofit2.http.Query;

/**
 * Created by jess on 8/30/16 13:53
 * Contact with jess.yan.effort@gmail.com
 */
public interface CommonCache {



    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<BookBean>> getSearchBook(Observable<BookBean> book, DynamicKey name,EvictDynamicKey dynamicKey);

}
