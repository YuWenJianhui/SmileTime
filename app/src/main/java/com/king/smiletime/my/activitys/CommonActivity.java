package com.king.smiletime.my.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.king.smiletime.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 共同的Activity CommonActivity
 * Created by XRenWu on 2016/11/21 21:50.
 */
@ContentView(R.layout.activity_common)
public class CommonActivity extends AppCompatActivity {

	@ViewInject(R.id.wv_id)
	private WebView mWebView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		switch (url){
			case "http://www.qiushibaike.com/topic?uuid=IMEI_2cdcd77f301481529c79a67f53ed7604":
				//小鸡
				setTitle("小鸡对蘑菇");
				break;
			case "http://www.wemart.cn/mobile/?chanId=&shelfNo=9203&sellerId=3646&a=shelf&m=index&appId=3045712&user_id=IMEI_2cdcd77f301481529c79a67f53ed7604&c=19":
				//糗百货
				setTitle("糗百货");
				break;
			case "http://api.qiushibaike.com/verify/code?url=http://gc.hgame.com/app/qsbk/transfer/gameid/pt/373?from=qbandroid":
				//游戏
				setTitle("糗百游戏中心");
				break;
			case "http://m2.qiushibaike.com/feedback?platform=android&source=android_10.5.1&userid=IMEI_2cdcd77f301481529c79a67f53ed7604&device=Xiaomi%2Fvirgo%2Fvirgo%3A6.0.1%2FMMB29M%2FV8.1.1.0.MXECNDI%3Auser%2Frelease-keys&theme=&channel=19":
				//意见反馈
				setTitle("意见反馈");
				ActionBar supportActionBar = getSupportActionBar();

				supportActionBar.setDisplayHomeAsUpEnabled(true);
				supportActionBar.setDisplayShowHomeEnabled(true);
				break;



		}
		WebSettings settings = mWebView.getSettings();

		settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
		settings.setSupportMultipleWindows(true);
		settings.setJavaScriptEnabled(true);
		settings.setSavePassword(false);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
		settings.setAllowFileAccess(false);
		settings.setTextSize(WebSettings.TextSize.NORMAL);
		mWebView.setVerticalScrollbarOverlay(true);
		mWebView.setWebViewClient(new WebViewClient());
		mWebView.loadUrl(url);

	}
}
