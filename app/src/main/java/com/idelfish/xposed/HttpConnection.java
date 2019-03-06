package com.idelfish.xposed;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XposedBridge;


public class HttpConnection {
    private static String insertmatchUrl="http://10.1.11.101/catchAppSession/Public/catchappsession/?service=Insert.InsertMatch";
    public static String insertmatch(String session)  {

        HttpPost request= new HttpPost(insertmatchUrl);
        HttpClient client = new DefaultHttpClient();

        NameValuePair session1Data=new BasicNameValuePair("MatchSession",session);

        List<NameValuePair> pairList = new ArrayList<NameValuePair>();
        pairList.add(session1Data);
        HttpResponse httpResponse = null;
        String response="";
        try {
            HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList,"utf-8");
            request.setEntity(requestHttpEntity);
            httpResponse = client.execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                response= EntityUtils.toString(httpResponse.getEntity(),"utf-8");

            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            XposedBridge.log("HTTP  "+e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            XposedBridge.log("HTTP  "+e.toString());
        }
        XposedBridge.log("HTTP  "+response);
    return response;
    }


}
