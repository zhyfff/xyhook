package com.idelfish.xposed;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ResponseMessage extends AppCompatActivity{
//    private  static String hostname = "http://10.1.17.112:21568";
//    private  static String servletname = "idelfishServlet/servlet/MyServlet";
    private static String hostname;
    private static String servletname;
    private static String TAG = "ResponseMessage";
    private static String urlfile = "/data/data/com.example.idelfishhook/files/urlfile.txt";

    public static void sendPost(String resp) {
        testRoot();
        HttpURLConnection connection = null;
        try {

            String htmlurl = inPutStreamtool(urlfile);
            URL url = new URL(htmlurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("charset", "UTF-8");
            connection.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //向服务器传送数据
            out.writeBytes(URLEncoder.encode(resp, "utf-8"));
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder s = new StringBuilder();
                String line;
                //读取服务器返回的数据
                while ((line = reader.readLine()) != null) {
                    s.append(line);
                }
//                Log.i("taobao", "读取服务器返回的数据  :"+s.toString());
                Log.i(TAG, "闲鱼信息发送成功！！");
                reader.close();
            }
            out.close();


        } catch (MalformedURLException e) {
//            e.printStackTrace();
            Log.e(TAG,  e.toString());
//            showOnUIThreadx(this,e.toString(),Toast.LENGTH_SHORT);
        } catch (IOException e) {
//            e.printStackTrace();
            Log.e(TAG, e.toString());
//            showOnUIThreadx(this,e.toString(),Toast.LENGTH_SHORT);
        } catch (Exception e) {
//            e.printStackTrace();
            Log.e(TAG, e.toString());
//            showOnUIThreadx(this,e.toString(),Toast.LENGTH_SHORT);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }


    }





    public static String inPutStreamtool(String urlfile) {
        String content = null;
        FileInputStream inStream = null;
        try {
            File file = new File(urlfile);
            inStream = new FileInputStream(urlfile);
            //创建一个字节数组，定义len记录长度
            int len = 0;
            byte[] buf = new byte[16*1024];
            while ((len = inStream.read(buf)) >0) {
                content = new String(buf, 0, len);
//                System.out.println(new String(buf,0,len));
            }

        } catch (IOException e) {
            Log.e(TAG,e.toString());
        }finally {
            if (null != inStream)
            {
                try
                {
                    inStream.close();
                }
                catch (IOException e)
                {
                }
            }

        }
        return content;
    }

    protected static void testRoot() {
        try {
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
        } catch (IOException e) {
//            Toast.makeText(this, R.string.no_root, Toast.LENGTH_LONG).show();
            e.printStackTrace();
            Log.e("app", e.getMessage());

        }
    }

}

