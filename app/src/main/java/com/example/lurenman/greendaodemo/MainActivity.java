package com.example.lurenman.greendaodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lurenman.greendaodemo.activity.greenDaoActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_greendao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_greendao = (TextView) findViewById(R.id.tv_greendao);
        initEvents();
    }

    private void initEvents() {
        tv_greendao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, greenDaoActivity.class);
                startActivity(intent);
            }
        });
    }
}
