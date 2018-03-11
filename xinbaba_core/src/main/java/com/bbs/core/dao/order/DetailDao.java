package com.bbs.core.dao.order;

import com.bbs.core.bean.order.Detail;
import com.bbs.core.bean.order.DetailQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailDao {
    int countByExample(DetailQuery example);

    int deleteByExample(DetailQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Detail record);

    int insertSelective(Detail record);

    List<Detail> selectByExample(DetailQuery example);

    Detail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Detail record, @Param("example") DetailQuery example);

    int updateByExample(@Param("record") Detail record, @Param("example") DetailQuery example);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
}