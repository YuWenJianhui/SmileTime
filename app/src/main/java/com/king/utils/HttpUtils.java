package com.king.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DJ on 2016/10/21.
 */

public class HttpUtils {

    /**
     * 从服务器下载XML格式的文件
     */

    public static String getJsonData(String strUrl){

        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10*1000);
            conn.setReadTimeout(10*1000);
            if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){

                InputStream is = conn.getInputStream();
                ByteArrayOutputStream out=new ByteArrayOutputStream();
                int len=-1;
                byte[] b=new byte[1024];
                while ((len=is.read(b)) != -1){
                    out.write(b,0,len);
                }
                return out.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



}
