package com.zxg.mvparmsdemo.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.zxg.mvparmsdemo.R;
import com.zxg.mvparmsdemo.mvp.model.entity.BookBean;
import com.zxg.mvparmsdemo.mvp.ui.BookItemHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BookAdapter extends DefaultAdapter<BookBean.BooksBean>{

    public BookAdapter(List<BookBean.BooksBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<BookBean.BooksBean> getHolder(View v, int viewType) {
        return new BookItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_list;
    }
}
