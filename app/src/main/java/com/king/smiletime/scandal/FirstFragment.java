package com.king.smiletime.scandal;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.king.smiletime.R;
import com.king.smiletime.friends.FriendsFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class FirstFragment extends Fragment {

    private TabLayout mTab;
    private ViewPager mVp;
    private FragmentStatePagerAdapter adapter;
    private String[] tbname;
    private String[] urls;
    private List<String> mTblist;
    private List<Fragment> fragments;
    private ImageView mImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment, null);
        mTab = (TabLayout) view.findViewById(R.id.tab_id);
        mVp = (ViewPager) view.findViewById(R.id.vpger_id);
        //创建数据源
        initList();
        //添加viewpager数据
        addViewList();
        mTab.setupWithViewPager(mVp);
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setupWithViewPager(mVp);
        return view;
    }

    private void addViewList() {
        //数据源
        fragments = new LinkedList<>();
        int i = 0;
        for (String tabName : tbname) {
            JokesFragment fragment = new JokesFragment();
            Bundle args = new Bundle();
            args.putString("url", urls[i++]);
            fragment.setArguments(args);
            fragments.add(fragment);
        }
        //适配器
        adapter = new FragmentStartPagerAdapter(getFragmentManager());
        //绑定
        mVp.setAdapter(adapter);
    }

    private void initList() {
        tbname = getResources().getStringArray(R.array.tbname);
        mTblist = new LinkedList<>();
        int i = 0;
        while (i < tbname.length) {
            mTblist.add(tbname[i]);
            i++;
        }
        urls=new String[]{"http://m2.qiushibaike.com/article/list/suggest?page=1&type=refresh&count=30","http://m2.qiushibaike.com/article/list/video?page=1&count=30&readarticles=[117983310]&rqcnt=449&r=e4bf6ffb1479388427420","http://m2.qiushibaike.com/article/list/text?page=1&count=30&rqcnt=453&r=e4bf6ffb1479388539622","http://m2.qiushibaike.com/article/list/imgrank?page=1&count=30&readarticles=[117994522]&rqcnt=455&r=e4bf6ffb1479388610808","http://m2.qiushibaike.com/article/list/day?page=1&count=30&readarticles=[117996617]&rqcnt=458&r=e4bf6ffb1479388663888"};
    }

    public class FragmentStartPagerAdapter extends FragmentStatePagerAdapter {

        public FragmentStartPagerAdapter(FragmentManager fm) {
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

        //此处用来定制Fragment的标题，就是定制TabLayout中每个Tab的名字
        @Override
        public CharSequence getPageTitle(int position) {
            return mTblist.get(position);
        }
    }

}
