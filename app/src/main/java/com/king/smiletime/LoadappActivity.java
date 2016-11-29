package com.king.smiletime;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class LoadappActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appactivity);
        getActionBar().setTitle("发起直播");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        TextView load = (TextView) findViewById(R.id.tv_load);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "下载热猫直播app", Toast.LENGTH_SHORT).show();
    }

}
