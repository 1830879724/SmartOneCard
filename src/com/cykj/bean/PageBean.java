package com.cykj.bean;

import java.util.List;

public class PageBean<T> {
    private  Integer curPage;
    private  Integer prepage;
    private  Integer nextPage;
    private  Integer totalPage;
    private  Integer totalRecords;
    private  Integer pageSize;
    private List<T> list;

    public PageBean(Integer curPage, Integer totalRecords, Integer pageSize){
        this.curPage = curPage;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;

        totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;

    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPrepage() {
        return curPage>1?curPage-1:1;
    }

    public void setPrepage(Integer prepage) {
        this.prepage = prepage;
    }

    public Integer getNextPage() {
        return curPage<totalPage?curPage+1:totalPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "curPage=" + curPage +
                ", prepage=" + prepage +
                ", nextPage=" + nextPage +
                ", totalPage=" + totalPage +
                ", totalRecords=" + totalRecords +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
