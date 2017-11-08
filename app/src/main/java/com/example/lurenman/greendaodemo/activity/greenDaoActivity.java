package com.example.lurenman.greendaodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ListView;

import com.example.lurenman.greendaodemo.R;
import com.example.lurenman.greendaodemo.adapter.ListViewAdapter;
import com.example.lurenman.greendaodemo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 */

public class greenDaoActivity extends Activity {
    private Button bt_Insert;
    private Button bt_Delete;
    private Button bt_Query;
    private Button bt_Update;
    private ListView lv_listView;
    private ListViewAdapter mListViewAdapter;
    List<User> mDataArray = new ArrayList<User>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
        initViews();
        initdatas();
        initEvents();
    }

    private void initdatas() {
        //插入数据
        User user = new User();
        user.setName("路飞");
        user.setImage();
        user.setOccupation("五亿");

    }

    private void initViews() {
        bt_Insert = (Button) findViewById(R.id.bt_Insert);
        bt_Delete = (Button) findViewById(R.id.bt_Delete);
        bt_Query = (Button) findViewById(R.id.bt_Query);
        bt_Update = (Button) findViewById(R.id.bt_Update);
        lv_listView = (ListView) findViewById(R.id.lv_listView);
    }
    private void initEvents() {

    }
}
