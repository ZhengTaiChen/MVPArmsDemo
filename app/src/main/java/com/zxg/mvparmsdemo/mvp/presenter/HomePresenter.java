package com.zxg.mvparmsdemo.mvp.presenter;

import android.app.Application;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.widget.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.zxg.mvparmsdemo.mvp.contract.HomeContract;
import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;
import com.zxg.mvparmsdemo.mvp.ui.adapter.BookAdapter;

import java.util.ArrayList;
import java.util.List;


@ActivityScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;


    private DefaultAdapter adapter;
    private List<BookBean.BooksBean> booksBeanList=new ArrayList<>();

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
    }
    public void requestData() {
        mRootView.showLoading();
        if (adapter == null) {
            adapter = new BookAdapter(booksBeanList);
            mRootView.setAdapter(adapter);

        }
        mModel.getSearchBook("金瓶梅", null, 1)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(RxUti)
                .subscribe(new ErrorHandleSubscriber<BookBean>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull BookBean bookBean) {
                           mRootView.hideLoading();
                        if (bookBean != null) {
                            booksBeanList.addAll(bookBean.getBooks());
                            adapter.notifyDataSetChanged();
//                            mRootView.showMessage(bookBean.getBooks().get(0).getImage());
                        }
                    }
                });

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

}