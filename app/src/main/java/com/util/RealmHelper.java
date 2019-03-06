package com.util;

import android.content.Context;

import com.Realm.entry.GoodsClassBean;
import com.Realm.entry.HostBean;
import com.Realm.entry.Location;
import com.Realm.entry.TaskBean;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {
    public static final String DB_NAME = "myRealm.realm";
    private Realm mRealm;

    public RealmHelper(Context context){
        mRealm = Realm.getDefaultInstance();
    }

    /**
     * add 增
     * @param location
     */
    public void addLoc(final Location location){
        mRealm.beginTransaction();
        mRealm.copyToRealm(location);
        mRealm.commitTransaction();
    }

    /**
     * delete 删
     * @param id
     */
    public void  deleteLoc(String id){
        Location location = mRealm.where(Location.class).equalTo("id",id).findFirst();
        mRealm.beginTransaction();
        location.deleteFromRealm();
        mRealm.commitTransaction();
    }


    /**
     * update 改
     * @param id
     * @param newIdName
     */
    public void updateLoc(String id,String newIdName,String province,String city,String area,String endPage){
        Location location = mRealm.where(Location.class).equalTo("id",id).findFirst();
        mRealm.beginTransaction();
        location.setIdName(newIdName);
        location.setProvince(province);
        location.setCity(city);
        location.setArea(area);
        location.setEndPage(endPage);
        mRealm.commitTransaction();
    }

    /**
     * query 查所有
     * @return
     */
    public List<Location> queryAllLoc(){
        RealmResults<Location> locations = mRealm.where(Location.class).findAll();
        //locations=locations.sort("id");//增序排列
        locations=locations.sort("id", Sort.DESCENDING);//降序排列
        return mRealm.copyFromRealm(locations);

    }


    /**
     * query 根据id查
     * @param id
     * @return
     */
    public Location queryLocById(String id){
        Location location = mRealm.where(Location.class).equalTo("id",id).findFirst();
        return location;
    }

    public  Location queryLocByIdName(String idName){
        Location location = mRealm.where(Location.class).equalTo("idName",idName).findFirst();
        return location;
    }


    public boolean isLocExist(String id){
        Location location = mRealm.where(Location.class).equalTo("id",id).findFirst();
        if (location == null) {
            return false;
        }else {
            return true;
        }
    }

    public Realm getmRealm(){
        return mRealm;
    }

    public void close(){
        if (mRealm!=null){
            mRealm.close();
        }
    }


    /**
     * 增加任务表任务
     * @param taskBean
     */
    public void  addTask(final TaskBean taskBean){
        mRealm.beginTransaction();
        mRealm.copyToRealm(taskBean);
        mRealm.commitTransaction();
    }

    /**
     * 通过seq查任务表
     * @param seq
     * @return
     */
    public TaskBean  querryTaskbySeq(int seq){
        TaskBean taskBean = mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        return taskBean;
    }


    /**
     * 修改任务起始页
     * @param seq
     * @param startPage
     */
    public void updateTaskPage(int seq,int startPage){
        TaskBean taskBean = mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        mRealm.beginTransaction();
        taskBean.setStartPage(startPage);
        mRealm.commitTransaction();
    }

    /**
     * 修改采集总页数
     * @param seq
     * @param endPage
     */
    public void updateTaskEndPage(int seq,int endPage){
        TaskBean taskBean = mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        mRealm.beginTransaction();
        taskBean.setEndPage(endPage);
        mRealm.commitTransaction();
    }

    /**
     * 修改任务状态
     * @param seq
     * @param flag
     */
    public void updateTaskFlag(int seq,String flag){
        TaskBean taskBean = mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        mRealm.beginTransaction();
        taskBean.setFlag(flag);
        mRealm.commitTransaction();
    }


    /**
     * 通过seq删除任务表
     * @param seq
     */
    public void delecteTask(int seq){
        TaskBean taskBean =mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        if (taskBean==null){
            return;
        }
        mRealm.beginTransaction();
        taskBean.deleteFromRealm();
        mRealm.commitTransaction();
    }

    public boolean isExistTask(int seq){
        TaskBean taskBean = mRealm.where(TaskBean.class).equalTo("seq",seq).findFirst();
        if (taskBean == null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 添加物品种类
     * @param goodsClassBean
     */
    public  void addGoodsClass(final GoodsClassBean goodsClassBean){
        mRealm.beginTransaction();
        mRealm.copyToRealm(goodsClassBean);
        mRealm.commitTransaction();
    }

    /**
     * 修改物品种类
     * @param gid
     * @param gName
     * @param num
     */
    public void updateGoodsClass(int gid,String gName,int num){
        GoodsClassBean goodsClassBean = mRealm.where(GoodsClassBean.class).equalTo("gid",gid).findFirst();
        mRealm.beginTransaction();
        goodsClassBean.setgName(gName);
        goodsClassBean.setNum(num);
        mRealm.commitTransaction();
    }

    /**
     * 删除物品种类
     * @param gid
     */
    public void deleteGoodsClass(int gid){
        GoodsClassBean goodsClassBean = mRealm.where(GoodsClassBean.class).equalTo("gid",gid).findFirst();
        mRealm.beginTransaction();
        goodsClassBean.deleteFromRealm();
        mRealm.commitTransaction();
    }

    /**
     * 查所有物品种类
     * @return
     */
    public List<GoodsClassBean> querryAllGoodsClass(){
        RealmResults<GoodsClassBean> goodslist = mRealm.where(GoodsClassBean.class).findAll();
        goodslist = goodslist.sort("gid",Sort.DESCENDING);
        return goodslist;
    }

    public boolean isEixstGoodsClass(int num){
        GoodsClassBean goodsClassBean = mRealm.where(GoodsClassBean.class).equalTo("num",num).findFirst();
        if (goodsClassBean==null){
            return false;
        }else{
            return true;
        }
    }


    /**
     * 添加数据接收端链接
     * @param hostBean
     */
    public void addHost(final HostBean hostBean){
        mRealm.beginTransaction();
        mRealm.copyToRealm(hostBean);
        mRealm.commitTransaction();

    }

    /**
     * 修改数据接收端链接
     *
     */
    public void updateHost(final HostBean hostBean){
        mRealm.beginTransaction();
        mRealm.copyToRealm(hostBean);
        mRealm.commitTransaction();

    }

    /**
     * 查询的链接
     * @return
     */
    public HostBean querryHost(){
        HostBean hostBean = mRealm.where(HostBean.class).findFirst();
        return  hostBean;
    }








}
