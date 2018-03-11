package com.bbs.core.service.impl;

import com.bbs.core.bean.product.Feature;
import com.bbs.core.bean.product.FeatureQuery;
import com.bbs.core.dao.product.FeatureDao;
import com.bbs.core.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {
    @Autowired
    private FeatureDao featureDao;

    @Override
    public List<Feature> selectFeaturebyFeatureQuery(FeatureQuery featureQuery) {
        return featureDao.selectByExample(featureQuery);
    }
}
