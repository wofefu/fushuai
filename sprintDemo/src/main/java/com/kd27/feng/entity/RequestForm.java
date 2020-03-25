package com.kd27.feng.entity;

import java.time.LocalDate;

public class RequestForm {
    private int id;
    private String realName;
    private String idCard;
    private int userId;
    private Integer apiResult;
    private LocalDate creatDate;
    private String facadePath;
    private String backPath;
    private int Status;

    @Override
    public String toString() {
        return "requestForm{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", userId=" + userId +
                ", apiResult=" + apiResult +
                ", creatDate=" + creatDate +
                ", facadePath='" + facadePath + '\'' +
                ", backPath='" + backPath + '\'' +
                ", Status=" + Status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getApiResult() {
        return apiResult;
    }

    public void setApiResult(int apiResult) {
        this.apiResult = apiResult;
    }

    public LocalDate getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDate creatDate) {
        this.creatDate = creatDate;
    }

    public String getFacadePath() {
        return facadePath;
    }

    public void setFacadePath(String facadePath) {
        this.facadePath = facadePath;
    }

    public String getBackPath() {
        return backPath;
    }

    public void setBackPath(String backPath) {
        this.backPath = backPath;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
