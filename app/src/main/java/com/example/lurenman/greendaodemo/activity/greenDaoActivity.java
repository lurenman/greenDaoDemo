package com.example.lurenman.greendaodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lurenman.greendaodemo.R;
import com.example.lurenman.greendaodemo.adapter.ListViewAdapter;
import com.example.lurenman.greendaodemo.dao.DbManager;
import com.example.lurenman.greendaodemo.dao.UserDao;
import com.example.lurenman.greendaodemo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 * 参考
 * http://www.jianshu.com/p/4e6d72e7f57a
 */

public class greenDaoActivity extends Activity {
    private static final String TAG = "greenDaoActivity";
    private Button bt_Insert;
    private Button bt_Delete;
    private Button bt_Query;
    private Button bt_Update;
    private ListView lv_listView;
    private ListViewAdapter mListViewAdapter;
    List<User> mDataArray = new ArrayList<User>();
    private UserDao userDao;
    private User userData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
        initViews();
        userDao = DbManager.getInstance().getDaoSession().getUserDao();
        initSomeings();
        initEvents();
    }

    private void initSomeings() {
        userData = new User();
        //这个主键id还是可以改的
        userData.setId((long) 5);
        userData.setName("测试");
        userData.setImage("aaaaaa");
        userData.setReward("10亿贝利");
        userData.setOccupation("aaaaaa");
        //刚进来时候我们先查下所有数据 如果size为零就先添加一些假数据
        List<User> users = userDao.loadAll();
        if (!users.isEmpty()) {
            mDataArray.addAll(users);
            mListViewAdapter.notifyDataSetChanged();
        } else {
            //说明是空的我们加入模拟一下数据
            User user1 = new User();
            user1.setName("路飞");
            user1.setImage("https://raw.githubusercontent.com/lurenman/greenDaoDemo/master/%E8%B5%84%E6%BA%90%E5%9B%BE%E7%89%87/lufei.jpg");
            user1.setReward("5亿贝利");
            user1.setOccupation("草帽海贼团船长");

            User user2 = new User();
            user2.setName("娜美");
            user2.setImage("https://raw.githubusercontent.com/lurenman/greenDaoDemo/master/%E8%B5%84%E6%BA%90%E5%9B%BE%E7%89%87/namei.jpg");
            user2.setReward("6千6百万贝利");
            user2.setOccupation("草帽海贼团驾驶员，颜值担当");

            User user3 = new User();
            user3.setName("索隆");
            user3.setImage("https://raw.githubusercontent.com/lurenman/greenDaoDemo/master/%E8%B5%84%E6%BA%90%E5%9B%BE%E7%89%87/suolong.jpg");
            user3.setReward("3亿2千万贝利");
            user3.setOccupation("草帽海贼团三大主力之一，剑客");

            userDao.insertOrReplace(user1);
            userDao.insertOrReplace(user2);
            userDao.insertOrReplace(user3);

            List<User> users1 = userDao.loadAll();
            mDataArray.addAll(users1);
            mListViewAdapter.notifyDataSetChanged();

        }

    }

    private void initViews() {
        bt_Insert = (Button) findViewById(R.id.bt_Insert);
        bt_Delete = (Button) findViewById(R.id.bt_Delete);
        bt_Query = (Button) findViewById(R.id.bt_Query);
        bt_Update = (Button) findViewById(R.id.bt_Update);
        lv_listView = (ListView) findViewById(R.id.lv_listView);
        mListViewAdapter = new ListViewAdapter(this, mDataArray);
        lv_listView.setAdapter(mListViewAdapter);
    }

    private void initEvents() {
        //插入数据
        bt_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //插入的时候也可已覆盖更新
                userData.setReward("11111亿贝利");
                userDao.insertOrReplace(userData);//这种插入虽然是覆盖插入但是id会自增长（除非指定id）

                List<User> users = userDao.loadAll();
                mDataArray.clear();
                mDataArray.addAll(users);
                mListViewAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "插入数据成功", Toast.LENGTH_SHORT).show();
            }
        });
        //删除
        bt_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除之后在删除不会蹦
                //userDao.deleteByKey((long) 1);//这个指定id键删除，所有id值不变 ,这个不管删没删除都不会蹦
                userDao.delete(userData);//这个实体所有属性应该都一样所以还是查出来，在把实体删掉比较好（因为id可能在变）


                List<User> users = userDao.loadAll();
                mDataArray.clear();
                mDataArray.addAll(users);
                mListViewAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "删除数据成功", Toast.LENGTH_SHORT).show();

            }
        });
        //查询数据
        bt_Query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> users = userDao.loadAll();
                Log.e(TAG, "-------" + users.size());
                Toast.makeText(getApplicationContext(), "查询数据看log", Toast.LENGTH_SHORT).show();

            }
        });
        //更新数据
        bt_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //更新的时候，如果数据已经删除，你传的这个实体userData，必须各项设置上值，否则崩掉
                userData.setReward("22222贝利");

                userDao.update(userData);

                List<User> users = userDao.loadAll();
                mDataArray.clear();
                mDataArray.addAll(users);
                mListViewAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "更新数据成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
