package com.king.smiletime;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.king.smiletime.friends.FriendsFragment;
import com.king.smiletime.my.MyFragment;
import com.king.smiletime.scandal.FirstFragment;
import com.king.smiletime.video.VideoFragment;

public class MainActivity extends FragmentActivity {


    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          //不显示actionbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //添加注释实验一下




    }


    public void BtnAction(View view) {
        switch (view.getId()) {
            case R.id.scandal_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tdfl_id,new FirstFragment()).commit();

                break;
            case R.id.friend_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tdfl_id,new FriendsFragment()).commit();

                break;
            case R.id.video_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tdfl_id,new VideoFragment()).commit();

                break;
            case R.id.my_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tdfl_id,new MyFragment()).commit();


                break;
        }
    }
}
