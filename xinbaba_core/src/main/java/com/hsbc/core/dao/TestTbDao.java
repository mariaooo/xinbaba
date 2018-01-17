package com.hsbc.core.dao;

import com.hsbc.core.bean.TestTb;
import org.springframework.stereotype.Repository;

/**
 * Created by ZhanShen on 2018/1/15.
 */
@Repository
public interface TestTbDao {
    void addTestTb(TestTb tb);
}

