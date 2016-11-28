package com.king.smiletime;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.views.MySelfView;
import com.squareup.picasso.Picasso;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.provider.MediaStore;
import io.vov.vitamio.widget.VideoView;

public class LiveActivity extends AppCompatActivity {

    private VideoView videoView;
    private String liveUrl;
    private MySelfView photo;
    private TextView authorName;
    private TextView count;
    private Button attention;
    private RecyclerView recyclerView;
    private TextView gift;
    private TextView nick_id;
    private ImageButton back;
    private ImageButton sendgift;
    private ImageButton share;
    private ImageButton edit;
    private String photoUrl;
    private String vistorcount;
    private String name;
    private String nick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.liveactivity);
        //界面实例的初始化
        initWeights();
        //获取intnet的数据
        getData();
        //关于直播功能
        playfunction();
        //关于recyclerView
        aboutRecyclerView();

    }

    /**
     * 关于RecyclerView的操作
     */
    private void aboutRecyclerView() {
        //数据源
        //适配器
        //绑定适配器
        //监听器
    }

    private void getData() {
        Intent intent = getIntent();
        liveUrl = intent.getStringExtra("path");
        photoUrl = intent.getStringExtra("photo");
        name = intent.getStringExtra("author");
        nick = intent.getStringExtra("nick_id");
        vistorcount = intent.getStringExtra("count");
    }

    /**
     * 界面实例的初始化
     */
    private void initWeights() {
        videoView = (VideoView) findViewById(R.id.videoView);
        photo = (MySelfView) findViewById(R.id.photo);//主播头像
        authorName = (TextView) findViewById(R.id.tv_author);//主播名字
        count = (TextView) findViewById(R.id.count);//看直播人数
        attention = (Button) findViewById(R.id.attention);//关注
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        gift = (TextView) findViewById(R.id.gift);//礼券
        nick_id = (TextView) findViewById(R.id.room_id);//热猫号
        back = (ImageButton) findViewById(R.id.btn_return);//返回键
        sendgift = (ImageButton) findViewById(R.id.sendgift);//送礼物
        share = (ImageButton) findViewById(R.id.share);//分享
        edit = (ImageButton) findViewById(R.id.edit);//编辑

    }

    //直播功能
    public void playfunction(){
        Picasso.with(this).load(photoUrl).into(photo);
        authorName.setText(name);
        count.setText(vistorcount);
        nick_id.setText(nick);
        videoView.setVideoPath(liveUrl);
        videoView.requestFocus();
    }


    public void onClickAction(View view) {
        switch(view.getId()){
            case R.id.photo:
            case R.id.tv_author:
                Toast.makeText(this, "名字"+authorName.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.attention:
                Toast.makeText(this, "关注", Toast.LENGTH_SHORT).show();
                attention.setVisibility(View.GONE);
                break;
            case R.id.gift:
                Toast.makeText(this, "礼券", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_return:
                onBackPressed();
                break;
            case R.id.sendgift:
                Toast.makeText(this, "送花", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(this, "发送消息", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
