package com.zxg.mvparmsdemo.mvp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;
import com.zxg.mvparmsdemo.R;
import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BookItemHolder extends BaseHolder<BookBean.BooksBean>{
    @BindView(R.id.iv_icon)
    ImageView imageView;
    @BindView(R.id.tv_name)
    TextView tvName;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    public BookItemHolder(View itemView) {
        super(itemView);
        mAppComponent = ((App) itemView.getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(BookBean.BooksBean data, int position) {
        Observable.just(data.getSubtitle())
                .subscribe(s -> tvName.setText(s));

        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity()==null?
        mAppComponent.application():mAppComponent.appManager().getCurrentActivity(), GlideImageConfig.builder()
        .url(data.getImage()).imageView(imageView).build());

    }

    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.application(), GlideImageConfig.builder()
                .imageViews(imageView)
                .build());
    }
}
