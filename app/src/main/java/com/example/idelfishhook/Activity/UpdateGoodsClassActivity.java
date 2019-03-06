package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 更新物品类别信息
 */
public class UpdateGoodsClassActivity extends BaseActivity {

    @BindView(R.id.gid)
    TextView gid;
    @BindView(R.id.gName)
    EditText gName;
    @BindView(R.id.num)
    EditText num;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    private int id;
    RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar,"更新物品类别信息");
        id = Integer.parseInt(getIntent().getStringExtra("gid"));
        gid.setText(String.valueOf(id));
        mRealmHelper = new RealmHelper(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_goods_class;
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

    @OnClick(R.id.btn_update)
    void OnClick(View view){
        String gN = gName.getText().toString();
        int n = Integer.parseInt(num.getText().toString());

        if (TextUtils.isEmpty(gN)||TextUtils.isEmpty(String.valueOf(n))){
            Toast.makeText(this,"请输入修改信息",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mRealmHelper.isEixstGoodsClass(n)) {
            mRealmHelper.updateGoodsClass(id, gN, n);
            Toast.makeText(this, "修改完毕", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
            Intent intent = new Intent(this,GoodsListActivity.class);
            startActivityForResult(intent,100);
        }else{
            Toast.makeText(this,"该分类id已存在",Toast.LENGTH_SHORT).show();
        }
    }
}
