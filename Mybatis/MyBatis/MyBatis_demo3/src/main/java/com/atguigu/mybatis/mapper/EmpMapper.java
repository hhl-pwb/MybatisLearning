package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询员工信息
     */
    List<Emp> getAllEmp();

    Emp getEmpAndDept(Integer eid);

    /**
     * 分布查询
     */
    Emp getEmpAndDeptStepOne(@Param("eid") Integer eid);
}
