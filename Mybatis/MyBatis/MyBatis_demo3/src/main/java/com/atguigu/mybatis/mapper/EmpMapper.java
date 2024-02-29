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

    /**
     * 通过分步查询--查询部门及部门中所有的员工信息
     * 分步查询的第二步：根据did查询员工信息
     */
    List<Emp> getDepAndEmpByStepTwo(@Param("did") Integer did);
}
