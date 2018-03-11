package com.bbs.core.dao.product;


import com.bbs.core.bean.product.Img;
import com.bbs.core.bean.product.ImgQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgDao {
    int countByExample(ImgQuery example);

    int deleteByExample(ImgQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Img record);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgQuery example);

    Img selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Img record, @Param("example") ImgQuery example);

    int updateByExample(@Param("record") Img record, @Param("example") ImgQuery example);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}