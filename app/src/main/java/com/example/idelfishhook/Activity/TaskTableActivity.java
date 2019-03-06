package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Realm.entry.TaskBean;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 任务表详情
 */
public class TaskTableActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @BindView(R.id.ta_seq)
    TextView ta_seq;
    @BindView(R.id.ta_province)
    TextView ta_province;
    @BindView(R.id.ta_city)
    TextView ta_city;
    @BindView(R.id.ta_area)
    TextView ta_area;
    @BindView(R.id.ta_startPage)
    TextView ta_startPage;
    @BindView(R.id.ta_endPage)
    TextView ta_endPage;
    @BindView(R.id.ta_flag)
    TextView ta_flag;


    private RealmHelper realmHelper;
    private TaskBean taskBean;
    private  String seq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar,"任务表详情");
        initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_table;
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
        realmHelper = new RealmHelper(this);
        seq = getIntent().getStringExtra("seq");
        taskBean = realmHelper.querryTaskbySeq(Integer.parseInt(seq));
        if (taskBean==null){

            Toast.makeText(this, "还未创建任务表", Toast.LENGTH_LONG).show();
            finish();
            Intent intent = new Intent(this,ErrorActivity.class);
            startActivity(intent);

        }else{
            ta_seq.setText(String.valueOf(taskBean.getSeq()));
            ta_province.setText(taskBean.getProvince());
            ta_city.setText(taskBean.getCity());
            ta_area.setText(taskBean.getArea());
            ta_startPage.setText(String.valueOf(taskBean.getStartPage()));
            ta_endPage.setText(String.valueOf(taskBean.getEndPage()));
            ta_flag.setText(taskBean.getFlag());
        }

    }

    @OnClick(R.id.change_task)
    void OnClick(View view){
        Intent intent = new Intent(this,UpdateTaskTableActivity.class);
        intent.putExtra("seq",seq);
        finish();
        startActivity(intent);
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode==RESULT_OK&&requestCode==100){
            initData();

		}
	}


}
