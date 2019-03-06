package com.example.idelfishhook.adapter;

import android.content.Context;
import android.view.View;

import com.Realm.entry.Location;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import java.util.List;

/**
 * 首页展示
 */
public class MainAdapter  extends BaseAdapter<Location> {
    private RealmHelper mRealmHleper;
    @Override
    protected void convert(Context mContext, BaseViewHolder holder, Location location) {
        holder.setText(R.id.tv_name, location.getIdName()).setText(R.id.tv_id, location.getId())
                .setVisible(R.id.iv_like, View.INVISIBLE);

    }

    public MainAdapter(Context mContext, List<Location> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
        mRealmHleper = new RealmHelper(mContext);
    }
}
