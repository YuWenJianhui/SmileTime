package com.king.smiletime;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

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
        UMShareAPI.get(this);
        Config.REDIRECT_URL = "您新浪后台的回调地址";
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
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("mytoken",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });

    }
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");


    }
    public static Context getContext() {
        return mContext;
    }
}
