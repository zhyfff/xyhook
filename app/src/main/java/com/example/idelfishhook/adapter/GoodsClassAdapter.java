package com.example.idelfishhook.adapter;

import android.content.Context;

import com.Realm.entry.GoodsClassBean;
import com.example.idelfishhook.R;

import java.util.List;

public class GoodsClassAdapter extends BaseAdapter<GoodsClassBean> {
    public GoodsClassAdapter(Context mContext, List<GoodsClassBean> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
    }

    @Override
    protected void convert(Context mContext, BaseViewHolder holder, GoodsClassBean goodsClassBean) {
        holder.setText(R.id.item_gid, String.valueOf(goodsClassBean.getGid())).setText(R.id.item_gName, goodsClassBean.getgName())
                .setText(R.id.item_num,String.valueOf(goodsClassBean.getNum()));

    }
}
