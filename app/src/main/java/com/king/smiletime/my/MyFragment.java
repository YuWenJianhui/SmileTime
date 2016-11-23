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
import android.widget.Toast;

import com.king.smiletime.MainActivity;
import com.king.smiletime.MyApplication;
import com.king.smiletime.R;
import com.king.smiletime.my.activitys.CommonActivity;
import com.king.smiletime.my.activitys.GroupActivity;
import com.king.smiletime.my.activitys.ManagermentThingActivity;
import com.king.smiletime.my.activitys.MymedalActivity;
import com.king.smiletime.my.activitys.NearFriendActivity;
import com.king.smiletime.my.activitys.SettingsActivity;
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
//	private void login(View view) {
//
//	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.rl_login_id:
				//点击登录
				toOnpenUserLoginActivity();
				break;
			case R.id.tv_nearUser_id:
				toOnpenNearUserActivity();
				break;
			case R.id.tv_group_id:
				//点击打开群的Activity
				toOnpenGroupActivity();
				break;
			case R.id.tv_merchandise_id:
				//点击打开糗百货
				toOnpenCommonActivity("http://www.wemart.cn/mobile/?chanId=&shelfNo=9203&sellerId=3646&a=shelf&m=index&appId=3045712&user_id=IMEI_2cdcd77f301481529c79a67f53ed7604&c=19");
				break;
			case R.id.tv_chick_id:
				//点击打小鸡
				toOnpenCommonActivity("http://www.qiushibaike.com/topic?uuid=IMEI_2cdcd77f301481529c79a67f53ed7604");
				break;
			case R.id.rl_qiuBaimanager_id:
				//点击打开管理糗事和动态Activity
				toOnpenManagermentThingActivity();
				break;
			case R.id.rl_myMedal_id:
				//点击打开我的勋章Activity
				toOnpenMymedalActivity();
				break;
			case R.id.rl_gameCenter_id:
				//点击打开游戏中心Activity
				toOnpenCommonActivity("http://api.qiushibaike.com/verify/code?url=http://gc.hgame.com/app/qsbk/transfer/gameid/pt/373?from=qbandroid");
				break;
			case R.id.rl_nightMoon_id:
				//点击设置成夜间模式再次点击设置成白天模式
				settingShowPattern();
				break;
			case R.id.rl_select_id:
				//点击设置Activity
				toOnpenSettingsActivity();
				break;
		}
	}

	/**
	 * 点击设置Activity
	 */
	private void toOnpenSettingsActivity() {
		intent = new Intent(getContext(), SettingsActivity.class);
		startActivity(intent);
	}

	/**
	 * 点击设置成夜间模式再次点击设置成白天模式
	 */
	private void settingShowPattern() {
		getActivity().getApplication().setTheme(R.style.NightTHeme);
	}

	/**
	 * 点击打开我的勋章Activity
	 */
	private void toOnpenMymedalActivity() {
		intent = new Intent(getActivity(), MymedalActivity.class);
		startActivity(intent);
	}

	/**
	 * 点击打开管理糗事和动态Activity
	 */
	private void toOnpenManagermentThingActivity() {
		intent = new Intent(getActivity(), ManagermentThingActivity.class);
		startActivity(intent);
	}

	/**
	 * 根据参数传过来的不同的url分别打开糗百货或者小鸡或者游戏中心
	 * @param url
	 */
	private void toOnpenCommonActivity(String url) {
		intent = new Intent(getContext(), CommonActivity.class);
		intent.putExtra("url",url);
		startActivity(intent);
	}

	/**
	 * 点击打开群的Activity
	 */
	private void toOnpenGroupActivity() {
		intent = new Intent(getContext(), GroupActivity.class);
		startActivity(intent);
	}

	/**
	 * 点击登录
	 */
	private void toOnpenUserLoginActivity() {
		intent = new Intent(getContext(), UserLoginActivity.class);
		startActivity(intent);
	}

	/**
	 * 点击打开附近的糗友的Activity
	 */
	private void toOnpenNearUserActivity() {
		//点击打开附近的糗友的Activity
		//1、首先判断是否登录
		if (MyApplication.isLogin()){
			// 如果没有登录就跳转到登录界面
			toOnpenUserLoginActivity();
		}else {
			//2、如果登录再判断是否有网络，如果没有网络弹出吐司 网络连接失败，请检查网络设置
			if (MyApplication.getNetType() == MyApplication.NOINTNET){
				Toast.makeText(getContext(),"没有网络，请检查网络设置",Toast.LENGTH_LONG).show();
			}else {
				//3、如果有网络异步任务加载附近的糗友到ListView列表中加载完成之前ListView中显示的一个ProgressDialog
				//如果加载完成了就隐藏ProgressDialog显示ListView
				intent = new Intent(getContext(), NearFriendActivity.class);
				startActivity(intent);
			}

		}
	}
}
