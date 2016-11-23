package com.king.smiletime.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.king.smiletime.MyApplication;

/**
 * *** MyBroadcastReceiver
 * Created by XRenWu on 2016/11/23 10:44.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Log.i("action",action);
		switch (action){
			case "android.net.conn.CONNECTIVITY_CHANGE":
				//若显示网络状态发生改变走这个分支
				ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo activeNetwork = systemService.getActiveNetworkInfo();
				if (activeNetwork!=null){
					if (activeNetwork.isAvailable()){
						//有网络
						int type = activeNetwork.getType();
						MyApplication.setNetType(type);
						Toast.makeText(context,type+"",Toast.LENGTH_LONG).show();
					}else{
						//有网络但不可用
						MyApplication.setNetType(MyApplication.INTNETNOUSE);
						Toast.makeText(context,"MyApplication.INTNETNOUSE",Toast.LENGTH_LONG).show();
					}
				}else {
					//无网络
					MyApplication.setNetType(MyApplication.NOINTNET);
					Toast.makeText(context,"MyApplication.NOINTNET",Toast.LENGTH_LONG).show();
				}
				break;
		}
	}
}
