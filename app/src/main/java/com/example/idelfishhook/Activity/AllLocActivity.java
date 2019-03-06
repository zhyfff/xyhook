package com.example.idelfishhook.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.Realm.entry.Location;
import com.example.idelfishhook.R;
import com.example.idelfishhook.adapter.BaseAdapter;
import com.example.idelfishhook.adapter.LikeLocAdapter;
import com.util.DefaultItemTouchHelpCallback;
import com.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  查询所有
 */
public class AllLocActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<Location> mLocs = new ArrayList<>();
    private LikeLocAdapter mAdapter;
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar(mToolbar, "查询所有");

        initData();

        addListener();
    }

    private void initData(){
        mRealmHelper = new RealmHelper(this);
        mLocs = mRealmHelper.queryAllLoc();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new LikeLocAdapter(this,mLocs,R.layout.item_loc);
        mRecyclerView.setAdapter(mAdapter);

        setSwipeDelete();

        Snackbar.make(mRecyclerView,"滑动删除item、点击Item进入修改界面",Snackbar.LENGTH_LONG).show();

    }

    private void setSwipeDelete() {
        DefaultItemTouchHelpCallback mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
                //删除数据库数据
                mRealmHelper.deleteLoc(mLocs.get(adapterPosition).getId());
                mRealmHelper.delecteTask(Integer.parseInt(mLocs.get(adapterPosition).getId()));
                //滑动删除
                mLocs.remove(adapterPosition);
                mAdapter.notifyItemRemoved(adapterPosition);

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {

                return false;
            }
        });
        mCallback.setDragEnable(false);
        mCallback.setSwipeEnable(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }


    private void addListener() {
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(AllLocActivity.this,UpdateActivity.class);
                intent.putExtra("id",mLocs.get(position).getId());
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_loc;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK&&requestCode==100){
            mLocs.clear();
            List<Location> dogs=mRealmHelper.queryAllLoc();
            mLocs.addAll(dogs);
            mAdapter.notifyDataSetChanged();

        }
    }
}
