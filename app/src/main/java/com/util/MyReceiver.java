package com.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static String content="No";
    String TAG = "MyReceiver";


    public static String getContent(){
        return content;
    }
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        content = intent.getStringExtra("data");
        CharSequence string = "收到的信息："+content;
        Log.i(TAG,content);
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
