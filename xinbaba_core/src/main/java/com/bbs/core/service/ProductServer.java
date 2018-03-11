package com.bbs.core.service;

import com.bbs.core.bean.Page;
import com.bbs.core.bean.product.Product;
import com.bbs.core.bean.product.ProductQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Service
public interface ProductServer {
    // return page instance
    Page<Product> selectProductByPage(ProductQuery productQuery);
    // return all List
    List<Product> selectProductByProductQuery(ProductQuery productQuery);
    //update product info by one
    int updateProduct(Product product);
    //update product info by list
    void updateProduct(List<Product> products);
    //add product
    int insertProduct(Product product);
    // select one
    Product selectProductById(Long id);
}
