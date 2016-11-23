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

@ContentView(value = R.layout.activity_userinformationparticulars)
public class UserInformationParticularsActivity extends Activity {

	private Intent purposeIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
	}
	@Event(value = {R.id.rl_background_id,R.id.iv_back_id,R.id.iv_editor_id,R.id.iv_user_id,
			R.id.ll_medals_id,R.id.ll_integral_id,R.id.iv_liveIntroduce_id,})
	private void editor(View view) {
		switch (view.getId()) {
			case R.id.rl_background_id:
				//点击背景图片变为下一张

				break;
			case R.id.iv_back_id:
				//点击返回
				onBackPressed();
				break;
			case R.id.iv_editor_id:
				//点击进入编辑
				purposeIntent = new Intent(this,UserEditorActivity.class);
				startActivity(purposeIntent);
				break;
			case R.id.iv_user_id:
				//点击放大图片
				break;
			case R.id.ll_medals_id:
				//点击进入勋章查看Activity
				break;
			case R.id.ll_integral_id:
				//点击进入积分说明Activity
				break;
			case R.id.iv_liveIntroduce_id:
				//点击查看我的等级Activity
				break;
		}
	}
}
