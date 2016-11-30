package com.king.smiletime.video;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.king.smiletime.WebActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ImageFragment extends Fragment{

    private View view;
    private ImageView imageView;
    private String url;
    private String tag;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        tag = bundle.getString("tag");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.imagefragment, null);
        imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tag.equals("1")){
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("imageUrl","http://mmbiz.qpic.cn/mmbiz_jpg/uO8gic0Fb8bZNWImkFCpRhVkN6nhRTXLGDnEvsG0BtiaqYFdmycwWNThF3VnNzCuIAza4WuvrvjWWlvPhOthoibZw/640");
                    startActivity(intent);

                }else if(tag.equals("2")){
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("imageUrl","http://static.huoshantv.com/images/touch/banner-1.png");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("imageUrl","http://static.app-remix.com/images/touch/rule_banner.png");
                    startActivity(intent);
                }

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Picasso.with(getContext()).load(url).into(imageView);
        super.onActivityCreated(savedInstanceState);
    }
}
