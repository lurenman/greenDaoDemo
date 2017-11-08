package com.example.lurenman.greendaodemo;

import android.app.Application;
import android.content.Context;

import com.example.lurenman.greendaodemo.dao.DbManager;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 */

public class MyApplication extends Application {
   public static Context AppInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        AppInstance=this;
        //初始化dao
        DbManager.getInstance().initDao();

    }
}
