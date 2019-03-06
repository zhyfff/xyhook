package com.Realm.entry;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 物品种类
 */
public class GoodsClassBean extends RealmObject {
    @PrimaryKey
    private int gid;
    private String gName;
    private int num;


    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
