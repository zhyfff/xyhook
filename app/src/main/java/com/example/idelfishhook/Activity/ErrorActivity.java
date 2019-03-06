package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.idelfishhook.R;

import butterknife.BindView;

public class ErrorActivity extends BaseActivity {

    @BindView(R.id.errorImage)
    ImageView errorImage;
    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar,"错误");
        errorImage.setImageResource(R.drawable.error);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_error;
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
}
