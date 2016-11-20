package com.king.smiletime.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.king.smiletime.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ThirdFragment extends Fragment {

    private View view;
    private ListView listView;
    private TextView replace;
    private String tabName;
    private String url;
    private ViewPager viewPager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tabName = bundle.getString("tabName");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, null);
        viewPager = (ViewPager) view.findViewById(R.id.vp_id);
        listView = (ListView) view.findViewById(R.id.listView);
        replace = (TextView) view.findViewById(R.id.tv_replace_id);
        listView.setEmptyView(replace);

        //关于ListView
        aboutViewPager();
        //关于ListView
        aboutlistView();

        return view;
    }

    /**
     *
     */
    private void aboutViewPager() {
    }


    private void aboutlistView() {
        //数据源
        //适配器
        //绑定
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
