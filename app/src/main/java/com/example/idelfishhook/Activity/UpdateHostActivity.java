package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.Realm.entry.HostBean;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateHostActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar mtoobar;
    @BindView(R.id.et_host)
    EditText et_host;
    @BindView(R.id.et_servlet)
    EditText et_servlet;
    private RealmHelper realmHelper =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mtoobar,"更新链接");
    }


    public void initData(){
        realmHelper = new RealmHelper(this);
        String hostname = et_host.getText().toString().trim();
        String servletname = et_servlet.getText().toString().trim();
        HostBean hostBean = new HostBean();
        hostBean.setHostname(hostname);
        hostBean.setServletname(servletname);
        realmHelper.updateHost(hostBean);
    }

    @OnClick(R.id.but_s)
    void Onclick(){
        initData();
        Toast.makeText(this, "成功！！", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_host;
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
