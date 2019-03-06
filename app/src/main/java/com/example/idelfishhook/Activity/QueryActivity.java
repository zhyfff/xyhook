package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.idelfishhook.R;

import butterknife.BindView;
import butterknife.OnClick;
/**
 *  查、改
 */
public class QueryActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar,"改、查");
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_query;
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

    @OnClick({R.id.btn_query, R.id.btn_condition_query,})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query:
                startActivity(new Intent(QueryActivity.this,AllLocActivity.class));
                break;
            case R.id.btn_condition_query:
                startActivity(new Intent(QueryActivity.this,ConditionQueryActivity.class));
                break;
//            case R.id.btn_other_query:
//                startActivity(new Intent(QueryActivity.this,OtherQueryActivity.class));
//                break;
            default:
                break;

        }

    }
}
