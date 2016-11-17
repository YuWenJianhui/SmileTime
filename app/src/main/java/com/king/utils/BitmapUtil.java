package com.king.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/10/25.
 */

public class BitmapUtil {



    public static Bitmap getBitmap(String url) {
        Bitmap bm = null;
        ByteArrayInputStream bis=null;
        InputStream is = null;
        try {
            URL iconUrl = new URL(url);
            URLConnection conn = iconUrl.openConnection();
            HttpURLConnection http = (HttpURLConnection) conn;
            //获得图像的字符流
            if (http.getResponseCode() == 200) {
                is = conn.getInputStream();
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                int len = -1;
//               byte[] b = new byte[1024 * 4];
//                while ((len = is.read(b)) != -1) {
//                    out.write(b, 0, len);
//                }
//                bis = new ByteArrayInputStream(out.toByteArray());
                bm = BitmapFactory.decodeStream(is);
                return bm;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
