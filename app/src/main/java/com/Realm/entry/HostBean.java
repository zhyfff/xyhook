package com.Realm.entry;

import io.realm.RealmObject;

/**
 * 数据接收端链接信息
 */

public class HostBean extends RealmObject {
    private String hostname;
    private String servletname;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getServletname() {
        return servletname;
    }

    public void setServletname(String servletname) {
        this.servletname = servletname;
    }
}
