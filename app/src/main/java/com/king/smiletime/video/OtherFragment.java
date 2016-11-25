package com.king.smiletime.video;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class OtherFragment extends Fragment implements DownloadJsonDataAysncTask.JsonDataSettingCallBack{

    private View view;
    private ListView listView;
    private TextView replace;
    private String tabName;
    private String url;
    private ViewPager viewPager;
    private ImageView imageView;
    private List<String> ds;
    private Person person;


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
        view = inflater.inflate(R.layout.fragment_other, null);
        listView = (ListView) view.findViewById(R.id.listView);
        replace = (TextView) view.findViewById(R.id.tv_replace_id);
        listView.setEmptyView(replace);

        //关于ListView
        aboutlistView();
        return view;
    }




    private void fillData() {

    }

    @Override
    public void setJsonData(Person result) {


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
