package com.king.smiletime.video;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.king.asynctask.DownloadJsonDataAysncTask;
import com.king.entity.Banners;
import com.king.entity.Person;
import com.king.smiletime.R;
import com.squareup.picasso.Picasso;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ThirdFragment extends Fragment implements DownloadJsonDataAysncTask.JsonDataSettingCallBack{

    private View view;
    private ListView listView;
    private TextView replace;
    private String tabName;
    private String url;
    private ViewPager viewPager;
    private ImageView imageView;
    private Person person;
    private MyFragmentPagerAdapter adapter;
    private List<ImageFragment> fragments;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tabName = bundle.getString("tabName");
        url =   bundle.getString("url");
        Log.i("msg",url);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, null);
        viewPager = (ViewPager) view.findViewById(R.id.vp_id);
        imageView = (ImageView) view.findViewById(R.id.image);
        listView = (ListView) view.findViewById(R.id.listView);
        replace = (TextView) view.findViewById(R.id.tv_replace_id);
        listView.setEmptyView(replace);

        //关于ViewPager
        aboutViewPager();
        //关于ListView
        aboutlistView();
        return view;
    }

    private void getData() {
        ProgressDialog dialog = new ProgressDialog(getContext());
       new DownloadJsonDataAysncTask(this,dialog).execute(url);

    }

    /**
     *
     */
    private void aboutViewPager() {
        //数据源
        fragments = new LinkedList<>();
        fillData();

        //适配器
        adapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments);
        //绑定
        viewPager.setAdapter(adapter);
        //监听器
    }

    private void fillData() {
        //获取json数据
        getData();

    }

    @Override
    public void setJsonData(Person result) {
        Log.i("msg3",result.toString());
        List<Banners> banners = result.getBanners();
        for(Banners banner:banners){
            ImageFragment fragment = new ImageFragment();
            String url = banner.getUrl();
            Bundle args = new Bundle();
            args.putString("url",url);
            fragment.setArguments(args);
            fragments.add(fragment);
            Log.i("msg",fragments.toString());
        }
        adapter.notifyDataSetChanged();


    }
    private final  class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private List<ImageFragment> photoFragments;
        public MyFragmentPagerAdapter(FragmentManager fm,List<ImageFragment> photoFragments) {
            super(fm);
            this.photoFragments=photoFragments;
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("size",photoFragments.size()+"");
            if(photoFragments.size()!=0){

                return photoFragments.get(position%(photoFragments.size()));
            }
            return photoFragments.get(position);
        }

        @Override
        public int getCount() {
            if(photoFragments.size()!=0){
            return Integer.MAX_VALUE;
            }
            return photoFragments.size();
        }

    }


    private void aboutlistView() {
        //数据源
        //适配器
        //绑定
        //监听器
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }




}
