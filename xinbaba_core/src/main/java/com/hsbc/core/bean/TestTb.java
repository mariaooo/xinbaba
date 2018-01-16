package com.hsbc.core.bean;

import java.util.Date;

/**
 * Created by ZhanShen on 2018/1/15.
 */
public class TestTb {
    private Integer id;
    private String name;
    private Date brithday;

    public TestTb(Integer id, String name, Date brithday) {
        this.id = id;
        this.name = name;
        this.brithday = brithday;
    }

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

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
