package com.king.smiletime.my.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 我的勋章管理里界面 MyMedalManageActivity
 * Created by XRenWu on 2016/11/21 21:59.
 */

@ContentView(R.layout.activity_mymedalmanage)
public class MyMedalManageActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
	}
}

