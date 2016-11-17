package com.king.smiletime;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/16.
 */

public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        x.Ext.init(this);
        //greenDao全局配置,只希望有一个数据库操作对象

    }
    public static Context getContext() {
        return mContext;
    }
}
