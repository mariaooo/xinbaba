package com.bbs.core.dao.user;


import com.bbs.core.bean.user.Buyer;
import com.bbs.core.bean.user.BuyerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerDao {
    int countByExample(BuyerQuery example);

    int deleteByExample(BuyerQuery example);

    int deleteByPrimaryKey(String username);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    List<Buyer> selectByExample(BuyerQuery example);

    Buyer selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Buyer record, @Param("example") BuyerQuery example);

    int updateByExample(@Param("record") Buyer record, @Param("example") BuyerQuery example);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);
}