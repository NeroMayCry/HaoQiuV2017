package com.joeykwok.haoqiuv2017.main;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.joeykwok.haoqiuv2017.R;
import com.joeykwok.haoqiuv2017.utils.MyViewPager;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zhy.http.okhttp.OkHttpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeFragment mHomeFragment;
    private ProfileFragment mProfileFragment;

    private TextView mNavHome;
    private TextView mNavMy;

    private MyViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        mNavHome = (TextView) findViewById(R.id.tv_home);
        mNavMy = (TextView) findViewById(R.id.tv_my);
        mNavHome.setOnClickListener(this);
        mNavMy.setOnClickListener(this);
        setDefaultFragment();
//        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        final SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
//        viewPager = (MyViewPager) findViewById(R.id.main_viewpager);
//        initFragments();

    }

    @Override
    public void onClick(View view) {
        resetTabState();
        switch (view.getId()) {
            case R.id.tv_home:
                setTabState(mNavHome, R.drawable.home_fill, getNavColor(R.color.colorPrimary));
                switchFrgment(0);
                break;
            case R.id.tv_my:
                setTabState(mNavMy, R.drawable.my_fill, getNavColor(R.color.colorPrimary));
                switchFrgment(1);
                break;
        }
    }

    /**
     * set the default Fragment
     */
    private void setDefaultFragment() {
        switchFrgment(0);
        //set the defalut tab state
        setTabState(mNavHome, R.drawable.home_fill, getNavColor(R.color.colorPrimary));
    }

//    private MyPagerAdapter pagerAdapter;

//    private void initFragments() {
//        homeFragment = new HomeFragment();
//        profileFragment = new ProfileFragment();
//        if (pagerAdapter == null) {
//            pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
//        }
//        viewPager.setAdapter(pagerAdapter);
//    }


//    class MyPagerAdapter extends FragmentPagerAdapter {
//
//        public MyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            if (position == 0) {
//                return homeFragment;
//            } else if (position == 1) {
//                return profileFragment;
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            return 1;
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * set the tab state of bottom navigation bar
     *
     * @param textView the text to be shown
     * @param image    the image
     * @param color    the text color
     */
    private void setTabState(TextView textView, int image, int color) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, image, 0, 0);//Call requires API level 17
        textView.setTextColor(color);
    }


    /**
     * revert the image color and text color to black
     */
    private void resetTabState() {
        setTabState(mNavHome, R.drawable.home, getNavColor(R.color.black_1));
        setTabState(mNavMy, R.drawable.my, getNavColor(R.color.black_1));
    }

    /**
     * switch the fragment accordting to id
     * @param i id
     */
    private void switchFrgment(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                transaction.replace(R.id.main_fg_content, mHomeFragment);
                break;
            case 1:
                if (mProfileFragment == null) {
                    mProfileFragment = new ProfileFragment();
                }
                transaction.replace(R.id.main_fg_content, mProfileFragment);
                break;
        }
        transaction.commit();
    }

    /**
     * @param i the color id
     * @return color
     */
    private int getNavColor(int i) {
        return ContextCompat.getColor(this, i);
    }

}
