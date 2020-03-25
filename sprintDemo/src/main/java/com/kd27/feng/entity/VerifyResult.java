package com.kd27.feng.entity;

import org.bytedeco.javacpp.presets.opencv_core;

import java.util.Map;

public class VerifyResult {
     private String code;
     private VerifyInfo data;
     private String desc;
     private String sid;


    @Override
    public String toString() {
        return "VerifyResult{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", desc='" + desc + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VerifyInfo getData() {
        return data;
    }

    public void setData(VerifyInfo data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
