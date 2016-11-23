package com.king.smiletime.scandal;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.king.entity.JokesEntity;
import com.king.smiletime.R;
import com.king.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.util.zip.Inflater;


/**
 * Created by Administrator on 2016/11/17.
 */
public class JokesFragment extends Fragment {


    private ListView mLv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jokesfragment, null);
        mLv = (ListView) view.findViewById(R.id.jokeslv_id);
        TextView mTv = (TextView) view.findViewById(R.id.jokestv_id);
        mLv.setEmptyView(mTv);
        Bundle bundle = getArguments();
        String tabName = bundle.getString("tabName");
        String url = bundle.getString("url");
        new MyAsynctask().execute(url);


        return view;
    }


    private void aboutlistview(JokesEntity jokeentity) {
        //数据源
        View view1 = View.inflate(getContext(), R.layout.jokesfristitem, null);
        mLv.addHeaderView(view1);
        //适配器
        Myadapter adapter = new Myadapter(jokeentity);
        //绑定适配器
        mLv.setAdapter(adapter);
    }


    public class MyAsynctask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return HttpUtils.getJsonData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i("json", s.toString());
            JokesEntity entity = JSON.parseObject(s, JokesEntity.class);
            aboutlistview(entity);
        }
    }

    public class Myadapter extends BaseAdapter {
        private final int TYPE_TEXT = 0;// 只包含TextView的布局类型
        private final int TYPE_IMG = 1;// 都包含TextView，ImageView的布局类型
        private final int TYPE_VIDO = 2;
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
            } else if (joke.getItems().get(position).getFormat().equals("vido")) {
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
            ViewHolderVido holdervido = null;

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
                        holdervido = (ViewHolderVido) convertView.getTag();
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
                        Log.i("cuoma", "我好慌" + position);
                        String s = itemsBean.getUser().getUid() + "";
                        Log.i("cuo", s);
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
                        Log.i("cuoma", "我好慌" + position);
                        String imgtext = itemsBean.getUser().getUid() + "";
                        Log.i("cuo", imgtext);
                        String imgtext1 = imgtext.substring(0, imgtext.length() - 4);
                        StringBuffer imgbftitile = new StringBuffer();
                        imgbftitile.append("http://pic.qiushibaike.com/system/avtnew/").append(imgtext1);
                        imgbftitile.append("/" + imgtext).append("/medium/").append(itemsBean.getUser().getIcon());
                        Picasso.with(getContext()).load(imgbftitile.toString()).into(holderimg.headimg);
                        holderimg.username.setText(itemsBean.getUser().getLogin());
                    }
                    String jokeimgType = itemsBean.getType();
                    if ("hot".equals(jokeimgType)) {
                        holderimg.typeimg.setImageResource(resources.getIdentifier("fire", "mipmap", getActivity().getPackageName()));
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
                    break;
                default:
                    break;


            }

            return convertView;
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

        private final class ViewHolderVido {

        }
    }
}
