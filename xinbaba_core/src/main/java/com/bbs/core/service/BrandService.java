package com.bbs.core.service;

import com.bbs.core.bean.Brand;
import com.bbs.core.bean.BrandQuery;
import com.bbs.core.bean.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhanShen on 2018/2/1.
 */
@Transactional
public interface BrandService {
    List<Brand> selectBrandListByQuery (BrandQuery brandQuery);
    Page<Brand> selectBrandPageByQuery (BrandQuery brandQuery);
    void insertBrand(Brand brand);
    void deleteBrand(Long[] ids);
}