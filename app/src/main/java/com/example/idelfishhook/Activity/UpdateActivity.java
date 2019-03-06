package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改任务
 */
public class UpdateActivity extends BaseActivity{

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_province)
    EditText etProvince;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.et_area)
    EditText etArea;
    @BindView(R.id.et_endPage)
    EditText etEndpage;

    private RealmHelper mRealmHelper;
    private String mId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "修改任务");

        initData();
    }

    private void initData() {
        mRealmHelper=new RealmHelper(this);
        mId=getIntent().getStringExtra("id");
    }

    @OnClick(R.id.btn_update)
    void onClick(View v) {
        String name=etName.getText().toString().trim();
        String province = etProvince.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String area = etArea.getText().toString().trim();
        String endPage = etEndpage.getText().toString().trim();

        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(province)||TextUtils.isEmpty(city)||TextUtils.isEmpty(area)||TextUtils.isEmpty(endPage)){
            Toast.makeText(UpdateActivity.this,"请输入修改信息",Toast.LENGTH_SHORT).show();
            return;
        }

        mRealmHelper.updateLoc(mId,name,province,city,area,endPage);

        setResult(RESULT_OK);
        finish();
    }
}
