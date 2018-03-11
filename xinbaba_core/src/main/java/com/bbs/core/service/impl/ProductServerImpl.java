package com.bbs.core.service.impl;

import com.bbs.core.bean.Page;
import com.bbs.core.bean.product.Product;
import com.bbs.core.bean.product.ProductQuery;
import com.bbs.core.dao.product.ProductDao;
import com.bbs.core.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Service
public class ProductServerImpl implements ProductServer {

    @Autowired
    private ProductDao productDao;

    @Override
    public Page<Product> selectProductByPage(ProductQuery productQuery) {
        Page<Product> productPage;
        int counts = productDao.countByExample(productQuery);
        if (counts > 0) {
            Integer pageSize = productQuery.getPageSize();
            Integer totalPage;
            if (counts % pageSize > 0) {
                totalPage = counts / pageSize + 1;
            } else {
                totalPage = counts / pageSize;
            }
            // pageNo > totalPage
            if (productQuery.getPageNo() > totalPage) {
                productQuery.setPageNo(totalPage);
            }
            // getList
            List<Product> products = productDao.selectByExample(productQuery);
            productPage = new Page<Product>(productQuery.getPageNo(), totalPage, pageSize, (long) counts, products);
        } else {
            productPage = new Page<>(0, 0, 0, 0L, null);
        }

        return productPage;
    }

    @Override
    public List<Product> selectProductByProductQuery(ProductQuery productQuery) {
        return productDao.selectByExample(productQuery);
    }

    @Override
    public int updateProduct(Product product) {
        int i = productDao.updateByPrimaryKey(product);
        return i;
    }

    @Override
    public void updateProduct(List<Product> products) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            int i = this.updateProduct(iterator.next());
        }
    }

    @Override
    public int insertProduct(Product product) {
        int i = productDao.insertSelective(product);
        return i;
    }

    @Override
    public Product selectProductById(Long id) {
        return productDao.selectByPrimaryKey(id);
    }
}
