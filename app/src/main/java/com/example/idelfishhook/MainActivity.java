package com.example.idelfishhook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.Realm.entry.Location;
import com.example.idelfishhook.Activity.AddGoodsClassActivity;
import com.example.idelfishhook.Activity.BaseActivity;
import com.example.idelfishhook.Activity.InsertActivity;
import com.example.idelfishhook.Activity.QuerryHostActivity;
import com.example.idelfishhook.Activity.QueryActivity;
import com.example.idelfishhook.Activity.TaskActivity;
import com.example.idelfishhook.adapter.BaseAdapter;
import com.example.idelfishhook.adapter.MainAdapter;
import com.util.DefaultItemTouchHelpCallback;
import com.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity{
	@BindView(R.id.toolBar)
	Toolbar mToolbar;
	@BindView(R.id.recyclerView)
	RecyclerView mRecyclerView;
	private List<Location> mlocs = new ArrayList<>();
	private MainAdapter mAdapter;
	private RealmHelper realmHelper;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mToolbar.setTitle("闲鱼采集器beta");
		setSupportActionBar(mToolbar);
		initRecyclerView();
		addListener();

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_main;
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
//	@OnClick({R.id.btn_add,  R.id.btn_query})
//	void onClick(View view) {
//		switch (view.getId()) {
//			case R.id.btn_add:
//				startActivity(new Intent(MainActivity.this, InsertActivity.class));
//				break;
//			case R.id.btn_query:
//				startActivity(new Intent(MainActivity.this,QueryActivity.class));
//				break;
//
//			default:
//				break;
//		}
//	}


	private void initRecyclerView() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(layoutManager);
		realmHelper =  new RealmHelper(this);
		mlocs = realmHelper.queryAllLoc();
		mAdapter = new MainAdapter(this, mlocs, R.layout.item_loc);
		mRecyclerView.setAdapter(mAdapter);


		setSwipeDelete();

		Snackbar.make(mRecyclerView,"滑动删除item、点击Item进入任务详情",Snackbar.LENGTH_LONG).show();
	}

	private void setSwipeDelete() {
		DefaultItemTouchHelpCallback mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
			@Override
			public void onSwiped(int adapterPosition) {
				//删除数据库数据
				realmHelper.deleteLoc(mlocs.get(adapterPosition).getId());
				realmHelper.delecteTask(Integer.parseInt(mlocs.get(adapterPosition).getId()));
				//滑动删除
				mlocs.remove(adapterPosition);
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
				Intent intent=new Intent(MainActivity.this,TaskActivity.class);
				intent.putExtra("id",mlocs.get(position).getId());
				startActivityForResult(intent,100);
			}
		});

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		mlocs.clear();
		List<Location> locs=realmHelper.queryAllLoc();
		mlocs.addAll(locs);
		mAdapter.notifyDataSetChanged();
	}

	//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//
//		if (resultCode==RESULT_OK&&requestCode==100){
//			mlocs.clear();
//			List<Location> locs=realmHelper.queryAllLoc();
//			mlocs.addAll(locs);
//			mAdapter.notifyDataSetChanged();
//
//		}
//	}




}
