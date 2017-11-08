package com.example.lurenman.greendaodemo.dao;

import android.content.Context;

import com.example.lurenman.greendaodemo.MyApplication;

import org.greenrobot.greendao.database.Database;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 */

public class DbManager {
    private DaoSession daoSession;

    private static final class Holder {
        private static final DbManager INSTANCE = new DbManager();
    }

    public static DbManager getInstance() {
        return Holder.INSTANCE;
    }

    public void initDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApplication.AppInstance, "users.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
