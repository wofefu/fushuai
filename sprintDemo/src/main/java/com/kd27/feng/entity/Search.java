package com.kd27.feng.entity;

public class Search {
    private String searchKeyWord;
    private String orderByType;
    private String status;
    private Integer offset;
    private Integer pageMax;
    private Integer pageIndex;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageMax() {
        return pageMax;
    }

    public void setPageMax(Integer pageMax) {
        this.pageMax = pageMax;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
