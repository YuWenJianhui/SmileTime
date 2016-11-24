package com.king.smiletime;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

import com.king.smiletime.my.MyFragment;
import com.king.smiletime.scandal.FirstFragment;
import com.king.smiletime.video.VideoFragment;

public class MainActivity extends FragmentActivity {


    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          //不显示actionbar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        ActionBar actionBar = getActionBar();
//        actionBar.show();
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.tdfl_id, new FirstFragment());
        transaction.commit();



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
                        .replace(R.id.tdfl_id,new VideoFragment()).commit();
                break;
            case R.id.my_id:
                fragmentManager.beginTransaction().replace(R.id.tdfl_id,new MyFragment()).commit();
                break;
        }
    }
}
