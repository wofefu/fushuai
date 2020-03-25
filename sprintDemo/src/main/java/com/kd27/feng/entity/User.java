package com.kd27.feng.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;
import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private String gender;
    private String home;
    private String birthday;
    private int attentions;
    private int liveId;
    private List<String> roleList;
    private String icon;
    private String myWord;


    public String getMyWord() {
        return myWord;
    }

    public void setMyWord(String myWord) {
        this.myWord = myWord;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss ")
    private Date registerTime;
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", home='" + home + '\'' +
                ", birthday=" + birthday +
                ", attentions=" + attentions +
                ", liveId=" + liveId +
                ", roleList=" + roleList +
                '}';
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAttentions() {
        return attentions;
    }

    public void setAttentions(int attentions) {
        this.attentions = attentions;
    }

    public int getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
