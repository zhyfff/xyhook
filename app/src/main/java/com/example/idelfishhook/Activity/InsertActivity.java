package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.Realm.entry.Location;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class InsertActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.et_id)
    EditText et_id;
    @BindView(R.id.et_idName)
    EditText et_idName;
    @BindView(R.id.et_province)
    EditText et_province;
    @BindView(R.id.et_city)
    EditText et_city;
    @BindView(R.id.et_area)
    EditText et_area;
    @BindView(R.id.et_endPage)
    EditText et_endPage;
    @BindView(R.id.scrollview)
    ScrollView scrollView;
    final private Location location = new Location();
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "添加任务");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_insert;
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

    private void initData(){
        location.setId(et_id.getText().toString().trim());
        location.setIdName(et_idName.getText().toString().trim());
        location.setProvince(et_province.getText().toString().trim());
        location.setCity(et_city.getText().toString().trim());
        location.setArea(et_area.getText().toString().trim());
        location.setEndPage(et_endPage.getText().toString().trim());
        mRealmHelper=new RealmHelper(this);

    }

    @OnClick(R.id.btn_insert)
    void onClick(View v) {

        initData();
        if (TextUtils.isEmpty(location.getId())||TextUtils.isEmpty(location.getIdName())
                ||TextUtils.isEmpty(location.getProvince())||TextUtils.isEmpty(location.getCity())
                ||TextUtils.isEmpty(location.getEndPage())){
            Toast.makeText(InsertActivity.this,"请输入任务信息",Toast.LENGTH_SHORT).show();
            return;
        }
        if (mRealmHelper.isLocExist(location.getId())){
            Toast.makeText(InsertActivity.this,"id已存在，请换一个",Toast.LENGTH_SHORT).show();
            return;
        }
        mRealmHelper.addLoc(location);

        setResult(RESULT_OK);
        finish();
        startActivity(new Intent(InsertActivity.this, LocationListActivity.class));
    }




}
