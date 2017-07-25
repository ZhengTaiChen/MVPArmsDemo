package com.zxg.mvparmsdemo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.jess.arms.base.AdapterViewPager;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.zxg.mvparmsdemo.R;
import com.zxg.mvparmsdemo.di.component.DaggerMainComponent;
import com.zxg.mvparmsdemo.di.module.MainModule;
import com.zxg.mvparmsdemo.mvp.contract.MainContract;
import com.zxg.mvparmsdemo.mvp.presenter.MainPresenter;
import com.zxg.mvparmsdemo.mvp.ui.fragment.DashboardFragment;
import com.zxg.mvparmsdemo.mvp.ui.fragment.HomeFragment;
import com.zxg.mvparmsdemo.mvp.ui.fragment.NotificationsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View,ViewPager.OnPageChangeListener {


    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0,true);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1,true);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2,true);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);


    }

    @Override
    public int initView(Bundle savedInstanceState) {

        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        List<Fragment> list = new ArrayList<>();
        list.add(HomeFragment.newInstance());
        list.add(DashboardFragment.newInstance());
        list.add(NotificationsFragment.newInstance());
        mViewPager.setAdapter(new AdapterViewPager(getSupportFragmentManager(), list));
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigation.getMenu().getItem(position).setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
