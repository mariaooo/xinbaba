package com.hsbc.core.service;

import com.hsbc.core.bean.TestTb;
import com.hsbc.core.dao.TestTbDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhanShen on 2018/1/17.
 */
@Service
public class TestTbServiceImpl implements TestTbService {

    @Autowired
    private TestTbDao td;

    @Override
    @Test
    public void addTestTb(TestTb tb) {
        td.addTestTb(tb);
    }
}
