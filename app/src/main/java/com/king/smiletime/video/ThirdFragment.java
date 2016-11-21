package com.king.smiletime.video;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private List<String> ds;
    private Person person;
    private MyPageAdapter adapter;


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
        ds = new LinkedList<>();
        fillData();

        //适配器
        adapter = new MyPageAdapter();
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
            String url = banner.getUrl();
            Log.i("msg2",url);
            ds.add(url);
        }
        adapter.notifyDataSetChanged();


    }


    private final class MyPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return ds.size();
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;// true if view is associated with the key object object
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(ds.get(position)).into(imageView);
            // 将该数据源添加到ViewPager上
            container.addView(imageView);

            // 返回当前数据源的实例
            return imageView;// Returns an Object representing the new page.
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 从View Pager中移除指定位置的ImageView，（若View Pager中页面很多，若不移除，内存会溢出）
            // 但是，不能从数据源中移除，否则，滑动完一遍，不能回滑（从数据源中已经移除了）
            container.removeView((View) object);
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
