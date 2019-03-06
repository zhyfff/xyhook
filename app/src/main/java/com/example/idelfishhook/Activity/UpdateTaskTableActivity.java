package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Realm.entry.TaskBean;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改任务表状态
 */
public class UpdateTaskTableActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.ta_seq)
    TextView ta_seq;
    @BindView(R.id.ta_startPage)
    EditText ta_startPage;
    @BindView(R.id.ta_endPage)
    EditText ta_endPage;
    @BindView(R.id.ta_flag)
    TextView ta_flag;

    private RealmHelper realmHelper;
    private TaskBean taskBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar,"修改任务表状态");
        initDate();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_task_table;
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

    private void initDate(){
        ta_seq.setText(getIntent().getStringExtra("seq"));
    }

    @OnClick(R.id.btn_update)
    void OnClick(View view){
        realmHelper = new RealmHelper(this);
        realmHelper.updateTaskPage(Integer.parseInt(ta_seq.getText().toString()),
                Integer.parseInt(ta_startPage.getText().toString()));
        realmHelper.updateTaskFlag(Integer.parseInt(ta_seq.getText().toString())
                ,ta_flag.getText().toString());
        realmHelper.updateTaskEndPage(Integer.parseInt(ta_seq.getText().toString()),
                Integer.parseInt(ta_endPage.getText().toString()));
        finish();
        Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();

    }
}
