package com.bbs.core.dao.user;


import com.bbs.core.bean.user.Employee;
import com.bbs.core.bean.user.EmployeeQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    int countByExample(EmployeeQuery example);

    int deleteByExample(EmployeeQuery example);

    int deleteByPrimaryKey(String username);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeQuery example);

    Employee selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}