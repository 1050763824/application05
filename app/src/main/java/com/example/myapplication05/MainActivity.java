package com.example.myapplication05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<View> mViewList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        View home = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_first, null);
        View address = LayoutInflater.from(getApplicationContext()).inflate(R.layout.second_fragment, null);
        View discover = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_third, null);


        mViewList = new ArrayList<>();
        mViewList.add(home);
        mViewList.add(address);
        mViewList.add(discover);


        mTitleList = new ArrayList<>();
        mTitleList.add("首页");
        mTitleList.add("通讯录");
        mTitleList.add("发现");


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViewList.get(position));
                return mViewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleList.get(position);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);

        //TabLayout监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换tab时不使用ViewPager动画效果
                mViewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}