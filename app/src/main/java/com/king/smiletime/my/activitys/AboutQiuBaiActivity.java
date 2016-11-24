package com.king.smiletime.my.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 关于糗百 AboutQiuBaiActivity
 * Created by XRenWu on 2016/11/21 22:04.
 */
@ContentView(R.layout.activity_aboutqiubai)
public class AboutQiuBaiActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);

	}
}
