package com.king.smiletime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Description：欢迎界面<br/>
 * Copyright (c) , 2016, Jansonxu <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name:WelcomeActivity.java <br/>
 * Date:2016-10-8
 *
 * @author
 * @version : 1.0
 */
public class WelcomeActivity extends FragmentActivity {

    private List<View> ds;
    private ViewPager vp;
    private LinearLayout llContainer;
    int beforePos;// 用来记录上一次被选中的小圆点索引
    private SharedPreferences sharedPreferences;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //欢迎界面完毕后启动主界面
            Intent it = new Intent();
            it.setClass(WelcomeActivity.this, MainActivity.class);
            WelcomeActivity.this.startActivity(it);
            WelcomeActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SharedPreferences实例的获取
        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        boolean isUsed = sharedPreferences.getBoolean("isUsed", false);// true:该app曾经使用过；false：第一次启动

        // 分析：

        // 1、app的入口永远是欢迎界面
        // 根据参数偏好设置中存储的值，判定app使用的情况
        if (isUsed) {
            // ①若使用过，不要加载欢迎界面，直接跳转到主界面

            setContentView(R.layout.welcomeopen_activity);

            TextView mTv = (TextView) findViewById(R.id.opencancel_id);
            // finish一次
            mTv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    WelcomeActivity.this.finish();
                }
            });

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                    }
                    handler.sendEmptyMessage(0);
                }
            }).start();


        } else

        {
            // ②若没有使用，加载欢迎界面，且：用户点击最后一个界面上的“立即体验”后，
            // 跳转到主界面；且，将使用情况存储到参数偏好设置文件中。
            // 2、最后一个欢迎界面，是两张图片合成的产物，只有点击“立即体验”后，才会有效果，别的地方没有效果。

            setContentView(R.layout.activity_welcome);

            // 获得界面控件实例
            vp = (ViewPager) findViewById(R.id.vp_id);
            llContainer = (LinearLayout) findViewById(R.id.ll_container_id);

            // 关于小圆点的操作
            aboutLittleDots();

            // 关于ViewPager的操作
            aboutViewPager();

        }

    }

    /**
     * 关于小圆点的操作
     */
    private void aboutLittleDots() {
        MyOnClickListener listener = new MyOnClickListener();

        // 获得父控件
        // 所有的子控件初始化
        for (int i = 0; i < llContainer.getChildCount(); i++) {
            ImageView iv = (ImageView) llContainer.getChildAt(i);
            iv.setEnabled(true);// 通过代码控制控件的enable属性，读取选择器，动态选择图片展示
            iv.setTag(i);// 给当前的ImageView添加别名
            iv.setOnClickListener(listener);
        }
        // 默认的第一项应该是enable状态
        llContainer.getChildAt(0).setEnabled(false);
    }

    // 点击监听器
    private final class MyOnClickListener implements OnClickListener {

        /*
         * (non-Javadoc)
         *
         * @see android.view.View.OnClickListener#onClick(android.view.View)
         */
        @Override
        public void onClick(View v) {
            // 当前选中的小圆点决定ViewPager的状态
            vp.setCurrentItem((Integer) v.getTag());// ViewPager数据源的编号与小圆点在LinearLayout中的编号一样的
        }

    }

    /**
     * 关于ViewPager的操作
     */
    private void aboutViewPager() {
        // ①数据源
        ds = new LinkedList<>();
        fillDataSource();

        // ②适配器
        PagerAdapter adapter = new MyPageAdapter();

        // ③绑定适配器
        vp.setAdapter(adapter);

        // ④添加监听器（当前ViewPager所对应的页面决定小圆点的状态）
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            /*
             * (non-Javadoc)
             *
             * @see
             * android.support.v4.view.ViewPager.SimpleOnPageChangeListener#
             * onPageSelected(int)
             */
            @Override
            public void onPageSelected(int position) {
                llContainer.getChildAt(beforePos).setEnabled(true);
                llContainer.getChildAt(position).setEnabled(false);
                beforePos = position;
            }
        });

    }

    // PagerAdapter自定义子类
    private final class MyPageAdapter extends PagerAdapter {

        /*
         * (non-Javadoc)
         *
         * @see android.support.v4.view.PagerAdapter#getCount()
         */
        @Override
        public int getCount() {

            return ds.size();
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.support.v4.view.PagerAdapter#isViewFromObject(android.view
         * .View, java.lang.Object)
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.support.v4.view.PagerAdapter#instantiateItem(android.view
         * .ViewGroup, int)
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = ds.get(position);
            container.addView(view);

            return view;
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.support.v4.view.PagerAdapter#destroyItem(android.view.ViewGroup
         * , int, java.lang.Object)
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    /**
     * 填充数据源
     */
    private void fillDataSource() {
        // 1、将两张图片作为Fragment对应的View
        // 将资源目录drawable下的图片，转换成ImageView的实例，添加到数据源中

        Resources resources = getResources();

        String[] picNames = resources.getStringArray(R.array.picNames);

        for (String picName : picNames) {
            // 获得图片的资源id
            int picResId = resources.getIdentifier(picName, "mipmap",
                    getPackageName());
            addViewToDS(picResId);
        }

        // 2、将最后一张图片作为Fragment对应的View
        addViewToDS(0);

    }

    /**
     * @param
     */
    private void addViewToDS(int picResId) {
        if (picResId != 0) {// 欢迎界面前两张图片
            // 构建View的实例
            ImageView iv = new ImageView(this);
            iv.setImageResource(picResId);

            // 将当前的ImageView实例添加到数据源中
            ds.add(iv);
        } else {// 最后一个页面（RelativeLayout）
            View view = View.inflate(this, R.layout.third_page, null);

            ImageView iv = (ImageView) view.findViewById(R.id.iv_id);

            ds.add(view);

            // 添加监听器
            iv.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 将使用情况使用SharedPreferences保存起来

                    Editor edit = sharedPreferences.edit();
                    edit.putBoolean("isUsed", true);
                    edit.commit();

                    // 跳转到主界面
                    startActivity(new Intent(WelcomeActivity.this,
                            MainActivity.class));

                    // 从Back Stack中销毁当前的欢迎界面
                    finish();
                }
            });
        }
    }

}
