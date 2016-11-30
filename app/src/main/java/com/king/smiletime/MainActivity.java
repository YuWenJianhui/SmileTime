package com.king.smiletime;


import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.king.smiletime.my.MyFragment;
import com.king.smiletime.scandal.FirstFragment;
import com.king.smiletime.video.VideoFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends FragmentActivity {


    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //不显示actionbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
                tintManager.setStatusBarTintResource(R.color.colorQiubaiYello);//通知栏所需颜
        }


        super.onCreate(savedInstanceState);


//        ActionBar actionBar = getActionBar();
//        actionBar.show();
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.tdfl_id, new FirstFragment());
        transaction.commit();


    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }

        win.setAttributes(winParams);
    }
    public void BtnAction(View view) {
        switch (view.getId()) {
            case R.id.scandal_id:
                fragmentManager.beginTransaction()
                        .replace(R.id.tdfl_id, new FirstFragment()).commit();
                break;
            case R.id.friend_id:

                break;
            case R.id.video_id:
                fragmentManager.beginTransaction()
                        .replace(R.id.tdfl_id, new VideoFragment()).commit();
                break;
            case R.id.my_id:
                fragmentManager.beginTransaction().replace(R.id.tdfl_id, new MyFragment()).commit();
                break;
        }
    }
}
