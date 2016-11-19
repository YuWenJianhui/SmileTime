package com.king.smiletime.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.king.smiletime.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class VideoFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabNames;
    private List<ThirdFragment> fragments;
    private MyFragmentPagerAdapter adapter;
    private List<String> mTblist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.videofragment, null);
        //界面实例的初始化
        initWigets();
        //关于ViewPager的操作
        aboutView();

        //关于TabLayout
        aboutTabLayout();
        return view;
    }

    /**
     * 界面实例的初始化
     */
    private void initWigets() {
        tabLayout =  (TabLayout) view.findViewById(R.id.tab_id);
        viewPager = (ViewPager) view.findViewById(R.id.vpger_id);
        tabNames = getResources().getStringArray(R.array.tabNames3);


    }

    /**
     * 关于ViewPager的操作
     */
    private void aboutView() {
//        //数据源
//        int i=0;
        fragments = new LinkedList<>();
        for(String tabName:tabNames){
            ThirdFragment fragment = new ThirdFragment();
            Bundle args = new Bundle();
            args.putString("tabName",tabName);
            //args.putString("url","");
            fragment.setArguments(args);
            fragments.add(fragment);
        }
        for(Fragment fragment:fragments){
            Log.i("msg",fragment+"");
        }
        //适配器
        adapter = new MyFragmentPagerAdapter(getFragmentManager());
        Log.i("msg", adapter +"");
        //绑定
        viewPager.setAdapter(adapter);
        //viewPager.setAdapter(adapter);
        Log.i("msg","zoule");
    }
    private final  class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.i("msg",tabNames[position]);
            return tabNames[position];
        }
    }

    /**
     * 关于TabLayout
     */
    private void aboutTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
    }


}
