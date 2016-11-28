package com.king.smiletime;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.king.views.MySelfView;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class LiveActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private String liveUrl;
    private MySelfView photo;
    private TextView authorName;
    private TextView count;
    private Button attention;
    private RecyclerView recyclerView;
    private TextView gift;
    private TextView nick_id;
    private MySelfView back;
    private MySelfView sendgift;
    private MySelfView share;
    private MySelfView edit;
    private String photoUrl;
    private String vistorcount;
    private String name;
    private String nick;
    private ImageView follower;
    private PopupWindow pw;

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

        aboutPopupWindow();

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

        Picasso.with(this).load(photoUrl).into(photo);
        authorName.setText(name);
        count.setText(vistorcount);
        nick_id.setText(nick);
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
        back = (MySelfView) findViewById(R.id.btn_return);//返回键
        sendgift = (MySelfView) findViewById(R.id.sendgift);//送礼物
        follower = (ImageView) findViewById(R.id.image_follow);
        follower.setVisibility(View.GONE);
        share = (MySelfView) findViewById(R.id.share);//分享
        edit = (MySelfView) findViewById(R.id.edit);//编辑

    }

    //直播功能
    public void playfunction(){
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
                follower.setVisibility(View.VISIBLE);
                //添加动画
                addanimator();
                break;
            case R.id.share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                // 构建PopupWindow的实例
                pw.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM,0,0);

                break;
            case R.id.edit:
                Toast.makeText(this, "发送消息", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    //分享
    private void aboutPopupWindow() {
        View contentView = View.inflate(this, R.layout.popupwindow, null);
        pw = new PopupWindow(contentView, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        pw.setHeight(340);
        ImageView wechat_cicle = (ImageView) contentView.findViewById(R.id.wechat_circle);
        ImageView wechat = (ImageView) contentView.findViewById(R.id.wechat);
        ImageView qq = (ImageView) contentView.findViewById(R.id.qq);
        ImageView qzone = (ImageView) contentView.findViewById(R.id.qzone);
        ImageView weibo = (ImageView) contentView.findViewById(R.id.weibo);
        ImageView qiuyou = (ImageView) contentView.findViewById(R.id.qiuyou);
        ImageView qiuyou_circle = (ImageView) contentView.findViewById(R.id.qiuyou_circle);
        ImageView copy = (ImageView) contentView.findViewById(R.id.copy);
        wechat_cicle.setOnClickListener(this);
        wechat.setOnClickListener(this);
        qq.setOnClickListener(this);
        qzone.setOnClickListener(this);
        weibo.setOnClickListener(this);
        qiuyou.setOnClickListener(this);
        qiuyou_circle.setOnClickListener(this);
        copy.setOnClickListener(this);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(pw.isShowing()){
                pw.dismiss();
            }
        }
        return super.onTouchEvent(event);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.wechat_circle:
                Toast.makeText(this, "分享到朋友圈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wechat:
                break;
            case R.id.qq:
                break;
            case R.id.qzone:
                break;
            case R.id.weibo:
                break;
            case R.id.qiuyou:
                break;
            case R.id.qiuyou_circle:
                break;
            case R.id.copy:
                break;
        }

    }

    //添加动画
    private void addanimator() {
        // 准备一个动画实例存放的容器
        List<Animator> items = new LinkedList<>();

        // 构建子动画的实例
        // 透明动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(follower, "alpha", 1f, 0f);

        // 动画实例属性的设置
        animator.setDuration(6000);
        animator.setRepeatCount(0);

        items.add(animator);

        // y轴方向
        // ①动画实例的创建
        animator = ObjectAnimator.ofFloat(follower, "translationY", 0, -200);
        // ②动画实例属性的设置
        animator.setDuration(6000);
        animator.setRepeatCount(0);
        items.add(animator);

        // x轴方向
        // ①动画实例的创建
         animator = ObjectAnimator.ofFloat(follower, "scaleX", 1, 2);
        // ②动画实例属性的设置
        animator.setDuration(6000);
        animator.setRepeatCount(0);
        items.add(animator);

        // y轴方向
        // ①动画实例的创建
        animator = ObjectAnimator.ofFloat(follower, "scaleY", 1, 2);

        // ②动画实例属性的设置
        animator.setDuration(6000);
        animator.setRepeatCount(0);
        items.add(animator);

        // 构建动画集
        AnimatorSet sets = new AnimatorSet();

        // 设置动画作用于的控件
        sets.setTarget(follower);

        // 一起播放
        sets.playTogether(items);

        // 启动动画
        sets.start();

    }


}
