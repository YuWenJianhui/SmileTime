package com.king.smiletime.my.activitys;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 附近的糗友界面 NearFriendActivity
 * Created by XRenWu on 2016/11/21 21:44.
 */

@ContentView(R.layout.activity_nearfriend)
public class NearFriendActivity extends ListActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
		//步骤：

	}
}
