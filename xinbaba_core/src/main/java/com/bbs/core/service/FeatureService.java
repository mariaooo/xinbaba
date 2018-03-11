package com.bbs.core.service;

import com.bbs.core.bean.product.Feature;
import com.bbs.core.bean.product.FeatureQuery;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
public interface FeatureService {
    List<Feature> selectFeaturebyFeatureQuery(FeatureQuery featureQuery);
}
