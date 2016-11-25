package com.king.smiletime;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.provider.MediaStore;
import io.vov.vitamio.widget.VideoView;

public class LiveActivity extends AppCompatActivity {

    private VideoView videoView;
    private String liveUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.liveactivity);
        videoView = (VideoView) findViewById(R.id.videoView);
        Intent intent = getIntent();
        liveUrl = intent.getStringExtra("path");
        playfunction();

    }
    public void playfunction(){
        videoView.setVideoPath(liveUrl);
        videoView.requestFocus();

    }
}
