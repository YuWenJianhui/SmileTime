package com.king.smiletime.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.king.smiletime.R;
import com.king.smiletime.my.activitys.ManagermentThingActivity;
import com.king.smiletime.my.activitys.UserLoginActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/11/17.
 */
@ContentView(R.layout.fragment_my)
public class MyFragment extends Fragment implements View.OnClickListener{

	@ViewInject(value = R.id.rl_login_id)
    private RelativeLayout mrl_login;  //点击登录
    @ViewInject(value = R.id.tv_nearUser_id)
    private TextView mtv_nearUser;     //点击打开附近的糗友的Activity
    @ViewInject(value = R.id.tv_group_id)
    private TextView mtv_group;        //点击打开群的Activity
    @ViewInject(value = R.id.tv_merchandise_id)
    private TextView mtv_merchandise;  //点击打开糗百货
    @ViewInject(value = R.id.tv_chick_id)
    private TextView mtv_chick;        //点击打小鸡
    @ViewInject(value = R.id.rl_qiuBaimanager_id)
    private RelativeLayout mrl_qiuBaimanager; //点击打开管理糗事和动态Activity
    @ViewInject(value = R.id.rl_myMedal_id)
    private RelativeLayout mrl_myMedal;	//点击打开我的勋章Activity
    @ViewInject(value = R.id.rl_gameCenter_id)
    private RelativeLayout mrl_gameCenter;	//点击打开游戏中心Activity
    @ViewInject(value = R.id.rl_nightMoon_id)
    private RelativeLayout mrl_nightMoon;	//点击设置成夜间模式再次点击设置成白天模式
    @ViewInject(value = R.id.rl_select_id)
    private RelativeLayout mrl_select;	//点击打开游戏中心Activity
	private Intent intent;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		 return x.view().inject(this, inflater, container);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		mrl_login.setOnClickListener(this);
		mtv_nearUser.setOnClickListener(this);
		mtv_group.setOnClickListener(this);
		mtv_merchandise.setOnClickListener(this);
		mtv_chick.setOnClickListener(this);
		mrl_qiuBaimanager.setOnClickListener(this);
		mrl_myMedal.setOnClickListener(this);
		mrl_gameCenter.setOnClickListener(this);
		mrl_nightMoon.setOnClickListener(this);
		mrl_select.setOnClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}



	/**
	 * 点击登录
	 *
	 * @param view
	 */
//    @Event(value = {R.id.rl_login_id,R.id.tv_nearUser_id,R.id.tv_group_id,R.id.tv_merchandise_id,
//            R.id.tv_chick_id,R.id.rl_qiuBaimanager_id,R.id.rl_myMedal_id,R.id.rl_gameCenter_id,R.id.rl_nightMoon_id,
//            R.id.rl_select_id})
//	public void login(View view) {
//
//	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.rl_login_id:
				//点击登录
				intent = new Intent(getContext(), UserLoginActivity.class);
				startActivity(intent);
				break;
			case R.id.tv_nearUser_id:
				//点击打开附近的糗友的Activity
				break;
			case R.id.tv_group_id:
				//点击打开群的Activity
				break;
			case R.id.tv_merchandise_id:
				//点击打开糗百货
				break;
			case R.id.tv_chick_id:
				//点击打小鸡
				break;
			case R.id.rl_qiuBaimanager_id:
				//点击打开管理糗事和动态Activity
				intent = new Intent(getActivity(), ManagermentThingActivity.class);
				startActivity(intent);
				break;
			case R.id.rl_myMedal_id:
				//点击打开我的勋章Activity
				break;
			case R.id.rl_gameCenter_id:
				//点击打开游戏中心Activity
				break;
			case R.id.rl_nightMoon_id:
				//点击设置成夜间模式再次点击设置成白天模式
				break;
			case R.id.rl_select_id:
				//点击打开游戏中心Activity
				break;
		}
	}
}
