package com.example.idelfishhook.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.Realm.entry.Location;
import com.example.idelfishhook.R;
import com.util.RealmHelper;

import java.util.List;

public class LocAdapter extends BaseAdapter<Location>{

    private RealmHelper mRealmHleper;

    public LocAdapter(Context mContext, List<Location> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
        mRealmHleper = new RealmHelper(mContext);
    }

    @Override
    protected void convert(Context mContext, BaseViewHolder holder,final Location location) {
        holder.setText(R.id.tv_name, location.getIdName()).setText(R.id.tv_id, location.getId());
        final ImageView iv = holder.getView(R.id.iv_like);
        if (mRealmHleper.isLocExist(location.getId())) {
            iv.setSelected(true);
        } else {
            iv.setSelected(false);
        }

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv.isSelected()) {
                    iv.setSelected(false);
                    mRealmHleper.deleteLoc(location.getId());

                } else {
                    iv.setSelected(true);
                    mRealmHleper.addLoc(location);
                }
            }
        });

    }
}
