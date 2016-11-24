package com.king.smiletime.scandal;


import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.king.entity.JokesEntity;
import com.king.smiletime.R;
import com.king.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;


/**
 * Created by Administrator on 2016/11/17.
 */
public class JokesFragment extends Fragment {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    private PullToRefreshListView mLv;
    private Myadapter adapter;
    private String url;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jokesfragment, null);
        mLv = (PullToRefreshListView) view.findViewById(R.id.jokeslv_id);

        TextView mTv = (TextView) view.findViewById(R.id.jokestv_id);
        mLv.setEmptyView(mTv);

        Bundle bundle = getArguments();
        String tabName = bundle.getString("tabName");
        url = bundle.getString("url");

        new MyAsynctask().execute(url);

        mLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                // Do work to refresh the list here.
                new GetDataTask().execute(url);
            }
        });
        return view;
    }

    private class GetDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // Simulates a background job.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return HttpUtils.getJsonData(params[0]);

        }

        @Override
        protected void onPostExecute(String result) {
            JokesEntity entity = JSON.parseObject(result, JokesEntity.class);
            aboutlistview(entity);


            // Call onRefreshComplete when the list has been refreshed.


            super.onPostExecute(result);
        }
    }


    private void aboutlistview(JokesEntity jokeentity) {
        //数据源

        //添加头部布局
        // View view1 = View.inflate(getContext(), R.layout.jokesfristitem, null);
        //mLv.addHeaderView(view1);

        mLv.onRefreshComplete();
        //适配器
        adapter = new Myadapter(jokeentity);
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener(getContext());
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        mLv.setOnPullEventListener(soundListener);
        //绑定适配器
        adapter.notifyDataSetChanged();
        mLv.setAdapter(adapter);
    }


    public class MyAsynctask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return HttpUtils.getJsonData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            JokesEntity entity = JSON.parseObject(s, JokesEntity.class);
            aboutlistview(entity);

        }
    }

    public class Myadapter extends BaseAdapter implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
        private final int TYPE_TEXT = 0;// 只包含TextView的布局类型
        private final int TYPE_IMG = 1;// 都包含TextView，ImageView的布局类型
        private final int TYPE_VIDO = 2;
        private int curPosition = -1;
        private JokesEntity joke;


        public Myadapter(JokesEntity joke) {
            this.joke = joke;
        }

        public Myadapter() {
        }

        @Override
        public int getCount() {
            return joke.getItems().size();
        }

        @Override
        public Object getItem(int position) {

            return position;


        }

        @Override
        public int getItemViewType(int position) {

            if (joke.getItems().get(position).getFormat().equals("word")) {
                return TYPE_TEXT;
            } else if (joke.getItems().get(position).getFormat().equals("image")) {
                return TYPE_IMG;
            } else if (joke.getItems().get(position).getFormat().equals("video")) {
                return TYPE_VIDO;
            }
            return 0;


        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoldertext holdertext = null;
            ViewHolderimg holderimg = null;
            ViewHolderVideo holdervido = null;
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnCompletionListener(this);
            JokesEntity.ItemsBean itemsBean = null;
            Resources resources = getResources();
            int type = getItemViewType(position);
            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                //根据自定义的Item布局加载布局

//
                switch (type) {

                    case TYPE_TEXT:
                        holdertext = new ViewHoldertext();
                        convertView = View.inflate(getContext(), R.layout.jokesitem, null);
                        holdertext.headimg = (ImageView) convertView.findViewById(R.id.jokesitmeheadimg_id);
                        holdertext.username = (TextView) convertView.findViewById(R.id.jokesitemusername_id);
                        holdertext.typeimg = (ImageView) convertView.findViewById(R.id.jokesitemtypeimg_id);
                        holdertext.typetext = (TextView) convertView.findViewById(R.id.jokesitemtypetext_id);
                        holdertext.itemtext = (TextView) convertView.findViewById(R.id.jokesitemtext_id);
                        holdertext.itemsmilenumb = (TextView) convertView.findViewById(R.id.jokesitemsmilenumb_id);
                        holdertext.itemcommentnumb = (TextView) convertView.findViewById(R.id.jokesitemcommentnumb_id);
                        holdertext.itemsharenumb = (TextView) convertView.findViewById(R.id.jokesitemsharenumb_id);
                        convertView.setTag(holdertext);
                        break;
                    case TYPE_IMG:
                        holderimg = new ViewHolderimg();
                        convertView = View.inflate(getContext(), R.layout.jokesitemimg, null);
                        holderimg.headimg = (ImageView) convertView.findViewById(R.id.jokesitmeimgheadimg_id);
                        holderimg.username = (TextView) convertView.findViewById(R.id.jokesitemimguesrname_id);
                        holderimg.typeimg = (ImageView) convertView.findViewById(R.id.jokesitemimgtypeimg_id);
                        holderimg.typetext = (TextView) convertView.findViewById(R.id.jokesitemimgtypetext_id);
                        holderimg.itemtext = (TextView) convertView.findViewById(R.id.jokesitemimgtext_id);
                        holderimg.itemimg = (ImageView) convertView.findViewById(R.id.jokesitemimg_id);
                        holderimg.itemsmilenumb = (TextView) convertView.findViewById(R.id.jokesitemimgsmilenumb_id);
                        holderimg.itemcommentnumb = (TextView) convertView.findViewById(R.id.jokesitemimgcommentnumb_id);
                        holderimg.itemsharenumb = (TextView) convertView.findViewById(R.id.jokesitemimgsharenumb_id);
                        convertView.setTag(holderimg);
                        break;
                    case TYPE_VIDO:
                        convertView = View.inflate(getContext(), R.layout.jokes_itemvideo, null);
                        holdervido = new ViewHolderVideo(convertView);

                        convertView.setTag(holdervido);
                        break;
                    default:
                        break;


                }
            }
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag

            else {

                switch (type) {
                    case TYPE_TEXT:
                        holdertext = (ViewHoldertext) convertView.getTag();
                        break;
                    case TYPE_IMG:
                        holderimg = (ViewHolderimg) convertView.getTag();
                        break;
                    case TYPE_VIDO:
                        holdervido = (ViewHolderVideo) convertView.getTag();
                        break;
                    default:
                        break;


                }
            }

            switch (type) {

                case TYPE_TEXT:

                    itemsBean = joke.getItems().get(position);
                    if (itemsBean.getUser() == null || "".equals(itemsBean.getUser())) {
                        holdertext.headimg.setImageResource(resources.getIdentifier("default_users_avatar", "mipmap", getContext().getPackageName()));
                        holdertext.username.setText("匿名用户");
                    } else {
                        String s = itemsBean.getUser().getUid() + "";
                        String s1 = s.substring(0, s.length() - 4) + "/";
                        StringBuffer textbf = new StringBuffer();
                        textbf.append("http://pic.qiushibaike.com/system/avtnew/").append(s1);
                        textbf.append(s + "/").append("thumb/").append(itemsBean.getUser().getIcon());

                        Picasso.with(getContext()).load(textbf.toString()).into(holdertext.headimg);

                        holdertext.username.setText(itemsBean.getUser().getLogin());
                    }
                    String jokeType = itemsBean.getType();

                    if ("hot".equals(jokeType)) {
                        holdertext.typeimg.setImageResource(resources.getIdentifier("fire", "mipmap", getContext().getPackageName()));
                        holdertext.typetext.setText("火热");
                    } else if ("fresh".equals(jokeType)) {
                        holdertext.typeimg.setImageResource(resources.getIdentifier("leaf", "mipmap", getContext().getPackageName()));
                        holdertext.typetext.setText("新鲜");
                    } else if ("".equals(jokeType) || jokeType == null) {

                    }
                    holdertext.itemtext.setText(itemsBean.getContent());
                    holdertext.itemsmilenumb.setText(itemsBean.getVotes().getUp() + "");
                    holdertext.itemcommentnumb.setText(itemsBean.getComments_count() + "");
                    holdertext.itemsharenumb.setText(itemsBean.getShare_count() + "");
                    break;
                case TYPE_IMG:
                    itemsBean = joke.getItems().get(position);
                    if (itemsBean.getUser() == null || "".equals(itemsBean.getUser())) {
                        holderimg.headimg.setImageResource(resources.getIdentifier("default_users_avatar", "mipmap", getContext().getPackageName()));
                        holderimg.username.setText("匿名用户");
                    } else {
                        String imgtext = itemsBean.getUser().getUid() + "";
                        String imgtext1 = imgtext.substring(0, imgtext.length() - 4);
                        StringBuffer imgbftitile = new StringBuffer();
                        imgbftitile.append("http://pic.qiushibaike.com/system/avtnew/").append(imgtext1);
                        imgbftitile.append("/" + imgtext).append("/medium/").append(itemsBean.getUser().getIcon());
                        Picasso.with(getContext()).load(imgbftitile.toString()).into(holderimg.headimg);
                        holderimg.username.setText(itemsBean.getUser().getLogin());
                    }
                    String jokeimgType = itemsBean.getType();
                    if ("hot".equals(jokeimgType)) {
                        holderimg.typeimg.setImageResource(resources.getIdentifier("fire", "mipmap", getContext().getPackageName()));
                        holderimg.typetext.setText("火热");
                    } else if ("fresh".equals(jokeimgType)) {
                        holderimg.typeimg.setImageResource(resources.getIdentifier("leaf", "mipmap", getContext().getPackageName()));
                        holderimg.typetext.setText("新鲜");
                    } else if ("".equals(jokeimgType) || jokeimgType == null) {

                    }
                    holderimg.itemtext.setText(itemsBean.getContent());
                    String img = itemsBean.getId() + "";
                    String img1 = img.substring(0, img.length() - 4) + "/";
                    StringBuffer imgbf = new StringBuffer();
                    imgbf.append("http://pic.qiushibaike.com/system/pictures/").append(img1);
                    imgbf.append(img + "/").append("medium/").append(itemsBean.getImage());
                    Picasso.with(getContext()).load(imgbf.toString()).into(holderimg.itemimg);
                    holderimg.itemsmilenumb.setText(itemsBean.getVotes().getUp() + "");
                    holderimg.itemcommentnumb.setText(itemsBean.getComments_count() + "");
                    holderimg.itemsharenumb.setText(itemsBean.getShare_count() + "");
                    break;
                case TYPE_VIDO:
                    itemsBean = joke.getItems().get(position);
                    if (itemsBean.getUser() == null || "".equals(itemsBean.getUser())) {
                        holdervido.headimg.setImageResource(resources.getIdentifier("default_users_avatar", "mipmap", getContext().getPackageName()));
                        holdervido.username.setText("匿名用户");
                    } else {
                        String imgtext = itemsBean.getUser().getUid() + "";
                        String imgtext1 = imgtext.substring(0, imgtext.length() - 4);
                        StringBuffer videobftitile = new StringBuffer();
                        videobftitile.append("http://pic.qiushibaike.com/system/avtnew/").append(imgtext1);
                        videobftitile.append("/" + imgtext).append("/medium/").append(itemsBean.getUser().getIcon());
                        Picasso.with(getContext()).load(videobftitile.toString()).into(holdervido.headimg);
                        holdervido.username.setText(itemsBean.getUser().getLogin());
                    }
                    String jokevideoType = itemsBean.getType();
                    if ("hot".equals(jokevideoType)) {
                        holdervido.typeimg.setImageResource(resources.getIdentifier("fire", "mipmap", getContext().getPackageName()));
                        holdervido.typetext.setText("火热");
                    } else if ("fresh".equals(jokevideoType)) {
                        holdervido.typeimg.setImageResource(resources.getIdentifier("leaf", "mipmap", getContext().getPackageName()));
                        holdervido.typetext.setText("新鲜");
                    } else if ("".equals(jokevideoType) || jokevideoType == null) {

                    }
                    if (itemsBean.getContent() == null || "".equals(itemsBean.getContent())) {

                    } else {
                        holdervido.itemtext.setText(itemsBean.getContent());
                    }
                    if (itemsBean.getPic_url() != null) {
                        Picasso.with(getContext()).load(itemsBean.getPic_url()).into(holdervido.itemvideoimg);
                    }
                    if (holdervido.itemvideoimg.getTag() != null) {
                        int pos = (int) holdervido.itemvideoimg.getTag();
                        if (pos == curPosition && pos != position)//pos==curPosition表示：如果复用item出现了，则停止被复用的item的播放，这种其实不太好，如果离复用还有好几个item，就不会在第一时间停止播放
                        {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                                curPosition = -1;
                            }
                        }
                    }
                    holdervido.itemvideoimg.setTag(position);

                    if (curPosition == position) {
                        holdervido.itemvideoimg.setVisibility(View.INVISIBLE);
                        holdervido.itemsurface.setVisibility(View.VISIBLE);
                        mediaPlayer.reset();
                        try {
                            mediaPlayer.setDisplay(holdervido.itemsurface.getHolder());
                            if (itemsBean.getHigh_url() != null) {
                                mediaPlayer.setDataSource(itemsBean.getHigh_url());
                            } else {
                                mediaPlayer.setDataSource(itemsBean.getLow_url());
                            }
                            mediaPlayer.prepareAsync();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        holdervido.itemvideoimg.setVisibility(View.VISIBLE);
                        holdervido.itemsurface.setVisibility(View.INVISIBLE);
                    }
                    holdervido.itemsmilenumb.setText(itemsBean.getVotes().getUp() + "");
                    holdervido.itemcommentnumb.setText(itemsBean.getComments_count() + "");
                    holdervido.itemsharenumb.setText(itemsBean.getShare_count() + "");
                    break;
                default:
                    break;


            }

            return convertView;
        }

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            curPosition = -1;
        }

        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }


        class ViewHoldertext {

            public ImageView headimg;
            public TextView username;
            public ImageView typeimg;
            public TextView typetext;
            public TextView itemtext;
            public TextView itemsmilenumb;
            public TextView itemcommentnumb;
            public TextView itemsharenumb;

        }

        private final class ViewHolderimg {
            public ImageView headimg;
            public TextView username;
            public ImageView typeimg;
            public TextView typetext;
            public TextView itemtext;
            public ImageView itemimg;
            public TextView itemsmilenumb;
            public TextView itemcommentnumb;
            public TextView itemsharenumb;
        }

        private final class ViewHolderVideo implements View.OnClickListener {
            public ImageView headimg;
            public TextView username;
            public ImageView typeimg;
            public TextView typetext;
            public TextView itemtext;
            public SurfaceView itemsurface;
            public ImageView itemvideoimg;
            public TextView itemsmilenumb;
            public TextView itemcommentnumb;
            public TextView itemsharenumb;

            public ViewHolderVideo(View convertView) {

                this.headimg = (ImageView) convertView.findViewById(R.id.jokesitmevideoheadimg_id);
                this.username = (TextView) convertView.findViewById(R.id.jokesitemvideouesrname_id);
                this.typeimg = (ImageView) convertView.findViewById(R.id.jokesitemvideotypeimg_id);
                this.typetext = (TextView) convertView.findViewById(R.id.jokesitemvideotypetext_id);
                this.itemtext = (TextView) convertView.findViewById(R.id.jokesitemvideotext_id);
                this.itemsurface = (SurfaceView) convertView.findViewById(R.id.jokesitemvideo_id);
                this.itemvideoimg = (ImageView) convertView.findViewById(R.id.jokesitemvideoimg_id);
                this.itemsmilenumb = (TextView) convertView.findViewById(R.id.jokesitemvideosmilenumb_id);
                this.itemcommentnumb = (TextView) convertView.findViewById(R.id.jokesitemvideocommentnumb_id);
                this.itemsharenumb = (TextView) convertView.findViewById(R.id.jokesitemvideosharenumb_id);
                itemvideoimg.setOnClickListener(this);
                itemsurface.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.jokesitemvideoimg_id:
                        view.setVisibility(View.INVISIBLE);
                        curPosition = (int) view.getTag();
                        break;
                    case R.id.jokesitemvideo_id:
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            curPosition = -1;
                        }
                        break;
                }
                notifyDataSetChanged();
            }


        }

    }
}
