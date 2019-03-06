package com.example.idelfishhook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Realm.entry.GoodsClassBean;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加物品分类信息
 */
public class AddGoodsClassActivity extends BaseActivity {

        @BindView(R.id.toolBar)
        Toolbar toolbar;
        @BindView(R.id.et_gid)
        EditText et_gid;
        @BindView(R.id.et_gName)
        EditText et_gName;
        @BindView(R.id.et_num)
        EditText et_num;
        final private GoodsClassBean goodsClassBean=new GoodsClassBean();;
        private RealmHelper mRealmHelper;
        private String etgid;
        private String etgName;
        private String etnum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setToolbar(toolbar,"添加物品分类");
        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_add_goods_class;
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

        public  void initDate(){
            etgid=et_gid.getText().toString();
            etgName=et_gName.getText().toString();
            etnum=et_num.getText().toString();
            if (TextUtils.isEmpty(etgid)||TextUtils.isEmpty(etgName)||TextUtils.isEmpty(etnum)){
                Toast.makeText(this,"请输入信息",Toast.LENGTH_SHORT).show();
                return;
            }
            goodsClassBean.setGid(Integer.parseInt(etgid.trim()));
            goodsClassBean.setgName(etgName.trim());
            goodsClassBean.setNum(Integer.parseInt(etnum.trim()));
            mRealmHelper = new RealmHelper(this);
            if (mRealmHelper.isEixstGoodsClass(Integer.parseInt(etnum.trim())))
            {
                Toast.makeText(this,"已存在",Toast.LENGTH_SHORT).show();
                return;
            }else{
                mRealmHelper.addGoodsClass(goodsClassBean);
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
            }

        }

    @OnClick({R.id.but_addgc,R.id.but_look})
        public void OnClick(View v){

            switch (v.getId()){
                case R.id.but_addgc:
                    initDate();
                    break;
                case R.id.but_look:

                    Intent intent = new Intent(this,GoodsListActivity.class);
                    startActivity(intent);
                    break;
                    default:
                        break;
            }


        }

}
