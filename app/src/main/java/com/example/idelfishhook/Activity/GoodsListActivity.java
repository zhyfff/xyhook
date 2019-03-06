package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.Realm.entry.GoodsClassBean;
import com.example.idelfishhook.R;
import com.example.idelfishhook.adapter.BaseAdapter;
import com.example.idelfishhook.adapter.GoodsClassAdapter;
import com.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *物品分类
 */
public class GoodsListActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private RealmHelper mRealmHelper;
    private List<GoodsClassBean> gcList =new ArrayList<>();
    private GoodsClassAdapter gcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
        setToolbar(toolbar,"物品种类");
        clickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_list;
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


    public void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRealmHelper = new RealmHelper(this);
        gcList = mRealmHelper.querryAllGoodsClass();
        gcAdapter = new GoodsClassAdapter(GoodsListActivity.this,gcList, R.layout.item_goods);
        mRecyclerView.setAdapter(gcAdapter);

        Snackbar.make(mRecyclerView,"点击Item进入修改",Snackbar.LENGTH_LONG).show();
    }


    private void clickListener(){
        gcAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(GoodsListActivity.this,UpdateGoodsClassActivity.class);
                intent.putExtra("gid",String.valueOf(gcList.get(position).getGid()));
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK&&requestCode==100){
            gcList.clear();
            List<GoodsClassBean> gcL=mRealmHelper.querryAllGoodsClass();
            gcList.addAll(gcL);
            gcAdapter.notifyDataSetChanged();

        }
    }

}
