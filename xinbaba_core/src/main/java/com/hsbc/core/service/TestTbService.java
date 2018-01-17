package com.hsbc.core.service;

import com.hsbc.core.bean.TestTb;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZhanShen on 2018/1/17.
 */
@Transactional
public interface TestTbService {
    void addTestTb(TestTb tb);
}
