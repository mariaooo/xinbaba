package com.bbs.core.dao.product;


import com.bbs.core.bean.product.Sku;
import com.bbs.core.bean.product.SkuQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuDao {
    int countByExample(SkuQuery example);

    int deleteByExample(SkuQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    List<Sku> selectByExample(SkuQuery example);

    Sku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuQuery example);

    int updateByExample(@Param("record") Sku record, @Param("example") SkuQuery example);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}