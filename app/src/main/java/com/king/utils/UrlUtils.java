package com.king.utils;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/24.
 */

public class UrlUtils {
    public static String aboutur(String urls) {
        URL url = null;
        InputStream is = null;
        BufferedReader bufferedReader = null;
        StringBuffer mSb = new StringBuffer();
        HttpURLConnection conn = null;
        try {
            url = new URL(urls);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10 * 1000);
            conn.setReadTimeout(10*1000);
            ByteArrayOutputStream out = null;
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                out = new ByteArrayOutputStream();
                int len = -1;
                byte[] b = new byte[1024 * 4];
                while ((len = is.read(b)) != -1) {
                    out.write(b, 0, len);
                }

                bufferedReader = new BufferedReader(new InputStreamReader(is,"gb2312"));
                String mString = null;

                while ((mString = bufferedReader.readLine()) != null) {
                    //把单个的字符串放到msb中
                    mSb.append(mString);
                }
                System.out.println(mSb.toString());
                return mSb.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
}
