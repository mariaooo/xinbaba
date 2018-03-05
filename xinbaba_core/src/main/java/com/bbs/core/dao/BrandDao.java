package com.bbs.core.dao;

import com.bbs.core.bean.Brand;
import com.bbs.core.bean.BrandQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZhanShen on 2018/2/1.
 */
@Repository
public interface BrandDao {

    List<Brand> selectBrandListByQuery(BrandQuery brandQuery);

    Long selectBrandsCount(BrandQuery brandQuery);

    boolean insertBrand(Brand brand);

    void deleteBrand(Long[] ids);
}
