package com.bbs.core.service.impl;

import com.bbs.core.bean.Brand;
import com.bbs.core.bean.BrandQuery;
import com.bbs.core.bean.Page;
import com.bbs.core.dao.BrandDao;
import com.bbs.core.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhanShen on 2018/2/1.
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    public List<Brand> selectBrandListByQuery(BrandQuery brandQuery) {
        return brandDao.selectBrandListByQuery(brandQuery);
    }

    @Override
    public Page<Brand> selectBrandPageByQuery(BrandQuery brandQuery) {
        Page<Brand> page = new Page<Brand>();
        page.setPageNo(brandQuery.getPageNo());
        Integer pageSize = brandQuery.getPageSize();
        page.setPageSize(pageSize);
        Long totalSize = brandDao.selectBrandsCount(brandQuery);
        page.setTotalSize(totalSize);
        int pageTotal;
        if (totalSize%pageSize != 0) {
            pageTotal = (int) (totalSize/pageSize + 1);
        }else {
            pageTotal = (int) (totalSize/pageSize);
        }
        page.setPageTotal(pageTotal);
        if (brandQuery.getPageNo() > pageTotal) {
            brandQuery.setPageNo(pageTotal);
        }
        List<Brand> brands = brandDao.selectBrandListByQuery(brandQuery);
        page.setList(brands);
        return page;
    }

    @Override
    public void insertBrand(Brand brand) {
        brandDao.insertBrand(brand);
    }

    @Override
    public void deleteBrand(Long[] ids) {
        brandDao.deleteBrand(ids);
    }
}
