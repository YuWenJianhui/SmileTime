package com.king.smiletime.my.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 个人信息编辑界面 UserEditorActivity
 * Created by Administrator on 2016/11/21.
 */

@ContentView(R.layout.activity_usereditor)
public class UserEditorActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
		setTitle("编辑资料");
	}
}
