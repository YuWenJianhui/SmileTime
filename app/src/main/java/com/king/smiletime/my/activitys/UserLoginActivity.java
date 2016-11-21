package com.king.smiletime.my.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

/**
 * Created by Administrator on 2016/11/21.
 */

@ContentView(value = R.layout.activity_login)
public class UserLoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
	}

	@Event(value = R.id.btn_login_id)
	private void login(View view){
		Intent intent = new Intent(this,UserEditorActivity.class);
		startActivity(intent);
	}
}
