package com.example.owner.zhangqiuyangday20181008;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> listFragment = new ArrayList<>();
    private String [] mTitle = {"首页","分类","我的"};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        for (int i = 0;i < mTitle.length;i++){

        listFragment.add(new FragmentShow());

        }

         MyFragmentAdpter adpter = new MyFragmentAdpter(getSupportFragmentManager());
         mViewPager.setAdapter(adpter);
         mTabLayout.setupWithViewPager(mViewPager);
         mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

     }

    /**
     * fragment的适配器
     */
    public class MyFragmentAdpter  extends FragmentPagerAdapter {

        public MyFragmentAdpter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    }
}
