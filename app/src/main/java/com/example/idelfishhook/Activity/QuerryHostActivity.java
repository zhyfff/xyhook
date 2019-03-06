package com.example.idelfishhook.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.Realm.entry.HostBean;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

public class QuerryHostActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.ta_host)
    TextView ta_host;
    @BindView(R.id.ta_servlet)
    TextView ta_servlet;
    RealmHelper realmHelper = null;
    private String TAG = "QuerryHostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "数据接收端链接设置");
        initDate();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initDate();
    }


    public void initDate(){
        realmHelper = new RealmHelper(this);
        HostBean hostBean = realmHelper.querryHost();
        if (hostBean!=null){
            String hostname = hostBean.getHostname().trim();
            String servletname = hostBean.getServletname().trim();
            ta_host.setText(hostname);
            ta_servlet.setText(servletname);

            try {
                saveParam(hostname+"/"+servletname);
            } catch (IOException e) {
                Log.e(TAG,e.toString());
            }


        }else{
            ta_host.setText("");
            ta_servlet.setText("");
        }

    }
    @OnClick(R.id.but_up)
    void Onclick(){
        Intent intent = new Intent(this,UpdateHostActivity.class);
        startActivity(intent);

    }
    /**
     * 保存传入hook的参数到txt文件
     * @param param
     * @throws IOException
     */
    public void saveParam(String param) throws IOException {
        FileOutputStream outStream = openFileOutput("urlfile.txt", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
        outStream.write(param.getBytes());
        outStream.close();



    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_querry_host;
    }

    @Override
    public Intent setMenuIntentAdd() {
        return new Intent(this, InsertActivity.class);
    }

    @Override
    public Intent setMenuIntentsearch() {
        return new Intent(this,QueryActivity.class);
    }

    @Override
    public Intent setMenuIntentAddGoodsClass() {
        return new Intent(this,AddGoodsClassActivity.class);
    }

    @Override
    public Intent setMenuIntentQuerryHost() {
        return new Intent(this,QuerryHostActivity.class);
    }




}
