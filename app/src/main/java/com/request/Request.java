package com.request;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    static String hostname = "http://10.1.11.105:8080";

    public static String getName() {
        String Jstr = "";
        HttpURLConnection connection = null;
        try {
            StringBuilder urlsb = new StringBuilder();
            urlsb.append(hostname + "/idelfish/getR");
            URL url = new URL(urlsb.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
//            connection.setRequestProperty("", "");
            connection.setDoInput(true);
//			判断服务器端的响应码是不是200
            InputStream in = null;
            if (connection.getResponseCode() == 200) {
                try {
                    in = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] arr = new byte[1024];
                    int len = 0;
                    while ((len = in.read(arr)) != -1) {
                        bos.write(arr, 0, len);
                    }
                    byte[] b = bos.toByteArray();
                    String ss = new String(b, "utf-8");
//                Log.d("bx",ss);
                    Jstr = ss;
                } catch (Exception e) {
                    Log.i("idelfishHook", "err:" + e);
                }
            }
            //关闭流
            in.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("idelfishHook", "Exception:" + e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return Jstr;
    }

}
