package com.example.lurenman.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: baiyang.
 * Created on 2017/11/8.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private long id;
    @NotNull//表示注解不能为null
    @Unique // 唯一，默认索引
    private String name;
    private String image;
    private String occupation;//职业
    private String reward;//悬赏
    @Generated(hash = 1116637426)
    public User(long id, @NotNull String name, String image, String occupation,
            String reward) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.occupation = occupation;
        this.reward = reward;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getOccupation() {
        return this.occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getReward() {
        return this.reward;
    }
    public void setReward(String reward) {
        this.reward = reward;
    }

}
