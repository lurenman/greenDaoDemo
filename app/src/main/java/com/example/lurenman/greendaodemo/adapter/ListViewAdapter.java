package com.example.lurenman.greendaodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lurenman.greendaodemo.R;
import com.example.lurenman.greendaodemo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    List<User> mDataArray = new ArrayList<User>();

    public ListViewAdapter(Context mContext, List<User> mDataArray) {
        this.mContext = mContext;
        this.mDataArray = mDataArray;
    }

    @Override
    public int getCount() {
        if (mDataArray == null) {
            return 0;
        } else {
            return mDataArray.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (mDataArray == null) {
            return null;
        } else {
            return mDataArray.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.lv_item, parent, false);
            holder.iv_image=(ImageView)convertView.findViewById(R.id.iv_image);
            holder.tv_name=(TextView)convertView.findViewById(R.id.tv_name);
            holder.tv_reward=(TextView)convertView.findViewById(R.id.tv_reward);
            holder.tv_occupation=(TextView)convertView.findViewById(R.id.tv_occupation);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (mDataArray!=null&&!mDataArray.isEmpty())
        {
            Glide.with(mContext).load(mDataArray.get(position).getImage()).centerCrop()
                    .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(holder.iv_image);
            holder.tv_name.setText("name:"+mDataArray.get(position).getName());
            holder.tv_reward.setText("悬赏:"+mDataArray.get(position).getReward());
            holder.tv_occupation.setText("角色："+mDataArray.get(position).getOccupation());

        }
        return convertView;
    }
    private class ViewHolder {
        private ImageView iv_image;
        private TextView tv_name;
        private TextView tv_reward;//悬赏
        private TextView tv_occupation;//角色

    }
}
