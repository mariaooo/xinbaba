package com.bbs.core.dao.brand;

import com.bbs.core.bean.brand.Brand;
import com.bbs.core.bean.brand.BrandQuery;
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

    void updateBrand(Brand brand);
    Brand selectBrandById(Long id);
}
