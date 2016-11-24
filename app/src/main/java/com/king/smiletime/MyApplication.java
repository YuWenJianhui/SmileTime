package com.king.smiletime;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/16.
 */

public class MyApplication extends Application {
    private static Context mContext;
    private static boolean isLogin;
    public static int netType;
    public static final int BLUETOOTH = 7;
    public static final int MOBILE = 0;
    public static final int VPN = 17;
    public static final int WIFI = 1;
    public static final int NOINTNET = 10;
    public static final int INTNETNOUSE = 11;

    public static int getNetType() {
        return netType;
    }
    public static void setNetType(int netType) {
        MyApplication.netType = netType;
    }

    public static void setIsLogin(boolean isLogin) {
        MyApplication.isLogin = isLogin;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        x.Ext.init(this);
        NetworkInfo activeNetwork = ((ConnectivityManager)(getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
        if (activeNetwork != null){
            if (activeNetwork.isAvailable()){
                netType = activeNetwork.getType();
            }else {
                netType = 11;
            }
        }else {
            netType = 10;
        }
        //greenDao全局配置,只希望有一个数据库操作对象


    }
    public static Context getContext() {
        return mContext;
    }
}
