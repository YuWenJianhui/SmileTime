package com.king.smiletime.my.activitys;

import android.app.Activity;
import android.os.Bundle;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by Administrator on 2016/11/21.
 */

@ContentView(value = R.layout.activity_managementthing)
public class ManagermentThingActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
	}
}
