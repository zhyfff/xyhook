package com.example.idelfishhook.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.idelfishhook.R;

import java.lang.reflect.Method;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);
    }

    public abstract int getLayoutId();

    @SuppressLint("RestrictedApi")
    protected void setToolbar(Toolbar toolbar, String title){
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                startActivity(setMenuIntentAdd());
                break;
            case  R.id.search:
                startActivity(setMenuIntentsearch());
                break;
            case  R.id.addGoods:
                startActivity(setMenuIntentAddGoodsClass());
                break;
            case  R.id.querryHost:
                startActivity(setMenuIntentQuerryHost());
                break;
            default:
                 break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {

        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {

                }
            }
        }

        return super.onPrepareOptionsPanel(view, menu);
    }

    public abstract Intent setMenuIntentAdd();
    public abstract Intent setMenuIntentsearch();
    public abstract Intent setMenuIntentAddGoodsClass();
    public abstract Intent setMenuIntentQuerryHost();

}
