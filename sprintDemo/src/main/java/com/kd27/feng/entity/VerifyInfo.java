package com.kd27.feng.entity;

import java.util.Map;

public class VerifyInfo {
    private String complete;
    private String gray_image;
    private String head_blurred;
    private String border_covered;
    private String id_number;
    private String name;
    private String validity;

    @Override
    public String toString() {
        return "VerifyInfo{" +
                "complete='" + complete + '\'' +
                ", gray_image='" + gray_image + '\'' +
                ", head_blurred='" + head_blurred + '\'' +
                ", border_covered='" + border_covered + '\'' +
                ", id_number='" + id_number + '\'' +
                ", name='" + name + '\'' +
                ", validity='" + validity + '\'' +
                '}';
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getGray_image() {
        return gray_image;
    }

    public void setGray_image(String gray_image) {
        this.gray_image = gray_image;
    }

    public String getHead_blurred() {
        return head_blurred;
    }

    public void setHead_blurred(String head_blurred) {
        this.head_blurred = head_blurred;
    }

    public String getBorder_covered() {
        return border_covered;
    }

    public void setBorder_covered(String border_covered) {
        this.border_covered = border_covered;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
