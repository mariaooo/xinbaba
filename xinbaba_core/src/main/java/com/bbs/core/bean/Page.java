package com.bbs.core.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhanShen on 2018/2/1.
 */
public class Page<T> implements Serializable {
    private Integer pageNo;
    private Integer pageTotal;
    private Integer pageSize;
    private Long totalSize;
    private List<T> list;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Long totalSize, List<T> list) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
    }
}
