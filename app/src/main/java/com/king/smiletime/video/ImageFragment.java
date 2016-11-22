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
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ImageFragment extends Fragment{

    private View view;
    private ImageView imageView;
    private String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.imagefragment, null);
        imageView = (ImageView) view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Picasso.with(getContext()).load(url).into(imageView);
        super.onActivityCreated(savedInstanceState);
    }
}
