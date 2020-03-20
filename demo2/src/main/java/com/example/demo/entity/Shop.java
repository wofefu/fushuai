package com.example.demo.entity;

public class Shop {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * adminId
     */
    private Integer adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}