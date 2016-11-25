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
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.king.asynctask.DownloadJsonDataAysncTask;
import com.king.entity.Banners;
import com.king.entity.Lives;
import com.king.entity.Person;
import com.king.smiletime.LiveActivity;
import com.king.smiletime.R;
import com.king.smiletime.scandal.JokesFragment;
import com.squareup.picasso.Picasso;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ThirdFragment extends Fragment implements DownloadJsonDataAysncTask.JsonDataSettingCallBack {

    private View view;
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
    private boolean flg;// true：当前页的数据加载完毕；false：没有还在完毕

    private int index;
    private PullToRefreshScrollView pullToRefresh;
    private String[] split;
    private int i=1;
    private int n=19;
    private String url;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String  url1 = bundle.getString("url1");
        split = url1.split(";");
        url = split[0] + i + split[1] + n;
        Log.i("url",url);
        super.onCreate(savedInstanceState);
    }

    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, null);
        //界面的实例的获取
        initViews();

        //关于ViewPager
        aboutViewPager();
        //广告页循环播放
        circleShowPic();
        //关于RecyclerView
        aboutRecyclerView();
        //关于PullToRefreshListView控件的操作
        aboutPullToRefreshScrollView();
        return view;
    }

    //界面实例的获取
    private void initViews() {
        pullToRefresh = (PullToRefreshScrollView) view.findViewById(R.id.pullToRefresh);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        dialog = new ProgressDialog(getContext());
        gridLayout = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayout);
    }

    /**
     * 关于PullToRefreshListView控件的操作
     */
    private void aboutPullToRefreshScrollView() {
        //添加监听器
        pullToRefresh.setOnRefreshListener(new MyOnRefreshListener());

    }

    //自定义OnRefreshListener的实现类
    private final class MyOnRefreshListener implements PullToRefreshBase.OnRefreshListener, DownloadJsonDataAysncTask.JsonDataSettingCallBack {


        @Override
        public void onRefresh(PullToRefreshBase refreshView) {
            String label = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),
                    DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

            // Update the LastUpdatedLabel
            refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

            // Do work to refresh the list here.

             url = split[0] + (++i) + split[1] + (++n);
            Log.i("url1",url);
            new DownloadJsonDataAysncTask(this).execute(url);

        }


        @Override
        public void setJsonData(Person result) {
            //pullToRefresh.setMode(PullToRefreshBase.Mode.DISABLED);
            pullToRefresh.onRefreshComplete();
            fillRecyclerData(result);
        }
    }


    /**
     * 关于ViewPager的操作
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
        dialog.setMessage("正在加载中。。。");
        dialog.show();
        //获取json数据
        new DownloadJsonDataAysncTask(this).execute(url);

    }

    @Override
    public void setJsonData(Person result) {
        dialog.dismiss();
        //填充ViewPager的数据源
        List<Banners> banners = result.getBanners();
        for (int i = 0; i < banners.size(); i++) {
            ImageFragment fragment = new ImageFragment();
            String url = banners.get(i).getUrl();
            Bundle args = new Bundle();
            args.putString("url", url);
            args.putString("tag", i + "");
            fragment.setArguments(args);
            fragments.add(fragment);
        }
        adapter.notifyDataSetChanged();
        //填充recyclerView的数据源
        fillRecyclerData(result);

    }

    //填充recyclerView的数据源
    public void fillRecyclerData(Person result) {
        List<Lives> lives = result.getLives();
        for (Lives live : lives) {
            ds.add(live);
        }
        recyclerViewAdapter.notifyDataSetChanged();
    }

    /**
     * 自定义FragmentStatePagerAdapter的实现类
     */
    public final class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
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
            //return Integer.MAX_VALUE;
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
                if (index == 0) {
                    viewPager.setCurrentItem(index++, false);

                } else {
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

    //自定义recyclerView的适配器
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View itemView = View.inflate(getContext(), R.layout.itemfragment, null);

            return new MyViewHolder(itemView);
        }


        @Override
        public int getItemCount() {
            return ds.size();
        }

        @Override
        public void onBindViewHolder(final MyAdapter.MyViewHolder holder, int position) {
            //添加监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    String liveUrl = ds.get(pos).getRtmp_live_url();
                    Intent intent = new Intent(getActivity(), LiveActivity.class);
                    intent.putExtra("path", liveUrl);
                    startActivity(intent);

                }
            });

            Lives lives = ds.get(position);
            holder.getLocation().setText(lives.getLocation());
            holder.getContent().setText(lives.getContent());
            holder.getCount().setText(lives.getVisitors_count() + "");
            holder.getName().setText(lives.getAuthor().getName());
            Picasso.with(getContext()).load(lives.getAuthor().getHeadurl()).into(holder.getImage());

        }


        class MyViewHolder extends RecyclerView.ViewHolder {
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
