package com.Application;

import android.app.Application;

import com.util.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(RealmHelper.DB_NAME).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

    }
}
