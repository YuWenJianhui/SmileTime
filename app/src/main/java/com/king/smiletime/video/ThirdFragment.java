package com.king.smiletime.video;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.asynctask.DownloadJsonDataAysncTask;
import com.king.entity.Banners;
import com.king.entity.Lives;
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
    private String url;
    private ViewPager viewPager;
    private Person person;
    private MyFragmentPagerAdapter adapter;
    private List<ImageFragment> fragments;
    private RecyclerView recyclerView;
    private ProgressDialog dialog;
    private List<Lives> ds;
    private MyAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager gridLayout;
    private Handler handler;

    private int index;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        url =   bundle.getString("url");
        super.onCreate(savedInstanceState);
    }

    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, null);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        dialog = new ProgressDialog(getContext());
        gridLayout = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayout);

        //关于ViewPager
        aboutViewPager();

        circleShowPic();
        //关于RecyclerView
        aboutRecyclerView();
        return view;
    }

    /**
     *关于ViewPager的操作
     */
    private void aboutViewPager() {
        //数据源
        fragments = new LinkedList<>();
        fillData();
        //适配器
        adapter = new MyFragmentPagerAdapter(getFragmentManager());
        //绑定
        viewPager.setAdapter(adapter);

    }

    private void fillData() {
        //获取json数据
        new DownloadJsonDataAysncTask(this,dialog).execute(url);

    }

    @Override
    public void setJsonData(Person result) {
            List<Banners> banners = result.getBanners();

        for(int i=0;i<banners.size();i++){
            ImageFragment fragment = new ImageFragment();
            String url = banners.get(i).getUrl();
            Bundle args = new Bundle();
            args.putString("url",url);
            args.putString("tag",i+"");
            Log.i("url",url);
            fragment.setArguments(args);
            fragments.add(fragment);
        }
             Log.i("fragments",fragments.size()+"");
            adapter.notifyDataSetChanged();

            List<Lives> lives = result.getLives();
            for(Lives live:lives){
                ds.add(live);

            }
            Log.i("ds",ds.size()+"");
            recyclerViewAdapter.notifyDataSetChanged();

    }

    /**
     * 自定义FragmentStatePagerAdapter的实现类
     */
    public final  class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
//            Log.i("fragments.size",fragments.size()+"");
//            return fragments.get(position % fragments.size());

        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    /**
     * 循环显示广告图片
     */
    private void circleShowPic() {
        /*
         * (non-Javadoc)
         *
         * @see android.os.Handler#handleMessage(android.os.Message)
         */// 给自己发送
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(index==0){
                    viewPager.setCurrentItem(index++,false);

                }else{
                    viewPager.setCurrentItem(index++);
                }

                if (index == fragments.size()) {
                    index = 0;
                }

                handler.sendEmptyMessageDelayed(1, 3000);// 给自己发送
            }
        };

        handler.sendEmptyMessageDelayed(1, 3000);// 启动方法handleMessage
    }


    /**
     * 关于RecyclerView的操作
     */
    private void aboutRecyclerView() {
        //数据源
        ds = new LinkedList<>();
        //适配器
        recyclerViewAdapter = new MyAdapter();
        //绑定
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = View.inflate(getContext(), R.layout.itemfragment, null);

            //添加监听器
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    WebFragment webFragment = new WebFragment();
//                    Bundle args = new Bundle();
//                    args.putString("url","http://www.app-remix.com/share/live/52248810123966188");
//                    webFragment.setArguments(args);
//                    getFragmentManager().beginTransaction().replace(R.id.tdfl_id,webFragment).addToBackStack(null).commit();

                }
            });


            return new MyViewHolder(itemView);
        }


        @Override
        public int getItemCount() {
            return ds.size();
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            Lives lives = ds.get(position);
            holder.getLocation().setText(lives.getLocation());
            holder.getContent().setText(lives.getContent());
            holder.getCount().setText(lives.getVisitors_count()+"");
            holder.getName().setText(lives.getAuthor().getName());
            Picasso.with(getContext()).load(lives.getAuthor().getHeadurl()).into(holder.getImage());

        }


        class MyViewHolder extends RecyclerView.ViewHolder{
            private ImageView image;
            private TextView location;
            private TextView name;
            private TextView count;
            private TextView content;

            public TextView getContent() {
                return content;
            }

            public ImageView getImage() {
                return image;
            }

            public TextView getLocation() {
                return location;
            }

            public TextView getName() {
                return name;
            }

            public TextView getCount() {
                return count;
            }

            public MyViewHolder(View itemView) {
                super(itemView);
                 image = (ImageView) itemView.findViewById(R.id.image);
                 location = (TextView) itemView.findViewById(R.id.tv_location);
                 name = (TextView) itemView.findViewById(R.id.tv_name);
                 content = (TextView) itemView.findViewById(R.id.tv_content);
                 count = (TextView) itemView.findViewById(R.id.tv_count);

            }

        }
    }

}
