package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Realm.entry.Location;
import com.example.idelfishhook.R;
import com.example.idelfishhook.adapter.LikeLocAdapter;
import com.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 条件查询
 */
public class ConditionQueryActivity extends BaseActivity{
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.et_idName)
    EditText etIdName;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    private RealmHelper mRealmHelper;
    private List<Location> mLocs = new ArrayList<>();
    private LikeLocAdapter mAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_condition_query;
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
        setToolbar(mToolbar, "条件查询");
        initData();
    }

    @OnClick({R.id.btn_query_id, R.id.btn_query_idname})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query_id:
                queryById();
                break;
            case R.id.btn_query_idname:
                queryByIdName();
                break;
            default:
                break;
        }

    }

    private void initData() {
        mRealmHelper = new RealmHelper(this);
        mAdapter = new LikeLocAdapter(this, mLocs, R.layout.item_loc);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void queryById() {
        String id = etId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(ConditionQueryActivity.this, "请输入Id", Toast.LENGTH_SHORT).show();
            return;
        }

        mLocs.clear();
        Location location = mRealmHelper.queryLocById(id);
        if (location != null) {
            mLocs.add(location);

        } else {
            Toast.makeText(ConditionQueryActivity.this, "查询结果为空", Toast.LENGTH_SHORT).show();
        }
        mAdapter.notifyDataSetChanged();

    }


    private void queryByIdName(){
        String idName= etIdName.getText().toString().trim();
        if (TextUtils.isEmpty(idName)){
            Toast.makeText(ConditionQueryActivity.this,"请输入Id",Toast.LENGTH_SHORT).show();
            return;
        }
        mLocs.clear();
        Location location = mRealmHelper.queryLocByIdName(idName);
        if (location!=null){
            mLocs.add(location);
        }else{
            Toast.makeText(ConditionQueryActivity.this, "查询结果为空", Toast.LENGTH_SHORT).show();
        }
        mAdapter.notifyDataSetChanged();
    }

}
