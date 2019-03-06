package com.Realm.entry;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 任务信息
 */
public class Location extends RealmObject {
    @PrimaryKey
    private String id;
    private String idName;
    private String province;
    private String city;
    private String area;
    private String endPage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEndPage() {
        return endPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }
}
