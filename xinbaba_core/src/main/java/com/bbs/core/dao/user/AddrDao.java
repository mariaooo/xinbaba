package com.bbs.core.dao.user;


import com.bbs.core.bean.user.Addr;
import com.bbs.core.bean.user.AddrQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddrDao {
    int countByExample(AddrQuery example);

    int deleteByExample(AddrQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Addr record);

    int insertSelective(Addr record);

    List<Addr> selectByExample(AddrQuery example);

    Addr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Addr record, @Param("example") AddrQuery example);

    int updateByExample(@Param("record") Addr record, @Param("example") AddrQuery example);

    int updateByPrimaryKeySelective(Addr record);

    int updateByPrimaryKey(Addr record);
}