package com.bbs.core.dao.product;


import com.bbs.core.bean.product.Product;
import com.bbs.core.bean.product.ProductQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {
    int countByExample(ProductQuery example);

    int deleteByExample(ProductQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductQuery example);

    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}